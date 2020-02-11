package cn.edu.nju.teamwiki.controller;

import cn.edu.nju.teamwiki.api.Result;
import cn.edu.nju.teamwiki.api.ResultCode;
import cn.edu.nju.teamwiki.api.param.DeleteDocumentParams;
import cn.edu.nju.teamwiki.api.param.RenameDocumentParams;
import cn.edu.nju.teamwiki.api.param.UploadDocumentParams;
import cn.edu.nju.teamwiki.api.vo.DocumentVO;
import cn.edu.nju.teamwiki.service.DocumentService;
import cn.edu.nju.teamwiki.service.ServiceException;
import cn.edu.nju.teamwiki.util.Constants;
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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

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
    public Result getDocuments(@RequestParam("sid") String sourceId,
                               @RequestParam("stype") Integer sourceType) {
        try {
            List<DocumentVO> result = documentService.getDocuments(sourceId, sourceType);
            return Result.success(result);
        } catch (ServiceException e) {
            return Result.failure(e.getResultCode());
        }

    }

    @PostMapping
    @ApiOperation("上传文档至当前源")
    public Result uploadDocument(@RequestBody UploadDocumentParams params,
                                 @RequestParam("file") MultipartFile file,
                                 HttpServletRequest request) {
        if (file.isEmpty()) {
            return Result.failure(ResultCode.PARAM_INVALID_UPLOAD_FILE);
        }
        String userId = (String) request.getSession().getAttribute(Constants.SESSION_UID);
        try {
            documentService.uploadDocument(params.sourceId, params.sourceType, file, userId);
            return Result.success();
        } catch (ServiceException e) {
            return Result.failure(e.getResultCode());
        }
    }

    @PutMapping
    @ApiOperation("重命名当前源中的文档")
    public Result renameDocument(@RequestBody RenameDocumentParams params,
                                 HttpServletRequest request) {
        String userId = (String) request.getSession().getAttribute(Constants.SESSION_UID);
        try {
            documentService.renameDocument(params.documentId, params.sourceType, params.newName, userId);
            return Result.success();
        } catch (ServiceException e) {
            return Result.failure(e.getResultCode());
        }

    }

    @DeleteMapping
    @ApiOperation("删除当前源中的文档")
    public Result deleteDocument(@RequestBody DeleteDocumentParams params,
                                 HttpServletRequest request) {
        String userId = (String) request.getSession().getAttribute(Constants.SESSION_UID);
        try {
            documentService.deleteDocument(params.documentId, params.sourceType, userId);
            return Result.success();
        } catch (ServiceException e) {
            return Result.failure(e.getResultCode());
        }
    }


    @GetMapping("/download/{id}")
    @ApiOperation("下载文档")
    public ResponseEntity<Resource> downloadFile(@PathVariable("id") String documentId,
                                                 HttpServletRequest request) {
        Path documentPath = null;
        try {
            documentPath = documentService.getDocumentDownloadPath(documentId);
        } catch (ServiceException e) {
            LOG.error(e.getMessage());
        }
        Resource resource = null;
        try {
            resource = new UrlResource(documentPath.toUri());
        } catch (MalformedURLException e) {
            LOG.error(e.getMessage());
        }
        Objects.requireNonNull(resource);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }

        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }


}
