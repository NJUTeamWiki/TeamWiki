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

    List<UserVO> getAllUsers();

    UserVO getUserProfile(String userId);

    UserVO signIn(String email, String password);

    UserVO signUp(String email, String password, String username);

    UserVO updateUserAvatar(String userId, MultipartFile avatarFile);

    UserVO updateUserProfile(String userId, UpdateUserProfileParams params);

}
