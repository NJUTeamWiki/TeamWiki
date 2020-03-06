package cn.edu.nju.teamwiki.api.controller;

import cn.edu.nju.teamwiki.api.Result;
import cn.edu.nju.teamwiki.api.ResultCode;
import cn.edu.nju.teamwiki.api.vo.ShareVO;
import cn.edu.nju.teamwiki.service.ServiceException;
import cn.edu.nju.teamwiki.service.ShareService;
import cn.edu.nju.teamwiki.util.SessionUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: xuyangchen
 * @date: 2020/1/16
 */
@RestController
@RequestMapping("/api/share")
@Api(value = "分享相关接口", tags = "ShareController")
public class ShareController {

    private static final Logger LOG = LoggerFactory.getLogger(ShareController.class);

    @Autowired
    private ShareService shareService;

    @GetMapping
    @ApiOperation("获取当前所有分享")
    public Result getAllShares() {
        try {
            List<ShareVO> result = shareService.getAllShares();
            return Result.success(result);
        } catch (ServiceException e) {
            return Result.failure(e.getResultCode());
        }
    }

    @GetMapping("/someone")
    @ApiOperation("获取用户的所有分享")
    public Result getSomeoneShares(@RequestParam("uid") String userId) {
        try {
            List<ShareVO> result = shareService.getSharesByUserId(userId);
            return Result.success(result);
        } catch (ServiceException e) {
            return Result.failure(e.getResultCode());
        }
    }

    @GetMapping("/title")
    @ApiOperation("根据title获取分享")
    public Result getSharesByTitle(@RequestParam("stitle") String shareTitle) {
        try {
            List<ShareVO> result = shareService.getSharesByTitle(shareTitle);
            return Result.success(result);
        } catch (ServiceException e) {
            return Result.failure(e.getResultCode());
        }
    }

    @PostMapping
    @ApiOperation("创建一个分享")
    public Result createShare(@RequestParam("title") String shareTitle,
                              @RequestParam("content") String shareContent,
                              @RequestParam("file") MultipartFile file,
                              HttpServletRequest request) {
        if (file.isEmpty()) {
            return Result.failure(ResultCode.PARAM_INVALID_UPLOAD_FILE);
        }
        try {
            String userId = SessionUtils.getUser(request.getSession());
            ShareVO shareVO = shareService.createShare(shareTitle, shareContent, userId, file);
            return Result.success(shareVO);
        } catch (ServiceException e) {
            LOG.error(e.getMessage());
            return Result.failure(e.getResultCode());
        }
    }

    @PutMapping
    @ApiOperation("更新一个分享")
    public Result updateShare(@RequestParam("sid") String shareId,
                              @RequestParam("title") String shareTitle,
                              @RequestParam("content") String shareContent,
                              HttpServletRequest request) {
        try {
            String userId = SessionUtils.getUser(request.getSession());
            ShareVO shareVO = shareService.updateShare(shareId, shareTitle, shareContent, userId);
            return Result.success(shareVO);
        } catch (ServiceException e) {
            LOG.error(e.getMessage());
            return Result.failure(e.getResultCode());
        }
    }

    @DeleteMapping
    @ApiOperation("删除一个分享")
    public Result deleteShare(@RequestParam("sid") String shareId,
                              HttpServletRequest request) {
        String userId = SessionUtils.getUser(request.getSession());
        try {
            ShareVO shareVO = shareService.deleteShare(shareId, userId);
            return Result.success(shareVO);
        } catch (ServiceException e) {
            LOG.error(e.getMessage());
            return Result.failure(e.getResultCode());
        }
    }

}
