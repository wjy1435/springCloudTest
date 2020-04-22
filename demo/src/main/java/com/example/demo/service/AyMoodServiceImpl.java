package com.example.demo.service;

import com.example.demo.entity.AyMood;
import com.example.demo.producer.AyMoodProducer;
import com.example.demo.repository.AyMoodRepository;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

@Service
public class AyMoodServiceImpl implements  AyMoodService{


    @Resource
    private AyMoodProducer ayMoodProducer;

    @Autowired
    private AyMoodRepository ayMoodRepository;

    @Override
    public AyMood save(AyMood ayMood) {

        AyMood save = ayMoodRepository.save(ayMood);
        return save;
    }
    private static Destination destination = new ActiveMQQueue("ay.queue.asyn.save");
    @Override
    public String asynSave(AyMood ayMood) {
        ayMoodProducer.sendMessage(destination,ayMood);
        return "success";
    }

}
