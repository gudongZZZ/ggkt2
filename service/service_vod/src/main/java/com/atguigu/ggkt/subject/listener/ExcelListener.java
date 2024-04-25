package com.atguigu.ggkt.subject.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.atguigu.ggkt.model.vod.Subject;
import com.atguigu.ggkt.subject.mapper.SubjectMapper;
import com.atguigu.ggkt.vo.vod.SubjectEeVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExcelListener extends AnalysisEventListener<SubjectEeVo> {
    @Autowired
    private SubjectMapper mapper;
    @Override
    public void invoke(SubjectEeVo subjectEeVo, AnalysisContext analysisContext) {
        //处理每一行的数据
        Subject subject = new Subject();
        BeanUtils.copyProperties(subjectEeVo,subject);
        mapper.insert(subject);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
