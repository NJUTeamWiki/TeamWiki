package cn.edu.nju.teamwiki.service.impl;

import cn.edu.nju.teamwiki.api.vo.UserVO;
import cn.edu.nju.teamwiki.jooq.tables.daos.RoleDao;
import cn.edu.nju.teamwiki.jooq.tables.daos.UserDao;
import cn.edu.nju.teamwiki.jooq.tables.pojos.User;
import cn.edu.nju.teamwiki.service.AdminService;
import cn.edu.nju.teamwiki.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zhoushiqi
 * @date: 2020/2/8
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

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
}
