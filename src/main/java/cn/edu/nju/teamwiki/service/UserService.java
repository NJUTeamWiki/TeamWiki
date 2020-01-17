package cn.edu.nju.teamwiki.service;

import cn.edu.nju.teamwiki.api.vo.UserVO;
import org.springframework.stereotype.Service;

/**
 * @author: xuyangchen
 * @date: 2020/1/15
 */
public interface UserService {

    Integer signIn(String email, String password) throws ServiceException;

    void signUp(String email, String password, String username) throws ServiceException;

    UserVO getUserProfile();

}
