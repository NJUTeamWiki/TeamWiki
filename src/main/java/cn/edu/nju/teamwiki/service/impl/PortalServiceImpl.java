package cn.edu.nju.teamwiki.service.impl;

import cn.edu.nju.teamwiki.api.vo.PortalVO;
import cn.edu.nju.teamwiki.jooq.tables.daos.PortalDao;
import cn.edu.nju.teamwiki.jooq.tables.pojos.Portal;
import cn.edu.nju.teamwiki.service.PortalService;
import cn.edu.nju.teamwiki.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: zhoushiqi
 * @date: 2020/2/8
 */
@Service
public class PortalServiceImpl implements PortalService{

    @Autowired
    private PortalDao portalDao;

    @Override
    public void createPortal(String portalName, String portalLink, String portalIcon) throws ServiceException {
        Portal portal = new Portal();
        portal.setPortalName(portalName);
        portal.setPortalLink(portalLink);
        portal.setPortalIcon(portalIcon);
        portalDao.insert(portal);
    }

    @Override
    public void deletePortal(String portalId) throws ServiceException {
        portalDao.deleteById(Integer.valueOf(portalId));
    }

    @Override
    public void updatePortal(String portalId, String portalName, String portalLink, String portalIcon) throws ServiceException {
        Portal portal = portalDao.fetchOneByPortalId(Integer.valueOf(portalId));
        portal.setPortalName(portalName);
        portal.setPortalLink(portalLink);
        portal.setPortalIcon(portalIcon);
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
}
