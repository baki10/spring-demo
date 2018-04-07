package com.bakigoal.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() throws InterruptedException {
        logger.info("Welcome home!");

        // wait for a second
        Thread.sleep(1000);

        logger.info("Before returning view page");
        return "home";
    }
}
