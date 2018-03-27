package com.bakigoal.di.consumer;

import com.bakigoal.di.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyApplication {

    private MessageService service;

    @Autowired
    public void setService(MessageService messageService) {
        service = messageService;
    }

    public boolean processMessage(String message, String to) {
        //some magic like validation, logging etc
        return service.sendMessage(message, to);
    }
}