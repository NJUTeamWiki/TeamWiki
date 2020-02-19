package cn.edu.nju.teamwiki.controller;

import cn.edu.nju.teamwiki.api.Result;
import cn.edu.nju.teamwiki.api.ResultCode;
import cn.edu.nju.teamwiki.api.param.CreateKnowledgeParams;
import cn.edu.nju.teamwiki.api.param.RenameKnowledgeParams;
import cn.edu.nju.teamwiki.api.vo.CategoryVO;
import cn.edu.nju.teamwiki.api.vo.KnowledgeVO;
import cn.edu.nju.teamwiki.service.DocumentService;
import cn.edu.nju.teamwiki.service.KnowledgeService;
import cn.edu.nju.teamwiki.service.ServiceException;
import cn.edu.nju.teamwiki.util.Constants;
import cn.edu.nju.teamwiki.util.SessionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: xuyangchen
 * @date: 2020/1/6
 */
@RestController
@RequestMapping("knowledge")
@Api(value = "知识相关接口", tags = "KnowledgeController")
public class KnowledgeController {

    @Autowired
    private KnowledgeService knowledgeService;

    @GetMapping
    @ApiOperation("获取所有知识")
    public Result getAllKnowledge() {
        List<CategoryVO> result = knowledgeService.getAllKnowledge();
        return Result.success(result);
    }

    @PostMapping
    @ApiOperation("创建自定义知识")
    public Result createKnowledge(@RequestBody CreateKnowledgeParams params,
                                  HttpServletRequest request) {
        String userId = SessionUtil.getUser(request.getSession());
        try {
            knowledgeService.createKnowledge(params.categoryId, params.knowledgeName, userId);
            return Result.success();
        } catch (ServiceException e) {
            return Result.failure(e.getResultCode());
        }
    }

    @PutMapping
    @ApiOperation(value = "重命名知识", notes = "仅限自定义知识")
    public Result renameKnowledge(@RequestBody RenameKnowledgeParams params,
                                  HttpServletRequest request) {
        String userId = SessionUtil.getUser(request.getSession());
        try {
            knowledgeService.renameKnowledge(params.knowledgeId, params.newName, userId);
            return Result.success();
        } catch (ServiceException e) {
            return Result.failure(e.getResultCode());
        }
    }

    @DeleteMapping
    @ApiOperation(value = "删除知识", notes = "仅限自定义知识")
    public Result removeKnowledge(@RequestParam("knowledgeId") String knowledgeId,
                                  HttpServletRequest request) {
        String userId = SessionUtil.getUser(request.getSession());
        try {
            knowledgeService.removeKnowledge(knowledgeId, userId);
            return Result.success();
        } catch (ServiceException e) {
            return Result.failure(e.getResultCode());
        }
    }

    @PostMapping("/upload")
    @ApiOperation("上传文档至知识")
    public Result uploadDocumentToKnowledge(@RequestParam("file") MultipartFile file,
                                            @RequestParam("knowledgeId") String knowledgeId,
                                            HttpServletRequest request) {
        if (file.isEmpty()) {
            return Result.failure(ResultCode.PARAM_INVALID_UPLOAD_FILE);
        }
        String userId = SessionUtil.getUser(request.getSession());
        try {
            knowledgeService.uploadDocumentToKnowledge(knowledgeId, file, userId);
            return Result.success();
        } catch (ServiceException e) {
            return Result.failure(e.getResultCode());
        }
    }


}
