package cn.edu.nju.teamwiki.service;

import cn.edu.nju.teamwiki.api.param.SignInParams;
import cn.edu.nju.teamwiki.api.param.UpdateUserProfileParams;
import cn.edu.nju.teamwiki.api.vo.UserVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: zhoushiqi
 * @date: 2020/4/5
 */
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void getAllUsers() throws Exception{
        List<UserVO> list;
        list = userService.getAllUsers();
        assertEquals(list.size(), 3);
    }

    @Test
    public void Sign_In()throws Exception{
        String email = "testemail";
        String password = "testpwd";
        assertEquals(userService.signIn(email, password).getRole(), 3);
    }

    @Test
    public void Sign_up()throws Exception{
        String email = "testemail2";
        String password = "testpwd2";
        String username = "test";
        assertEquals(userService.signUp(email,password,username).getRole(), 3);
    }

    @Test
    public void updateUserProfile()throws Exception{
        UpdateUserProfileParams params = new UpdateUserProfileParams();
        params.username = "testemail";
        params.phone = "testphone";
        params.introduction = "just a test";
        assertEquals(userService.updateUserProfile("3",params).getIntroduction(), "just a test");
    }

    @Test
    public void getUserProfile()throws Exception{
        assertEquals(userService.getUserProfile("3").getIntroduction(), "just a test");
    }

}
