package cn.edu.nju.teamwiki.controller;

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

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialException;
import java.util.List;

/**
 * @author: xuyangchen
 * @date: 2020/1/16
 */
@RestController
@RequestMapping("/portal")
@Api(value = "传送门相关接口", tags = "PortalController")
public class PortalController {

    private static final Logger LOG = LoggerFactory.getLogger(PortalController.class);

    @Autowired
    private PortalService portalService;

    @GetMapping
    @ApiOperation("获取所有portal信息")
    public Result getAllPortal(){
        try {
            List<PortalVO> result = portalService.getAllPortal();
            return Result.success(result);
        }catch (ServiceException e){
            return Result.failure(e.getResultCode());
        }
    }

    @GetMapping("/{id}")
    @ApiOperation("获取某个portal")
    public Result getOnePortal(@PathVariable("id") String portalId){
        try {
            PortalVO result = portalService.getPortalById(portalId);
            return Result.success(result);
        }catch (ServiceException e){
            return Result.failure(e.getResultCode());
        }
    }

    @PostMapping
    @ApiOperation("添加portal")
    public void createPortal(@RequestParam("name") String portalName,
                             @RequestParam("link") String portalLink){
        try {
            portalService.createPortal(portalName, portalLink);
        }catch (ServiceException e){
            LOG.error(e.getMessage());
        }
    }

    @PutMapping
    @ApiOperation("更新portal")
    public void updatePortal(@RequestParam("pid") String portalId,
                             @RequestParam("name") String portalName,
                             @RequestParam("link") String portalLink){
        try {
            portalService.updatePortal(portalId, portalName, portalLink);
        }catch (ServiceException e){
            LOG.error(e.getMessage());
        }
    }

    @PutMapping("/icon")
    @ApiOperation("更新图标")
    public Result updateIcon(@RequestParam("pid")String portalId,
            @RequestParam("file")MultipartFile iconFile){
        try{
            portalService.updateIcon(portalId, iconFile);
        }catch (ServiceException e){
            return Result.failure(e.getResultCode());
        }
        return Result.success();
    }

    @DeleteMapping
    @ApiOperation("删除portal")
    public void deletePortal(@RequestParam("pid") String portalId){
        try {
            portalService.deletePortal(portalId);
        }catch (ServiceException e){
            LOG.error(e.getMessage());
        }
    }



}
