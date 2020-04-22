package com.example.demo.listener;

import com.example.demo.entity.AyUser;
import com.example.demo.service.CommonService;
import com.example.demo.tool.testTool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

@WebListener
public class AyUserListener implements ServletContextListener {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private CommonService commonService;
    private static final String All_USER = "AllUser";

    Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public  void contextInitialized(ServletContextEvent servletContextEvent){
    List<AyUser> userList = commonService.findAll();
///
    redisTemplate.delete(All_USER);
    redisTemplate.opsForList().leftPushAll(All_USER,userList);
    List<AyUser> queryUserList = redisTemplate.opsForList().range(All_USER,0,-1);
    System.out.println("缓存中的用户数是"+queryUserList.size());
//        System.out.println("ServletContext  上下文初始化");
        logger.info("ServletContext  上下文初始化"+System.currentTimeMillis());
    }
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent){
//        System.out.println("ServletContext 上下文销毁");
        logger.info("ServletContext  上下文初始化"+System.currentTimeMillis());
    }


}
