package com.example.serverprovider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHello {
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "来自provider的服务";
    }
}