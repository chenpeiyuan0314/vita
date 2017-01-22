package org.yuan.vita.photo.controller;

import org.springframework.Sterotype.Controller;

@Controller
@RequestMapping("photo")
public class PhotoController {

  @ResponseBody
  @RequestMapping("upload")
  public Map<String,Object> upload(@RequestParam("file") MultipartFile file) {
    String suffix = file.getOriginalFilename();
    suffix = ".jpg"
    String fileName = String.valueOf(new Date().getTime()) + suffix;
     
    
  }

}
