package cn.edu.nju.teamwiki.service;

import cn.edu.nju.teamwiki.api.vo.CategoryVO;
import cn.edu.nju.teamwiki.api.vo.KnowledgeVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author: xuyangchen
 * @date: 2020/1/16
 */
public interface KnowledgeService {

    KnowledgeVO getKnowledge(String knowledgeId);

    List<CategoryVO> getAllKnowledge();

    KnowledgeVO createKnowledge(String categoryId, String knowledgeName, String userId);

    KnowledgeVO renameKnowledge(String knowledgeId, String newName, String userId);

    KnowledgeVO removeKnowledge(String knowledgeId, String userId);

    KnowledgeVO uploadDocumentToKnowledge(String knowledgeId, MultipartFile file, String userId);

    List<KnowledgeVO> recommendKnowledge(String userId);

}
