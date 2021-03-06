package com.bakigoal.jdbc.main;

import com.bakigoal.jdbc.dao.EmployeeDAO;
import com.bakigoal.jdbc.model.Employee;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Random;

public class SpringMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc-core.xml");
        EmployeeDAO employeeDAO = context.getBean("employeeDAO", EmployeeDAO.class);
        EmployeeDAO employeeDAOJDBCTemplate = context.getBean("employeeDAOJDBCTemplate", EmployeeDAO.class);
        System.out.println(employeeDAO.getClass());
        System.out.println(employeeDAOJDBCTemplate.getClass());

        //Run some tests for JDBC CRUD operations
        Employee emp = new Employee();
        int id = new Random().nextInt(1000);
        emp.setId(id);
        emp.setName("John Snow");
        emp.setRole("Developer");

        //Create
        employeeDAO.save(emp);

        //Read
        Employee emp1 = employeeDAOJDBCTemplate.getById(id);
        System.out.println("Employee Retrieved::" + emp1);

        //Update
        emp.setRole("Tester");
        employeeDAOJDBCTemplate.update(emp);

        //Get All
        List<Employee> empList = employeeDAO.getAll();
        System.out.println(empList);

        //Delete
        employeeDAO.deleteById(id);

        //Close Spring Context
        context.close();

        System.out.println("DONE");
    }
}
