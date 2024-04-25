package com.atguigu.ggkt.subject.service;

import com.atguigu.ggkt.model.vod.Subject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


public interface SubjectService extends IService<Subject> {
    List<Subject> getSubjectList(Long id);
    void importData(MultipartFile file);
    void exportData(HttpServletResponse response);
}
