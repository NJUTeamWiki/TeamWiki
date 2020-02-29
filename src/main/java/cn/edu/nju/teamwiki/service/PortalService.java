package cn.edu.nju.teamwiki.service;

import cn.edu.nju.teamwiki.api.vo.PortalVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author: zhoushiqi
 * @date: 2020/2/5
 */
public interface PortalService {
    PortalVO createPortal(String portalName, String portalLink);

    PortalVO deletePortal(String portalId);

    PortalVO updatePortal(String portalId, String portalName,
                          String portalLink);

    void updateIcon(String portalId, MultipartFile iconFile);

    List<PortalVO> getAllPortal();

    PortalVO getPortalById(String portalId);

}
