package cn.edu.nju.teamwiki.service.impl;

import cn.edu.nju.teamwiki.api.ResultCode;
import cn.edu.nju.teamwiki.api.vo.KnowledgeVO;
import cn.edu.nju.teamwiki.config.SystemConfig;
import cn.edu.nju.teamwiki.jooq.Tables;
import cn.edu.nju.teamwiki.jooq.tables.pojos.Document;
import cn.edu.nju.teamwiki.jooq.tables.daos.DocumentDao;
import cn.edu.nju.teamwiki.jooq.tables.daos.KnowledgeDao;
import cn.edu.nju.teamwiki.jooq.tables.pojos.Knowledge;
import cn.edu.nju.teamwiki.service.KnowledgeService;
import cn.edu.nju.teamwiki.service.ServiceException;
import cn.edu.nju.teamwiki.util.Constants;
import cn.edu.nju.teamwiki.util.StorageUtil;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
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
    private KnowledgeDao knowledgeDao;

    @Autowired
    private DocumentDao documentDao;

    @Autowired
    private DSLContext dslContext;

    @Autowired
    private SystemConfig systemConfig;

    @Override
    public KnowledgeVO getKnowledge(String knowledgeId) {
        Knowledge knowledge = knowledgeDao.fetchOneByKId(Integer.valueOf(knowledgeId));
        return new KnowledgeVO(knowledge, getKnowledgeDocuments(knowledge));
    }

    @Override
    public List<KnowledgeVO> getAllKnowledge() {
        return knowledgeDao.findAll()
                .stream()
                .map(knowledge -> {
                    List<Document> documents = getKnowledgeDocuments(knowledge);
                    return new KnowledgeVO(knowledge, documents);
                })
                .collect(Collectors.toList());
    }

    @Override
    public KnowledgeVO createKnowledge(String categoryId, String knowledgeName, String userId) throws ServiceException {
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

        Path knowledgePath = StorageUtil.getKnowledgeStoragePath(systemConfig.storagePath,
                categoryId, latest.getKId().toString());
        if (knowledgePath.toFile().mkdirs()) {
            return new KnowledgeVO(latest);
        } else {
            knowledgeDao.delete(latest);
            throw new ServiceException(ResultCode.SYSTEM_FILE_ERROR);
        }
    }

    @Override
    public KnowledgeVO renameKnowledge(String knowledgeId, String newName, String userId) throws ServiceException {
        Knowledge knowledge = knowledgeDao.fetchOneByKId(Integer.valueOf(knowledgeId));
        if (knowledge.getCreator() == null || !userId.equals(knowledge.getCreator().toString())) {
            throw new ServiceException(ResultCode.PERMISSION_NO_MODIFY);
        }
        if (knowledge.getPredefined()) {
            throw new ServiceException(ResultCode.PERMISSION_NO_MODIFY);
        }
        knowledge.setKName(newName);
        knowledgeDao.update(knowledge);

        Knowledge latest = knowledgeDao.fetchOneByKId(Integer.valueOf(knowledgeId));
        return new KnowledgeVO(latest, getKnowledgeDocuments(latest));
    }

    @Override
    public KnowledgeVO removeKnowledge(String knowledgeId, String userId) throws ServiceException {
        Knowledge knowledge = knowledgeDao.fetchOneByKId(Integer.valueOf(knowledgeId));
        if (knowledge.getCreator() == null || !userId.equals(knowledge.getCreator().toString())) {
            throw new ServiceException(ResultCode.PERMISSION_NO_MODIFY);
        }

        // 删除文件
        Path knowledgePath = StorageUtil.getKnowledgeStoragePath(systemConfig.storagePath,
                knowledge.getCategory().toString(), knowledge.getKId().toString());
        File knowledgeDir = knowledgePath.toFile();
        if (knowledgeDir.exists()) {
            try {
                FileUtils.deleteDirectory(knowledgePath.toFile());
            } catch (IOException e) {
                LOG.error(e.getMessage());
                throw new ServiceException(ResultCode.SYSTEM_FILE_ERROR);
            }
        }

        // 删除数据库中的数据
        knowledgeDao.delete(knowledge);

        List<Document> documents = getKnowledgeDocuments(knowledge);
        documentDao.delete(documents);

        return new KnowledgeVO(knowledge);
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
