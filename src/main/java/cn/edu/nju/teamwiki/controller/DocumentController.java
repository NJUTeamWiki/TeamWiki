package cn.edu.nju.teamwiki.controller;

import cn.edu.nju.teamwiki.api.Result;
import cn.edu.nju.teamwiki.api.param.RenameDocumentParams;
import cn.edu.nju.teamwiki.api.vo.DocumentVO;
import cn.edu.nju.teamwiki.service.DocumentService;
import cn.edu.nju.teamwiki.service.ServiceException;
import cn.edu.nju.teamwiki.util.SessionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Path;
import java.util.List;

/**
 * @author: xuyangchen
 * @date: 2020/1/16
 */
@RestController
@RequestMapping("/document")
@Api(value = "文档相关接口", tags = "DocumentController")
public class DocumentController {

    private static final Logger LOG = LoggerFactory.getLogger(DocumentController.class);

    @Autowired
    private DocumentService documentService;

    @GetMapping
    @ApiOperation("获取当前源的所有文档")
    @ApiParam
    public Result getDocuments(@RequestParam("sourceId") String sourceId,
                               @RequestParam("sourceType") Integer sourceType) {
        try {
            List<DocumentVO> result = documentService.getDocuments(sourceId, sourceType);
            return Result.success(result);
        } catch (ServiceException e) {
            return Result.failure(e.getResultCode());
        }

    }

    @PutMapping
    @ApiOperation("重命名当前源中的文档")
    public Result renameDocument(@RequestBody RenameDocumentParams params,
                                 HttpServletRequest request) {
        String userId = SessionUtil.getUser(request.getSession());
        try {
            documentService.renameDocument(params.documentId, params.newName, userId);
            return Result.success();
        } catch (ServiceException e) {
            return Result.failure(e.getResultCode());
        }

    }

    @DeleteMapping
    @ApiOperation("删除当前源中的文档")
    public Result deleteDocument(@RequestParam("documentId") String documentId,
                                 HttpServletRequest request) {
        String userId = SessionUtil.getUser(request.getSession());
        try {
            documentService.deleteDocument(documentId, userId);
            return Result.success();
        } catch (ServiceException e) {
            return Result.failure(e.getResultCode());
        }
    }


    @GetMapping("/download/{id}")
    @ApiOperation("下载文档")
    public ResponseEntity<Resource> downloadFile(@PathVariable("id") String documentId,
                                                 HttpServletRequest request) throws Exception {
        Path documentPath = documentService.getDocumentDownloadPath(documentId);
        String documentName = documentService.getDocumentName(documentId);
        Resource resource = new UrlResource(documentPath.toUri());
        String contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + documentName + "\"")
                .body(resource);
    }


}
