package cn.edu.nju.teamwiki.service;

import cn.edu.nju.teamwiki.api.vo.ShareVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author: zhoushiqi
 * @date: 2020/2/5
 */
public interface ShareService {
    List<ShareVO> getAllShares();

    List<ShareVO> getSharesByUserId(String userId);

    List<ShareVO> getSharesByTitle(String shareTitle);

    ShareVO createShare(String shareTitle, String shareContent,
                        String userId, MultipartFile file);

    ShareVO updateShare(String shareId, String shareTitle,
                        String shareContent, String userId);

    ShareVO deleteShare(String shareId, String userId);

}
