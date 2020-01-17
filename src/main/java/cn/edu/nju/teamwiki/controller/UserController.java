package cn.edu.nju.teamwiki.controller;

import cn.edu.nju.teamwiki.api.Result;
import cn.edu.nju.teamwiki.api.ResultCode;
import cn.edu.nju.teamwiki.service.ServiceException;
import cn.edu.nju.teamwiki.service.UserService;
import cn.edu.nju.teamwiki.util.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: xuyangchen
 * @date: 2020/1/15
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户相关接口", tags = "UserController")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/sign_in")
    @ApiOperation("用户登录")
    public Result signIn(@RequestParam("email") String email,
                         @RequestParam("password") String password,
                         HttpServletRequest request) {
        try {
            int userId = userService.signIn(email, password);
            request.getSession().setAttribute(Constants.SESSION_UID, userId);
            return Result.success();
        } catch (ServiceException e) {
            return Result.failure(e.getResultCode());
        }
    }

    @PostMapping("/sign_up")
    @ApiOperation("用户注册")
    public Result signUp(@RequestParam("email") String email,
                         @RequestParam("password") String password,
                         @RequestParam("username") String username) {
        try {
            userService.signUp(email, password, username);
            return Result.success();
        } catch (ServiceException e) {
            return Result.failure(e.getResultCode());
        }
    }

    @GetMapping("/sign_out")
    @ApiOperation("用户登出")
    public Result signOut(@RequestParam("uid") String userId, HttpServletRequest request) {
        request.getSession().removeAttribute(Constants.SESSION_UID);
        return Result.success();
    }

    @PostMapping("/profile")
    @ApiOperation(value = "获取用户信息")
    public Result getUserProfile() {
        return Result.success();
    }

}
