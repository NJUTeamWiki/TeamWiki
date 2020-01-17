package cn.edu.nju.teamwiki.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xuyangchen
 * @date: 2020/1/16
 */
@RestController
@RequestMapping("/admin")
@Api(value = "管理员相关接口", tags = "AdminController")
public class AdminController {
}
