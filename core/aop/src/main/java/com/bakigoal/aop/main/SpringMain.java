package com.bakigoal.aop.main;

import com.bakigoal.aop.services.EmployeeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        EmployeeService employeeService = context.getBean("employeeService", EmployeeService.class);

        System.out.println(employeeService.getEmployee().getName());
        employeeService.getEmployee().setName("Bakigoal");
        employeeService.getEmployee().throwException();

        context.close();
    }
}
