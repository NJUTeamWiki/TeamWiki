package cn.edu.nju.teamwiki.api.controller;

import cn.edu.nju.teamwiki.api.Result;
import cn.edu.nju.teamwiki.api.vo.PortalVO;
import cn.edu.nju.teamwiki.service.PortalService;
import cn.edu.nju.teamwiki.service.ServiceException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author: xuyangchen
 * @date: 2020/1/16
 */
@RestController
@RequestMapping("/api/portal")
@Api(value = "传送门相关接口", tags = "PortalController")
public class PortalController {

    private static final Logger LOG = LoggerFactory.getLogger(PortalController.class);

    @Autowired
    private PortalService portalService;

    @GetMapping
    @ApiOperation("获取所有portal信息")
    public Result getAllPortal() {
        try {
            List<PortalVO> result = portalService.getAllPortal();
            return Result.success(result);
        } catch (ServiceException e) {
            return Result.failure(e.getResultCode());
        }
    }

    @GetMapping("/{id}")
    @ApiOperation("获取某个portal")
    public Result getOnePortal(@PathVariable("id") String portalId) {
        try {
            PortalVO result = portalService.getPortalById(portalId);
            return Result.success(result);
        } catch (ServiceException e) {
            return Result.failure(e.getResultCode());
        }
    }

    @PostMapping
    @ApiOperation("添加portal")
    public Result createPortal(@RequestParam("name") String portalName,
                               @RequestParam("link") String portalLink) {
        try {
            PortalVO portalVO = portalService.createPortal(portalName, portalLink);
            return Result.success(portalVO);
        } catch (ServiceException e) {
            LOG.error(e.getMessage());
            return Result.failure(e.getResultCode());
        }
    }

    @PutMapping
    @ApiOperation("更新portal")
    public Result updatePortal(@RequestParam("pid") String portalId,
                               @RequestParam("name") String portalName,
                               @RequestParam("link") String portalLink) {
        try {
            PortalVO portalVO = portalService.updatePortal(portalId, portalName, portalLink);
            return Result.success(portalVO);
        } catch (ServiceException e) {
            LOG.error(e.getMessage());
            return Result.failure(e.getResultCode());
        }
    }

    @PutMapping("/icon")
    @ApiOperation("更新图标")
    public Result updateIcon(@RequestParam("pid") String portalId,
                             @RequestParam("file") MultipartFile iconFile) {
        try {
            portalService.updateIcon(portalId, iconFile);
        } catch (ServiceException e) {
            return Result.failure(e.getResultCode());
        }
        return Result.success();
    }

    @DeleteMapping
    @ApiOperation("删除portal")
    public Result deletePortal(@RequestParam("pid") String portalId) {
        try {
            PortalVO portalVO = portalService.deletePortal(portalId);
            return Result.success(portalVO);
        } catch (ServiceException e) {
            LOG.error(e.getMessage());
            return Result.failure(e.getResultCode());
        }
    }


}
