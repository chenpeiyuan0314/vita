package org.yuan.vita.springmvc;

import java.util.Map;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class TestController {

  @RequestMapping("tpl")
  public String tpl() {
    return "tpl";
  }

  @ResponseBody
  @RequestMapping("json")
  public Map<String,Object> json() {
    Map<String,Object> result = new HashMap<String,Object>();
    result.put("text","json");
    return result;
  }

}

