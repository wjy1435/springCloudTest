package com.example.demo.service;

import com.example.demo.entity.AyMood;
import org.springframework.stereotype.Service;

@Service
public interface AyMoodService {

    AyMood save(AyMood ayMood);
    String asynSave(AyMood ayMood);

}
