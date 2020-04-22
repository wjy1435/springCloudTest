package com.example.demo.producer;


import com.example.demo.entity.AyMood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

@Service
public class AyMoodProducer {

  @Resource
  private JmsMessagingTemplate jmsMessagingTemplate;

  public void sendMessage(Destination destination, String message) {
    this.jmsMessagingTemplate.convertAndSend(destination,message);
  }

  public void sendMessage(Destination destination, AyMood ayMood) {
    this.jmsMessagingTemplate.convertAndSend(destination,ayMood);
  }


}
