package cn.edu.nju.teamwiki.api.controller;

import cn.edu.nju.teamwiki.api.Result;
import cn.edu.nju.teamwiki.api.ResultCode;
import cn.edu.nju.teamwiki.api.vo.UserVO;
import cn.edu.nju.teamwiki.service.AdminService;
import cn.edu.nju.teamwiki.service.ServiceException;
import cn.edu.nju.teamwiki.util.SessionUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: xuyangchen
 * @date: 2020/1/16
 */
@RestController
@RequestMapping("/api/admin")
@Api(value = "管理员相关接口", tags = "AdminController")
public class AdminController {

    private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @PutMapping("/userRole")
    @ApiOperation("修改用户角色")
    public Result changeUserRole(@RequestParam("uid") String userId,
                                 @RequestParam("role") Integer role,
                                 HttpServletRequest request) {
        String currentUser = SessionUtils.getUser(request.getSession());
        if (!adminService.isAdmin(currentUser)) {
            return Result.failure(ResultCode.PERMISSION_NO_MODIFY);
        }
        try {
            UserVO userVO = adminService.changeUserRole(userId, role);
            return Result.success(userVO);
        } catch (ServiceException e) {
            LOG.error("修改用户角色失败", e);
            return Result.failure(e.getResultCode());
        }
    }

    @PostMapping("/logo")
    @ApiOperation("上传网站logo")
    public Result uploadLogo(@RequestParam("file") MultipartFile file,
                             HttpServletRequest request) {
        String currentUser = SessionUtils.getUser(request.getSession());
        if (!adminService.isAdmin(currentUser)) {
            return Result.failure(ResultCode.PERMISSION_NO_MODIFY);
        }
        try {
            adminService.uploadLogo(file);
            return Result.success();
        } catch (ServiceException e) {
            LOG.error("上传Logo失败", e);
            return Result.failure(e.getResultCode());
        }
    }
}
