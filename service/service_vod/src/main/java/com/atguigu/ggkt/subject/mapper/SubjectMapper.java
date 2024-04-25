package com.atguigu.ggkt.subject.mapper;


import com.alibaba.excel.EasyExcel;
import com.atguigu.ggkt.model.vod.Subject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


@Mapper
public interface SubjectMapper extends BaseMapper<Subject> {

}
