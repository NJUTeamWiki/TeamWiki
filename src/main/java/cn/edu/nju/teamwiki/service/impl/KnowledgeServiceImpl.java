package cn.edu.nju.teamwiki.service.impl;

import cn.edu.nju.teamwiki.config.SystemConfig;
import cn.edu.nju.teamwiki.model.Knowledge;
import cn.edu.nju.teamwiki.service.KnowledgeService;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: xuyangchen
 * @date: 2020/1/7
 */
@Service
public class KnowledgeServiceImpl implements KnowledgeService {

    @Autowired
    DSLContext dsl;

    private static final Logger LOG = LoggerFactory.getLogger(KnowledgeService.class);

    private final SystemConfig systemConfig;

    public KnowledgeServiceImpl(SystemConfig systemConfig) {
        this.systemConfig = systemConfig;
    }

    @Override
    public List<Knowledge> getAllKnowledge() throws Exception {
        List<Knowledge> res = new LinkedList<>();
        File storageDir = new File(systemConfig.storagePath);
        for (File file : storageDir.listFiles()) {
            if (file.isDirectory()) {
                continue;
            }
            Knowledge knowledge = new Knowledge();
            knowledge.setName(file.getName());
            res.add(knowledge);
        }
        return res;
    }

    @Override
    public void uploadKnowledge(MultipartFile file) throws Exception {
        //获得文件的字节流
        byte[] bytes = file.getBytes();
        //获得文件保存的路径对象
        Path path = Paths.get(systemConfig.storagePath + file.getOriginalFilename());
        LOG.debug(path.toString());
        //将文件写入到目标路径中
        Files.write(path, bytes);
    }

    @Override
    public void updateKnowledge(String knowledgeId, MultipartFile file) {

    }

    @Override
    public void removeKnowledge(String knowledgeId) {

    }

    cn.edu.nju.teamwiki.generator.tables.Knowledge knowledge = cn.edu.nju.teamwiki.generator.tables.Knowledge.KNOWLEDGE.as("k");

    @Override
    public void downloadKnowledge(HttpServletResponse response, int k_id) throws Exception {
        System.out.println("k_id: " + k_id);
        List<cn.edu.nju.teamwiki.generator.tables.pojos.Knowledge> result = dsl.select(knowledge.K_ID, knowledge.K_NAME, knowledge.STORAGE_PATH,
                knowledge.UPLOADER, knowledge.UPLOAD_TIME)
                .from(knowledge)
                .where(knowledge.K_ID.eq(k_id))
                .fetch()
                .into(cn.edu.nju.teamwiki.generator.tables.pojos.Knowledge.class);
        cn.edu.nju.teamwiki.generator.tables.pojos.Knowledge knowledge = result.get(0);
        String fileName = knowledge.getKName();
        String path = knowledge.getStoragePath();
        File file = new File(path);

        InputStream fis = null;

        try{
            fis = new FileInputStream(file);
            response.reset();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/force-download");
            response.addHeader("Content-Disposition",
                    "attachment;filename=" + new String(fileName.getBytes("utf-8"), "iso8859-1"));
            response.setHeader("Content-Length", String.valueOf(file.length()));

            byte[] b = new byte[1024];
            int len;
            while ((len = fis.read(b)) != -1){
                response.getOutputStream().write(b, 0, len);
            }
            response.flushBuffer();
            fis.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}
