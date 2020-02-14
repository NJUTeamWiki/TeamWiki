package cn.edu.nju.teamwiki.service;

import cn.edu.nju.teamwiki.api.vo.ShareVO;

import java.util.List;

/**
 * @Author: zhoushiqi
 * @date: 2020/2/5
 */
public interface ShareService {
    List<ShareVO> getAllShares() throws ServiceException;

    List<ShareVO> getSharesByUserId(String userId) throws ServiceException;

    List<ShareVO> getSharesByTitle(String shareTitle) throws ServiceException;

    void createShare(String shareTitle, String shareContent,
                     String userId) throws ServiceException;

    void updateShare(String shareId, String shareTitle,
                     String shareContent, String userId) throws ServiceException;

    void deleteShare(String shareId) throws ServiceException;

}
