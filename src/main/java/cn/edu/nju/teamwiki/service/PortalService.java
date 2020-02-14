package cn.edu.nju.teamwiki.service;

import cn.edu.nju.teamwiki.api.vo.PortalVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author: zhoushiqi
 * @date: 2020/2/5
 */
public interface PortalService {
    void createPortal(String portalName, String portalLink)throws ServiceException;

    void deletePortal(String portalId) throws ServiceException;

    void updatePortal(String portalId, String portalName,
                      String portalLink) throws ServiceException;

    void updateIcon(String portalId, MultipartFile iconFile) throws ServiceException;

    List<PortalVO> getAllPortal() throws ServiceException;

    PortalVO getPortalById(String portalId) throws ServiceException;

}
