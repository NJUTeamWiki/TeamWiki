package cn.edu.nju.teamwiki.service;

import cn.edu.nju.teamwiki.api.vo.KnowledgeVO;

import java.util.List;

/**
 * @author: xuyangchen
 * @date: 2020/1/16
 */
public interface KnowledgeService {

    KnowledgeVO getKnowledge(String knowledgeId);

    List<KnowledgeVO> getAllKnowledge();

    KnowledgeVO createKnowledge(String categoryId, String knowledgeName, String userId) throws ServiceException;

    KnowledgeVO renameKnowledge(String knowledgeId, String newName, String userId) throws ServiceException;

    KnowledgeVO removeKnowledge(String knowledgeId, String userId) throws ServiceException;

}
