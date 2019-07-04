package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping("/hello")
    @ResponseBody
    public String index(){
        return "<h1 style='color:red;'>hello world<h1>";
    }

    @RequestMapping("/pageindex")
    //@ResponseBody
    public String jspIndex(){

        return "index";
    }
}
