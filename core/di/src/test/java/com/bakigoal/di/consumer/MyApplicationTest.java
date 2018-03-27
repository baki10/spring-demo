package com.bakigoal.di.consumer;

import com.bakigoal.di.services.MessageService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"com.bakigoal.di.consumer"})
public class MyApplicationTest {

    private AnnotationConfigApplicationContext context;

    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(MyApplicationTest.class);
    }

    @After
    public void tearDown() {
        context.close();
    }

    @Bean
    public MessageService getMessageService() {
        return new MessageService() {
            public boolean sendMessage(String msg, String rec) {
                System.out.println("Mock Service");
                System.out.println(msg);
                System.out.println(rec);
                return true;
            }
        };
    }

    @Test
    public void processMessage(){
        MyApplication app = context.getBean(MyApplication.class);
        Assert.assertTrue(app.processMessage("Hello From MyApplicationTest", "abcdef@gmail.com"));
    }

}