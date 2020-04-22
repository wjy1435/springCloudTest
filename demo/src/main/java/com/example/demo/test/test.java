package com.example.demo.test;

import com.example.demo.entity.AyMood;
import com.example.demo.service.AyMoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.Date;

public class test  implements  A,B {
    @Override
    public void testb() {

    }

    @Override
    public void testB() {

    }

    public void testB(int i) {

    }

    @Override
    public void testA() {

    }

//    @Autowired
//    private AyMoodService ayMoodService;


//    public void testAyMood(){
//        AyMood  ayMood = new AyMood();
//        ayMood.setId("1");
//        ayMood.setUserId("1");
//        ayMood.setPraiseNum(0);
//        ayMood.setContent("第一条微信 说说");
//        long time = System.currentTimeMillis();
//        ayMood.setPublishTime(String.valueOf(time));
//
////        AyMood mood = ayMoodService.save(ayMood);
//
//    }




}
