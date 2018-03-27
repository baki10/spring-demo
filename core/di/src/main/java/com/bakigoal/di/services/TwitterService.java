package com.bakigoal.di.services;

public class TwitterService implements MessageService {

    public boolean sendMessage(String message, String to) {
        System.out.println("Twitter message Sent to " + to + " with Message=" + message);
        return true;
    }
}
