package com.bakigoal.di.consumer;

import com.bakigoal.di.services.MessageService;

public class MyXMLApplication {

    private MessageService service;

    public void setService(MessageService messageService) {
        service = messageService;
    }

    public boolean processMessage(String message, String to) {
        //some magic like validation, logging etc
        return service.sendMessage(message, to);
    }
}
