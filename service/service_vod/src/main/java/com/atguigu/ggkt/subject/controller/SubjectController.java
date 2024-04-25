package com.atguigu.ggkt.subject.controller;


import com.atguigu.ggkt.model.vod.Subject;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.subject.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(tags = "课程管理接口")
@RestController
@RequestMapping(value = "admin/subject")
@CrossOrigin
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    //list 获取课程列表 by parentId
    @ApiOperation("课程列表")
    @GetMapping("list/{id}")
    public Result getSubjectList(@PathVariable Long id){
        List<Subject> subjectList = subjectService.getSubjectList(id);
        return Result.ok(subjectList);
    }

    @ApiOperation("导入数据")
    @PostMapping("importData")
    public void importData(MultipartFile file){
        subjectService.importData(file);
    }

    @ApiOperation("导出数据")
    @PostMapping("exportData")
    public void exportData(HttpServletResponse response){
        subjectService.exportData(response);
    }

}
