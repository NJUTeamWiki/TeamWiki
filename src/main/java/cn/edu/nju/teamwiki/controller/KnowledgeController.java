package cn.edu.nju.teamwiki.controller;

import cn.edu.nju.teamwiki.api.Result;
import cn.edu.nju.teamwiki.api.vo.KnowledgeVO;
import cn.edu.nju.teamwiki.service.DocumentService;
import cn.edu.nju.teamwiki.service.KnowledgeService;
import cn.edu.nju.teamwiki.service.ServiceException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private DocumentService documentService;

    @GetMapping
    @ApiOperation("获取所有知识")
    public Result getAllKnowledge() {
        List<KnowledgeVO> result = knowledgeService.getAllKnowledge();
        return Result.success(result);
    }


    @PostMapping
    @ApiOperation("创建自定义知识")
    public Result createKnowledge(@RequestParam("cid") String categoryId,
                                  @RequestParam("kname") String knowledgeName,
                                  @RequestParam("uid") String userId) {
        try {
            knowledgeService.createKnowledge(categoryId, knowledgeName, userId);
            return Result.success();
        } catch (ServiceException e) {
            return Result.failure(e.getResultCode());
        }
    }

    @PutMapping
    @ApiOperation(value = "重命名知识", notes = "仅限自定义知识")
    public Result renameKnowledge(@RequestParam("kid") String knowledgeId,
                                  @RequestParam("kname") String newName,
                                  @RequestParam("uid") String userId) {
        try {
            knowledgeService.renameKnowledge(knowledgeId, newName, userId);
            return Result.success();
        } catch (ServiceException e) {
            return Result.failure(e.getResultCode());
        }
    }

    @DeleteMapping
    @ApiOperation(value = "删除知识", notes = "仅限自定义知识")
    public Result removeKnowledge(@RequestParam("kid") String knowledgeId,
                                  @RequestParam("uid") String userId) {
        try {
            knowledgeService.removeKnowledge(knowledgeId, userId);
            return Result.success();
        } catch (ServiceException e) {
            return Result.failure(e.getResultCode());
        }
    }


}
