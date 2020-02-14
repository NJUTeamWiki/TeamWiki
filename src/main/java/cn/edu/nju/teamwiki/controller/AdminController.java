package cn.edu.nju.teamwiki.controller;

import cn.edu.nju.teamwiki.service.AdminService;
import cn.edu.nju.teamwiki.service.ServiceException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xuyangchen
 * @date: 2020/1/16
 */
@RestController
@RequestMapping("/admin")
@Api(value = "管理员相关接口", tags = "AdminController")
public class AdminController {

    private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @PutMapping("/userRole")
    @ApiOperation("修改用户角色")
    public void changeUserRole(@RequestParam("uid") String userId,
                               @RequestParam("role") String role){
        try {
            adminService.changeUserRole(userId, role);
        }catch (ServiceException e){
            LOG.error(e.getMessage());
        }
    }
}
