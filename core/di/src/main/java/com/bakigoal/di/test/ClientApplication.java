package com.bakigoal.di.test;

import com.bakigoal.di.config.DIConfiguration;
import com.bakigoal.di.consumer.MyApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClientApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfiguration.class);
        MyApplication app = context.getBean(MyApplication.class);
        app.processMessage("Hello From MyApplication class", "abcdef@gmail.com");
    }
}
