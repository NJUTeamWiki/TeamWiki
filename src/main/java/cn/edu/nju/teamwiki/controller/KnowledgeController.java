package cn.edu.nju.teamwiki.controller;

import cn.edu.nju.teamwiki.api.Result;
import cn.edu.nju.teamwiki.api.ResultCode;
import cn.edu.nju.teamwiki.model.Knowledge;
import cn.edu.nju.teamwiki.service.KnowledgeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author: xuyangchen
 * @date: 2020/1/6
 */
@RestController
@RequestMapping("knowledge")
@Api(value = "知识相关接口", tags = "KnowledgeController")
public class KnowledgeController {

    private final KnowledgeService knowledgeService;

    public KnowledgeController(KnowledgeService knowledgeService) {
        this.knowledgeService = knowledgeService;
    }

    @GetMapping
    @ApiOperation("获取所有知识")
    public Result getKnowledge() {
        List<Knowledge> result = null;
        try {
            result = knowledgeService.getAllKnowledge();
            return Result.success(result);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
        }
    }


    @PostMapping
    @ApiOperation("上传知识")
    public Result uploadKnowledge(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return Result.failure(ResultCode.PARAM_UPLOAD_FILE_EMPTY);
        }
        try {
            knowledgeService.uploadKnowledge(file);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
        }
    }

    @PutMapping
    @ApiOperation("更新知识")
    public Result updateKnowledge(@RequestParam("id") String knowledgeId,
                                  @RequestParam("file") MultipartFile file) {
        knowledgeService.updateKnowledge(knowledgeId, file);
        return Result.success();
    }

    @DeleteMapping
    @ApiOperation("删除知识")
    public Result removeKnowledge(@RequestParam("id") String knowledgeId) {
        knowledgeService.removeKnowledge(knowledgeId);
        return Result.success();
    }


}
