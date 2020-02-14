package cn.edu.nju.teamwiki.service;

import cn.edu.nju.teamwiki.api.param.UpdateUserProfileParams;
import cn.edu.nju.teamwiki.api.vo.UserVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author: xuyangchen
 * @date: 2020/1/15
 */
public interface UserService {

    List<UserVO> getAllUsers() throws ServiceException;

    UserVO getUserProfile(String userId) throws ServiceException;

    UserVO signIn(String email, String password) throws ServiceException;

    UserVO signUp(String email, String password, String username) throws ServiceException;

    void updateUserAvatar(String userId, MultipartFile avatarFile) throws ServiceException;

    void updateUserProfile(String userId, UpdateUserProfileParams params) throws ServiceException;

}
