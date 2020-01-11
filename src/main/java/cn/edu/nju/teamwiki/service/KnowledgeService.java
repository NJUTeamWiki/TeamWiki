package cn.edu.nju.teamwiki.service;

import cn.edu.nju.teamwiki.model.Knowledge;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author: xuyangchen
 * @date: 2020/1/7
 */

public interface KnowledgeService {

    List<Knowledge> getAllKnowledge() throws Exception;

    void uploadKnowledge(MultipartFile file) throws Exception;

    void updateKnowledge(String knowledgeId, MultipartFile file);

    void removeKnowledge(String knowledgeId);

}
