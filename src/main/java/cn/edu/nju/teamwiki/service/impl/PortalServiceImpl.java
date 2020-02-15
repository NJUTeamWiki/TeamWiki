package cn.edu.nju.teamwiki.service.impl;

import cn.edu.nju.teamwiki.api.ResultCode;
import cn.edu.nju.teamwiki.api.vo.PortalVO;
import cn.edu.nju.teamwiki.config.TeamWikiConfig;
import cn.edu.nju.teamwiki.jooq.tables.daos.PortalDao;
import cn.edu.nju.teamwiki.jooq.tables.pojos.Portal;
import cn.edu.nju.teamwiki.service.PortalService;
import cn.edu.nju.teamwiki.service.ServiceException;
import cn.edu.nju.teamwiki.util.StorageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @Author: zhoushiqi
 * @date: 2020/2/8
 */
@Service
public class PortalServiceImpl implements PortalService{
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private PortalDao portalDao;

    @Autowired
    private TeamWikiConfig twConfig;

    @Override
    public void createPortal(String portalName, String portalLink) throws ServiceException {
        Portal portal = new Portal();
        portal.setPortalName(portalName);
        portal.setPortalLink(portalLink);
        portalDao.insert(portal);
    }

    @Override
    public void deletePortal(String portalId) throws ServiceException {
        portalDao.deleteById(Integer.valueOf(portalId));
    }

    @Override
    public void updatePortal(String portalId, String portalName, String portalLink) throws ServiceException {
        Portal portal = portalDao.fetchOneByPortalId(Integer.valueOf(portalId));
        portal.setPortalName(portalName);
        portal.setPortalLink(portalLink);
        portalDao.update(portal);
    }

    @Override
    public List<PortalVO> getAllPortal() throws ServiceException {
        return portalDao.findAll()
                .stream()
                .map(portal -> new PortalVO(portal))
                .collect(Collectors.toList());
    }

    @Override
    public PortalVO getPortalById(String portalId) throws ServiceException {
        return new PortalVO(portalDao.fetchOneByPortalId(Integer.valueOf(portalId)));
    }

    @Override
    public void updateIcon(String portalId, MultipartFile iconFile) throws ServiceException {
        Portal portal = portalDao.fetchOneByPortalId(Integer.valueOf(portalId));

        String fileName = iconFile.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String newFileName = portalId + UUID.randomUUID().toString().substring(0, 4) + suffixName;

        File file = Paths.get(twConfig.storagePath, StorageUtil.ICON_PATH, newFileName).toFile();
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        try {
            LOG.info("Icon will be stored as [" + file.getPath() + "].");
            iconFile.transferTo(file);
        } catch (IOException e) {
            LOG.error(e.getMessage());
            throw new ServiceException(ResultCode.SYSTEM_FILE_ERROR);
        }

//        portal.setPortalIcon(StorageUtil.ICON_PATH + newFileName);
        portalDao.update(portal);
    }
}
