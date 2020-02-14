package cn.edu.nju.teamwiki.service.impl;

import cn.edu.nju.teamwiki.api.vo.ShareVO;
import cn.edu.nju.teamwiki.jooq.tables.daos.ShareDao;
import cn.edu.nju.teamwiki.jooq.tables.pojos.Share;
import cn.edu.nju.teamwiki.service.ServiceException;
import cn.edu.nju.teamwiki.service.ShareService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: zhoushiqi
 * @date: 2020/2/5
 */
@Service
public class ShareServiceImpl implements ShareService {

    private static final Logger LOG = LoggerFactory.getLogger(ShareServiceImpl.class);

    @Autowired
    private ShareDao shareDao;

    @Override
    public List<ShareVO> getAllShares() throws ServiceException {
        return shareDao.findAll()
                .stream()
                .map(share -> new ShareVO(share))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShareVO> getSharesByUserId(String userId) throws ServiceException {
        return  shareDao.fetchByShareUser(Integer.valueOf(userId))
                .stream()
                .map(share -> new ShareVO(share))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShareVO> getSharesByTitle(String shareTitle) throws ServiceException {
        return shareDao.fetchByShareTitle(shareTitle)
                .stream()
                .map(share -> new ShareVO(share))
                .collect(Collectors.toList());
    }

    @Override
    public void createShare(String shareTitle, String shareContent, String userId) throws ServiceException {
        Share share = new Share();
        share.setShareTitle(shareTitle);
        share.setShareContent(shareContent);
        share.setShareUser(Integer.valueOf(userId));
        share.setShareTime(LocalDateTime.now());
        shareDao.insert(share);
    }

    @Override
    public void updateShare(String shareId, String shareTitle, String shareContent, String userId) throws ServiceException{
        Share share = shareDao.fetchOneByShareId(Integer.valueOf(shareId));
        share.setShareUser(Integer.valueOf(userId));
        share.setShareTitle(shareTitle);
        share.setShareContent(shareContent);
        share.setShareTime(LocalDateTime.now());
        shareDao.update(share);
    }

    @Override
    public void deleteShare(String shareId) throws ServiceException {
        shareDao.deleteById(Integer.valueOf(shareId));
    }
}
