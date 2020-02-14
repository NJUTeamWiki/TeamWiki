package cn.edu.nju.teamwiki.service;

/**
 * @Author: zhoushiqi
 * @date: 2020/2/5
 */
public interface AdminService {
    void changeUserRole(String userId, String role) throws ServiceException;

}
