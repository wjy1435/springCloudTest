package com.example.demo.consumer;

import com.example.demo.entity.AyMood;
import com.example.demo.service.AyMoodService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class AyMoodConsumber {

    @Resource
    private AyMoodService ayMoodService;


    @JmsListener(destination = "ay.queue")
    public void receiveQueue(String test){
        System.out.println("用户发表说说 "+test);
    }

    @JmsListener(destination = "ay.queue.asyn.save")
    public void receiveQueue(AyMood ayMood){
        ayMoodService.save(ayMood);
        System.out.println("用户发表说说 111111"+ayMood);
    }

}
