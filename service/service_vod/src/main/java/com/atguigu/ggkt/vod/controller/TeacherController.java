package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.vod.TeacherQueryVo;
import com.atguigu.ggkt.vod.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author gudong
 * @since 2024-03-26
 */
@Api(tags = "讲师管理接口")
@RestController
@RequestMapping(value = "admin/vod/teacher")
@CrossOrigin    //跨域
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    // 查询所有讲师
    @ApiOperation(value = "查询所有讲师")
    @GetMapping(value = "findAll")
    public Result<List<Teacher>> findAll(){
        List<Teacher> list = teacherService.list();
        return Result.ok(list);
    }

    // 逻辑删除讲师
    @ApiOperation("逻辑删除讲师")
    @DeleteMapping(value = "remove/{id}")
    public Result<Boolean> removeTeacher(@ApiParam(name = "id",value = "ID",required = true) @PathVariable Long id) {   //从路径中获取id
        boolean isSuccess = teacherService.removeById(id);
        if(isSuccess){
            return Result.ok(null);
        }
        return Result.fail(null);
    }

    // 分页条件查询讲师接口
    @ApiOperation("分页条件查询讲师接口")
    @PostMapping(value = "findQueryPage/{current}/{limit}")
    public Result getIndex(
            @ApiParam(name = "current",value = "当前页码",required = true)
            @PathVariable long current,
            @ApiParam(name = "limit",value = "每页记录数",required = true)
            @PathVariable long limit,
            @ApiParam(name = "teacherQueryVo",value = "查询对象")
            @RequestBody(required = false) TeacherQueryVo teacherQueryVo){
        Page<Teacher> pageParam = new Page<>(current,limit);
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();    //封装条件
        // 没有条件
        if (teacherQueryVo == null){
            IPage<Teacher> pageModel = teacherService.page(pageParam,null); //分页参数  封装条件
            return Result.ok(pageModel);
        }else {
            //封装条件
            String name = teacherQueryVo.getName();
            Integer level = teacherQueryVo.getLevel();
            String joinDateBegin = teacherQueryVo.getJoinDateBegin();
            String joinDateEnd = teacherQueryVo.getJoinDateEnd();

            System.out.println("teacherQueryVo = " + teacherQueryVo);

            if(!StringUtils.isEmpty(name)){
                wrapper.like("name",name);  //列名 参数
            }
            if(!StringUtils.isEmpty(level)){
                wrapper.eq("level",level);  //列名 参数
            }
            if(!StringUtils.isEmpty(joinDateBegin)){
                wrapper.ge("join_date",joinDateBegin);  //列名 参数
            }
            if(!StringUtils.isEmpty(joinDateEnd)){
                wrapper.le("join_date",joinDateEnd);  //列名 参数
            }

            IPage<Teacher> pageModel = teacherService.page(pageParam, wrapper);
            return Result.ok(pageModel);
        }
    }

    // 添加讲师接口
    @ApiOperation("添加讲师接口")
    @PostMapping(value = "add")
    public Result addTeacher(@RequestBody Teacher teacher){
        if(teacher != null){
            teacherService.save(teacher);
            return Result.ok(null);
        }else {
            return Result.fail("讲师信息不能为空");
        }
    }
    // 获取讲师信息
    @ApiOperation("获取讲师信息")
    @GetMapping("get/{id}")
    public Result getTeacher(@PathVariable Integer id){
        Teacher teacher = teacherService.getById(id);
        if(teacher == null) return Result.fail("讲师不存在");
        return Result.ok(teacher);
    }

    // 修改讲师信息
    @ApiOperation("修改讲师信息")
    @PostMapping("update")
    public Result updateById(@RequestBody Teacher teacher){
        if(teacherService.getById(teacher.getId()) == null){
            return Result.fail("不存在该教师");
        }
        teacherService.updateById(teacher);
        return Result.ok(null);
    }

    //批量删除接口
    @ApiOperation("批量修改接口")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList){
        teacherService.removeByIds(idList);
        return Result.ok(null);
    }
}

