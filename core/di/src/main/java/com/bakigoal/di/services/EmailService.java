package com.bakigoal.di.services;

public class EmailService implements MessageService {

    public boolean sendMessage(String message, String to) {
        System.out.println("Email Sent to " + to + " with Message=" + message);
        return true;
    }
}
