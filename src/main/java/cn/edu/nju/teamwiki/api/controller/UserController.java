package cn.edu.nju.teamwiki.api.controller;

import cn.edu.nju.teamwiki.api.Result;
import cn.edu.nju.teamwiki.api.ResultCode;
import cn.edu.nju.teamwiki.api.param.SignInParams;
import cn.edu.nju.teamwiki.api.param.SignUpParams;
import cn.edu.nju.teamwiki.api.param.UpdateUserProfileParams;
import cn.edu.nju.teamwiki.api.vo.UserVO;
import cn.edu.nju.teamwiki.service.ServiceException;
import cn.edu.nju.teamwiki.service.UserService;
import cn.edu.nju.teamwiki.util.SessionUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: xuyangchen
 * @date: 2020/1/15
 */
@RestController
@RequestMapping("/api/user")
@Api(value = "用户相关接口", tags = "UserController")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @ApiOperation("获取所有用户")
    public Result getAllUsers() {
        try {
            List<UserVO> users = userService.getAllUsers();
            return Result.success(users);
        } catch (ServiceException e) {
            return Result.failure(e.getResultCode());
        }
    }

    @PostMapping("/sign_in")
    @ApiOperation("用户登录")
    public Result signIn(@RequestBody SignInParams params,
                         HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (SessionUtils.hasUser(session)) {
            return Result.failure(ResultCode.USER_ALREADY_SIGNED_IN);
        }
        try {
            UserVO userVO = userService.signIn(params.email, params.password);
            SessionUtils.setUser(session, userVO.getUserId().toString());
            return Result.success(userVO);
        } catch (ServiceException e) {
            return Result.failure(e.getResultCode());
        }
    }

    @PostMapping("/sign_up")
    @ApiOperation("用户注册")
    public Result signUp(@RequestBody SignUpParams params,
                         HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (SessionUtils.hasUser(session)) {
            return Result.failure(ResultCode.USER_ALREADY_SIGNED_IN);
        }
        try {
            UserVO userVO = userService.signUp(params.email, params.password, params.username);
            SessionUtils.setUser(session, userVO.getUserId().toString());
            return Result.success(userVO);
        } catch (ServiceException e) {
            return Result.failure(e.getResultCode());
        }
    }

    @GetMapping("/sign_out")
    @ApiOperation("用户登出")
    public Result signOut(HttpServletRequest request) {
        SessionUtils.removeUser(request.getSession());
        return Result.success();
    }

    @PostMapping("/avatar")
    @ApiOperation("更新用户头像")
    public Result updateUserAvatar(@RequestParam("file") MultipartFile avatarFile,
                                   HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userId = SessionUtils.getUser(session);
        try {
            UserVO userVO = userService.updateUserAvatar(userId, avatarFile);
            return Result.success(userVO);
        } catch (ServiceException e) {
            return Result.failure(e.getResultCode());
        }
    }

    @GetMapping("/profile")
    @ApiOperation("获取特定用户的profile")
    public Result getUserProfile(@RequestParam(name = "uid") String userId) {
        try {
            UserVO userVO = userService.getUserProfile(userId);
            return Result.success(userVO);
        } catch (ServiceException e) {
            return Result.failure(e.getResultCode());
        }
    }

    @PutMapping("/profile")
    @ApiOperation("更新用户信息")
    public Result updateUserProfile(@RequestBody UpdateUserProfileParams params,
                                    HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userId = SessionUtils.getUser(session);
        try {
            UserVO userVO = userService.updateUserProfile(userId, params);
            return Result.success(userVO);
        } catch (ServiceException e) {
            return Result.failure(e.getResultCode());
        }
    }

    @GetMapping("/check")
    @ApiOperation("检查用户是否已登陆")
    public Result checkSignIn(HttpServletRequest request) {
        if (!SessionUtils.hasUser(request.getSession())) {
            return Result.failure(ResultCode.USER_NOT_SIGNED_IN);
        }
        return Result.success();
    }
}
