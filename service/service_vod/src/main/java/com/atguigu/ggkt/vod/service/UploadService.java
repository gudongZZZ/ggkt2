package com.atguigu.ggkt.vod.service;


import org.springframework.web.multipart.MultipartFile;


public interface UploadService {
    String upload(MultipartFile file);
}
