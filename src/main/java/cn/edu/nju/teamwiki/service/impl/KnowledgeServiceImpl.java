package cn.edu.nju.teamwiki.service.impl;

import cn.edu.nju.teamwiki.config.SystemConfig;
import cn.edu.nju.teamwiki.model.Knowledge;
import cn.edu.nju.teamwiki.service.KnowledgeService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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
        //将文件写入到目标路径中
        Files.write(path, bytes, StandardOpenOption.CREATE);

    }

    @Override
    public void updateKnowledge(String knowledgeId, MultipartFile file) {

    }

    @Override
    public void removeKnowledge(String knowledgeId) {

    }
}
