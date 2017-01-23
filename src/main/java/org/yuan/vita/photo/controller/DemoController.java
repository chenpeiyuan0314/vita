package org.yuan.vita.photo.controller;

import java.util.Map;
import java.util.HashMap;

import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;

import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("demo")
public class DemoController {

  /**
   * 显示JSP
   */
  @RequestMapping("html")
  public String html(Model model) {
    return "hello";
  }
  
  /**
   * 显示JSON
   */
  @ResponseBody
  @RequestMapping("json")
  public Map<String,Object> json() {
    Map<String,Object> data = new HashMap<String,Object>();
    data.put("text", "hello");
    return data;
  }

  /**
   * 上传文件
   */
  @ResponseBody
  @RequestMapping("upload")
  public Map<String,Object> upload(@RequestParam("file") MultipartFile file) {
    Map<String,Object> data = new HashMap<String,Object>();
    data.put("result", "");
    return data;
  }

}
