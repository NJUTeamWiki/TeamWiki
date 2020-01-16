package cn.edu.nju.teamwiki.service.impl;

import cn.edu.nju.teamwiki.api.ResultCode;
import cn.edu.nju.teamwiki.api.vo.UserVO;
import cn.edu.nju.teamwiki.jooq.tables.daos.RoleDao;
import cn.edu.nju.teamwiki.jooq.tables.daos.UserDao;
import cn.edu.nju.teamwiki.jooq.tables.pojos.User;
import cn.edu.nju.teamwiki.service.ServiceException;
import cn.edu.nju.teamwiki.service.UserService;
import cn.edu.nju.teamwiki.util.Constants;
import cn.edu.nju.teamwiki.util.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

/**
 * @author: xuyangchen
 * @date: 2020/1/16
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public Integer signIn(String email, String password) throws ServiceException {
        User user = userDao.fetchByEmail(email).get(0);
        try {
            String provide = EncryptUtil.encryptSHA(password);
            String store = user.getPassword();
            if (!provide.equals(store)) {
                throw new ServiceException(ResultCode.USER_LOGIN_ERROR);
            }
            return user.getUserId();
        } catch (NoSuchAlgorithmException e) {
            throw new ServiceException(ResultCode.SYSTEM_INNER_ERROR);
        }
    }

    @Override
    public void signUp(String email, String password, String username) throws ServiceException {
        if (userDao.fetchByEmail(email).isEmpty()) {
            User user = new User();
            try {
                user.setPassword(EncryptUtil.encryptSHA(password));
            } catch (NoSuchAlgorithmException e) {
                throw new ServiceException(ResultCode.SYSTEM_INNER_ERROR);
            }
            user.setEmail(email);
            user.setRole(roleDao.fetchOneByRoleName(Constants.ROLE_NEWCOMER).getRoleId());
            user.setUsername(username);
            userDao.insert(user);
        } else {
            throw new ServiceException(ResultCode.USER_HAS_EXISTED);
        }
    }

    @Override
    public UserVO getUserProfile() {
        return null;
    }

}
