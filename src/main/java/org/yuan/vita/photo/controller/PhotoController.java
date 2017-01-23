package org.yuan.vita.photo.controller;

import java.util.Map;
import java.util.HashMap;

import org.springframework.stereotype.Controller;

import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("photo")
public class PhotoController {

  @ResponseBody
  @RequestMapping("upload")
  public Map<String,Object> upload(@RequestParam("file") MultipartFile file) {
    //String suffix = file.getOriginalFilename();
    //suffix = ".jpg"
    //String fileName = String.valueOf(new Date().getTime()) + suffix;
     
    return null; 
  }

}
