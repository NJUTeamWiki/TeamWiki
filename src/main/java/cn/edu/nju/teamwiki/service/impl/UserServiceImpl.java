package cn.edu.nju.teamwiki.service.impl;

import cn.edu.nju.teamwiki.api.ResultCode;
import cn.edu.nju.teamwiki.api.param.UpdateUserProfileParams;
import cn.edu.nju.teamwiki.api.vo.UserVO;
import cn.edu.nju.teamwiki.config.TeamWikiConfig;
import cn.edu.nju.teamwiki.jooq.tables.daos.RoleDao;
import cn.edu.nju.teamwiki.jooq.tables.daos.UserDao;
import cn.edu.nju.teamwiki.jooq.tables.pojos.User;
import cn.edu.nju.teamwiki.service.ServiceException;
import cn.edu.nju.teamwiki.service.UserService;
import cn.edu.nju.teamwiki.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: xuyangchen
 * @date: 2020/1/16
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private TeamWikiConfig twConfig;

    @Override
    public List<UserVO> getAllUsers() {
        return userDao.findAll()
                .stream()
                .map(UserVO::new)
                .collect(Collectors.toList());
    }

    @Override
    public UserVO getUserProfile(String userId) {
        User user = userDao.fetchOneByUserId(Integer.valueOf(userId));
        return new UserVO(user);
    }

    @Override
    public UserVO signIn(String email, String password) {
        User user = userDao.fetchOneByEmail(email);
        if (user == null) {
            throw new ServiceException(ResultCode.USER_NOT_EXIST);
        }
        try {
            String provide = EncryptUtils.encryptSHA(password);
            String store = user.getPassword();
            if (!provide.equals(store)) {
                throw new ServiceException(ResultCode.USER_SIGN_IN_ERROR);
            }
            return new UserVO(user);
        } catch (NoSuchAlgorithmException e) {
            throw new ServiceException(ResultCode.SYSTEM_INTERNAL_ERROR);
        }
    }

    @Override
    public UserVO signUp(String email, String password, String username) {
        if (userDao.fetchOneByEmail(email) == null) {
            User user = new User();
            try {
                user.setPassword(EncryptUtils.encryptSHA(password));
            } catch (NoSuchAlgorithmException e) {
                throw new ServiceException(ResultCode.SYSTEM_INTERNAL_ERROR);
            }
            user.setEmail(email);
            user.setUsername(username);

            if (userDao.count() == 0) {
                // 设置第一个注册用户为Leader
                user.setRole(Constants.ROLE_LEADER);
            } else {
                // 后面的注册用户均为Newcomer
                user.setRole(Constants.ROLE_NEWCOMER);
            }

            userDao.insert(user);

            user = userDao.fetchByEmail(email).get(0);
            return new UserVO(user);
        } else {
            throw new ServiceException(ResultCode.USER_HAS_EXISTED);
        }
    }

    @Override
    public UserVO updateUserAvatar(String userId, MultipartFile avatarFile) {
        try {
            if (!UploadFileUtils.isImage(avatarFile)) {
                throw new ServiceException(ResultCode.PARAM_NOT_IMAGE);
            }
        } catch (IOException e) {
            LOG.error("检查上传头像文件是否是图片时失败", e);
            throw new ServiceException(ResultCode.SYSTEM_FILE_ERROR);
        }
        User user = userDao.fetchOneByUserId(Integer.valueOf(userId));

        String fileName = avatarFile.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String newFileName = DBUtils.randomShortUUID() + suffixName;

        Path path = Paths.get(twConfig.avatarDir, newFileName);
        LOG.info("Avatar will be stored as [" + path + "].");
        try {
            UploadFileUtils.transfer(avatarFile, path);
        } catch (IOException e) {
            LOG.error("上传图片保存为头像失败", e);
            throw new ServiceException(ResultCode.SYSTEM_FILE_ERROR);
        }

        user.setAvatar("/avatar/" + newFileName);
        userDao.update(user);

        return new UserVO(userDao.fetchOneByUserId(user.getUserId()));
    }

    @Override
    public UserVO updateUserProfile(String userId, UpdateUserProfileParams params) {
        User user = userDao.fetchOneByUserId(Integer.valueOf(userId));

        if (params.username != null) {
            user.setUsername(params.username);
        }
        if (params.introduction != null) {
            user.setIntroduction(params.introduction);
        }
        if (params.phone != null) {
            user.setPhone(params.phone);
        }

        userDao.update(user);

        return new UserVO(userDao.fetchOneByUserId(user.getUserId()));
    }
}
