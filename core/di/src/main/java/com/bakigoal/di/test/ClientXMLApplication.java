package com.bakigoal.di.test;

import com.bakigoal.di.consumer.MyXMLApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientXMLApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        MyXMLApplication app = context.getBean(MyXMLApplication.class);
        app.processMessage("Hello From MyXMLApplication class", "abcdef@gmail.com");
        // close the context
        context.close();
    }
}
