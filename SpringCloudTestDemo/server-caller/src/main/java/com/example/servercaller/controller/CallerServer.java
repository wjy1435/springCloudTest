package com.example.servercaller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CallerServer {
    @RequestMapping("/sayhello")
    @ResponseBody
    public String sayHello(){
        return "我是来自caller的服务端，你好呀！";
    }
}