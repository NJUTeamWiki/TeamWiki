package cn.edu.nju.teamwiki.service.impl;

import cn.edu.nju.teamwiki.api.ResultCode;
import cn.edu.nju.teamwiki.api.vo.CategoryVO;
import cn.edu.nju.teamwiki.api.vo.KnowledgeVO;
import cn.edu.nju.teamwiki.config.TeamWikiConfig;
import cn.edu.nju.teamwiki.jooq.Tables;
import cn.edu.nju.teamwiki.jooq.tables.daos.CategoryDao;
import cn.edu.nju.teamwiki.jooq.tables.daos.KnowledgeDao;
import cn.edu.nju.teamwiki.jooq.tables.pojos.Document;
import cn.edu.nju.teamwiki.jooq.tables.pojos.Knowledge;
import cn.edu.nju.teamwiki.service.DocumentService;
import cn.edu.nju.teamwiki.service.KnowledgeService;
import cn.edu.nju.teamwiki.service.ServiceException;
import cn.edu.nju.teamwiki.util.Constants;
import cn.edu.nju.teamwiki.util.DBUtils;
import cn.edu.nju.teamwiki.util.StorageUtils;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: xuyangchen
 * @date: 2020/1/7
 */
@Service
public class KnowledgeServiceImpl implements KnowledgeService {

    private static final Logger LOG = LoggerFactory.getLogger(KnowledgeServiceImpl.class);

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private KnowledgeDao knowledgeDao;

    @Autowired
    private DocumentService documentService;

    @Autowired
    private DSLContext dslContext;

    @Autowired
    private TeamWikiConfig twConfig;

    @Override
    public KnowledgeVO getKnowledge(String knowledgeId) {
        Knowledge knowledge = knowledgeDao.fetchOneByKId(Integer.valueOf(knowledgeId));
        return new KnowledgeVO(knowledge, getKnowledgeDocuments(knowledge));
    }

    @Override
    public List<CategoryVO> getAllKnowledge() {
        return categoryDao.findAll()
                .stream()
                .map(category -> new CategoryVO(category,
                        knowledgeDao.fetchByCategory(category.getCategoryId())
                                .stream()
                                .map(knowledge -> new KnowledgeVO(knowledge, getKnowledgeDocuments(knowledge)))
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    @Override
    public KnowledgeVO createKnowledge(String categoryId, String knowledgeName, String userId) {
        List<Knowledge> knowledges = knowledgeDao.fetchByCategory(Integer.valueOf(categoryId));
        for (Knowledge knowledge : knowledges) {
            if (knowledgeName.equals(knowledge.getKName())) {
                throw new ServiceException(ResultCode.SPECIFIED_KNOWLEDGE_EXISTS);
            }
        }

        Knowledge knowledge = new Knowledge();
        knowledge.setKName(knowledgeName);
        knowledge.setCategory(Integer.valueOf(categoryId));
        knowledge.setPredefined(false);
        knowledge.setCreator(Integer.valueOf(userId));
        knowledgeDao.insert(knowledge);

        // 插入后的Knowledge才有id
        Knowledge latest = getKnowledge(knowledgeName, categoryId);

        return new KnowledgeVO(latest);
    }

    @Override
    public KnowledgeVO renameKnowledge(String knowledgeId, String newName, String userId) {
        Knowledge knowledge = knowledgeDao.fetchOneByKId(Integer.valueOf(knowledgeId));

        checkUser(knowledge, userId);

        knowledge.setKName(newName);
        knowledgeDao.update(knowledge);

        Knowledge latest = knowledgeDao.fetchOneByKId(Integer.valueOf(knowledgeId));
        return new KnowledgeVO(latest, getKnowledgeDocuments(latest));
    }

    @Override
    public KnowledgeVO removeKnowledge(String knowledgeId, String userId) {
        Knowledge knowledge = knowledgeDao.fetchOneByKId(Integer.valueOf(knowledgeId));

        checkUser(knowledge, userId);

        // 删除文件
        Path knowledgePath = Paths.get(twConfig.knowledgeDir,
                knowledge.getCategory().toString(),
                knowledge.getKId().toString());
        File knowledgeDir = knowledgePath.toFile();
        if (knowledgeDir.exists()) {
            if (!StorageUtils.deleteFile(knowledgePath)) {
                throw new ServiceException(ResultCode.SYSTEM_FILE_ERROR);
            }
        }

        // 删除数据库中的数据
        knowledgeDao.delete(knowledge);

        List<Document> documents = getKnowledgeDocuments(knowledge);
        for (Document document : documents) {
            documentService.deleteDocument(document.getDId(), userId);
        }

        return new KnowledgeVO(knowledge);
    }

    @Override
    public void uploadDocumentToKnowledge(String knowledgeId, MultipartFile file, String userId) {
        String uploadFileName = file.getOriginalFilename();
        if (uploadFileName == null || uploadFileName.isEmpty()) {
            throw new ServiceException(ResultCode.PARAM_INVALID_UPLOAD_FILE);
        }

        Path storagePath = Paths.get(twConfig.knowledgeDir, DBUtils.randomUUID(), uploadFileName);
        Path urlPath = storagePath.relativize(Paths.get(twConfig.docDir));
        LOG.info("Knowledge [" + knowledgeId + "]'s file will be stored as [" + storagePath + "]");
        // 将文件写入到目标路径中
        if (!StorageUtils.storeMultipartFile(storagePath, file)){
            throw new ServiceException(ResultCode.SYSTEM_FILE_ERROR);
        }

        documentService.createDocument(uploadFileName, userId, knowledgeId, Constants.SOURCE_KNOWLEDGE, urlPath.toString());
    }

    private void checkUser(Knowledge knowledge, String userId) {
        if (knowledge.getPredefined()) {
            throw new ServiceException(ResultCode.PERMISSION_NO_MODIFY);
        }
        if (knowledge.getCreator() != null && !userId.equals(String.valueOf(knowledge.getCreator()))) {
            throw new ServiceException(ResultCode.PERMISSION_NO_MODIFY);
        }
    }

    private List<Document> getKnowledgeDocuments(Knowledge knowledge) {
        return dslContext.selectFrom(Tables.DOCUMENT)
                .where(Tables.DOCUMENT.SOURCE_ID.eq(knowledge.getKId()))
                .and(Tables.DOCUMENT.SOURCE_TYPE.eq(Constants.SOURCE_KNOWLEDGE))
                .fetchInto(Document.class);
    }

    private Knowledge getKnowledge(String knowledgeName, String categoryId) {
        return dslContext.selectFrom(Tables.KNOWLEDGE)
                .where(Tables.KNOWLEDGE.CATEGORY.eq(Integer.valueOf(categoryId)))
                .and(Tables.KNOWLEDGE.K_NAME.eq(knowledgeName))
                .fetchOneInto(Knowledge.class);
    }
}
