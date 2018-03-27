package com.bakigoal.di.config;

import com.bakigoal.di.services.EmailService;
import com.bakigoal.di.services.MessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"com.bakigoal.di.consumer"})
public class DIConfiguration {

    @Bean
	public MessageService getMessageService(){
		return new EmailService();
	}
}
