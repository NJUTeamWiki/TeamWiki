package cn.edu.nju.teamwiki.service;

import cn.edu.nju.teamwiki.api.vo.UserVO;

/**
 * @Author: zhoushiqi
 * @date: 2020/2/5
 */
public interface AdminService {

    boolean isAdmin(String currentUser);
    UserVO changeUserRole(String userId, int role) throws ServiceException;

}
