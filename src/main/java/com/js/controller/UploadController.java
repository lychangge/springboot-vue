package com.js.controller;

import com.js.util.QiniuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

    @Autowired
    QiniuUtils qiniuUtils;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile multipartFile){
        String originalFilename = multipartFile.getOriginalFilename();
        return  qiniuUtils.upload(multipartFile);
    }

}
