package com.example.servercaller.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 调用者的接口方法是被调用者方法的声明，映射路径与被调用者方法的映射路径相同
 */
//@RequestMapping("/sayHello")
@FeignClient(value = "server-provider") //调用的服务名称
public interface SayHelloCaller {
    @RequestMapping("/hello")
    public String sayHello();
}
