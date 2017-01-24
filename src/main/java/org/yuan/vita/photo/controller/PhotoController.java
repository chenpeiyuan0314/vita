package org.yuan.vita.photo.controller;

import java.util.Map;
import java.util.HashMap;
import java.util.Date;

import org.yuan.vita.photo.util.FTPUtil;
import org.yuan.vita.photo.mode.Result;

import org.springframework.stereotype.Controller;

import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("photo")
public class PhotoController {
  
  /**
   *  上传图片到FTP
   */
  @ResponseBody
  @RequestMapping("upload")
  public Result upload(@RequestParam("file") MultipartFile file) {
    // 上传文件名
    String suffix = file.getOriginalFilename();
    suffix = suffix.substring(suffix.lastIndexOf("."));
    String fileName = String.valueOf(new Date().getTime()) + suffix;
     
    // 上传文件
    String dirPath = "upload";
    boolean success = false;
    try {
      success = FTPUtil.upload(file.getInputStream(), dirPath, fileName);
    } catch(Exception e) {
      e.printStackTrace();
    }

    if(success) {
      String data = "http://localhost:8080/ftp/" + dirPath + "/" + fileName;
      return Result.success(data);
    }

    return Result.failure(); 
  }
 
}
