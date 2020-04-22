package com.example.demo.service;

import com.example.demo.model.AyUserAttachmentRel;
import com.example.demo.repository.AyUserAttachmentRelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AyUserAttachmentRelServiceImpl implements AyUserAttachmentRelService {

    @Autowired
    private AyUserAttachmentRelRepository ayUserAttachmentRelRepository;

    @Override
    public AyUserAttachmentRel save(AyUserAttachmentRel ayUserAttachmentRel) {
        return ayUserAttachmentRelRepository.save(ayUserAttachmentRel);
    }
}
