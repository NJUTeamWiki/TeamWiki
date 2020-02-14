package cn.edu.nju.teamwiki.service.impl;

import cn.edu.nju.teamwiki.api.vo.UserVO;
import cn.edu.nju.teamwiki.jooq.tables.daos.RoleDao;
import cn.edu.nju.teamwiki.jooq.tables.daos.UserDao;
import cn.edu.nju.teamwiki.service.AdminService;
import cn.edu.nju.teamwiki.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zhoushiqi
 * @date: 2020/2/8
 */
@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private UserDao userDao;

    @Override
    public void changeUserRole(String userId, String role) throws ServiceException {
        UserVO user = new UserVO(userDao.fetchOneByUserId(Integer.valueOf(userId)));
        user.setRole(Integer.valueOf(role));
        userDao.update(user);
    }
}
