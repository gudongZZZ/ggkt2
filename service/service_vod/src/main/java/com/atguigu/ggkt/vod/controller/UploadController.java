package com.atguigu.ggkt.vod.controller;

import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vod.service.UploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "文件上传接口")
@RestController
@RequestMapping(value = "admin/vod/file")
@CrossOrigin
public class UploadController {
    @Autowired
    private UploadService uploadService;
    @ApiOperation("MultipartFile 测试")
    @PostMapping("upload")
    public Result upload(MultipartFile file){

        String url = uploadService.upload(file);
        return Result.ok(url).message("上传成功");
    }
}
