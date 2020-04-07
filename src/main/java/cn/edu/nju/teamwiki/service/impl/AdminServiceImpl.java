package cn.edu.nju.teamwiki.service.impl;

import cn.edu.nju.teamwiki.api.ResultCode;
import cn.edu.nju.teamwiki.api.vo.UserVO;
import cn.edu.nju.teamwiki.config.TeamWikiConfig;
import cn.edu.nju.teamwiki.jooq.tables.daos.RoleDao;
import cn.edu.nju.teamwiki.jooq.tables.daos.UserDao;
import cn.edu.nju.teamwiki.jooq.tables.pojos.User;
import cn.edu.nju.teamwiki.service.AdminService;
import cn.edu.nju.teamwiki.service.ServiceException;
import cn.edu.nju.teamwiki.util.Constants;
import cn.edu.nju.teamwiki.util.UploadFileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author: zhoushiqi
 * @date: 2020/2/8
 */
@Service
public class AdminServiceImpl implements AdminService {

    private static final Logger LOG = LoggerFactory.getLogger(AdminService.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private TeamWikiConfig twConfig;

    @Override
    public boolean isAdmin(String currentUser) {
        User user = userDao.fetchOneByUserId(Integer.valueOf(currentUser));
        return user.getRole() == Constants.ROLE_LEADER;
    }

    @Override
    public UserVO changeUserRole(String userId, int role) {
        User user = userDao.fetchOneByUserId(Integer.valueOf(userId));
        user.setRole(Integer.valueOf(role));
        userDao.update(user);
        return new UserVO(user);
    }

    @Override
    public void uploadLogo(MultipartFile file) {
        if (file.isEmpty()) {
            throw new ServiceException(ResultCode.PARAM_INVALID_UPLOAD_FILE);
        }
        try {
            if (!UploadFileUtils.isImage(file)) {
                throw new ServiceException(ResultCode.PARAM_INVALID_UPLOAD_FILE);
            }
        } catch (IOException e) {
            LOG.error("检查上传文件是否是图片时失败", e);
            throw new ServiceException(ResultCode.SYSTEM_INTERNAL_ERROR);
        }
        Path logoPath = Paths.get(twConfig.imgDir, "logo.jpg");
        try {
            UploadFileUtils.transfer(file, logoPath);
        } catch (IOException e) {
            LOG.error("上传图片存储失败", e);
        }
    }
}
