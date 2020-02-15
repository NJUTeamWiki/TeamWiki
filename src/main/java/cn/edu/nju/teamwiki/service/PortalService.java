package cn.edu.nju.teamwiki.service;

import cn.edu.nju.teamwiki.api.vo.PortalVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author: zhoushiqi
 * @date: 2020/2/5
 */
public interface PortalService {
    PortalVO createPortal(String portalName, String portalLink)throws ServiceException;

    PortalVO deletePortal(String portalId) throws ServiceException;

    PortalVO updatePortal(String portalId, String portalName,
                      String portalLink) throws ServiceException;

    void updateIcon(String portalId, MultipartFile iconFile) throws ServiceException;

    List<PortalVO> getAllPortal() throws ServiceException;

    PortalVO getPortalById(String portalId) throws ServiceException;

}
