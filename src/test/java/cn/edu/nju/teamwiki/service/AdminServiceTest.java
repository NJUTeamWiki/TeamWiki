package cn.edu.nju.teamwiki.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @Author: zhoushiqi
 * @date: 2020/4/5
 */
@SpringBootTest
public class AdminServiceTest {
    @Autowired
    private AdminService adminService;
    private UserService userService;

    @Test
    public void changeUserRole() throws Exception{
        assertEquals(adminService.changeUserRole("3",2).getRole(), 2);
        assertEquals(adminService.changeUserRole("3",3).getRole(), 3);
    }

}
