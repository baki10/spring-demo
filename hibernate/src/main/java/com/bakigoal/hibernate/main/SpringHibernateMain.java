package com.bakigoal.hibernate.main;

import com.bakigoal.hibernate.dao.PersonDAO;
import com.bakigoal.hibernate.model.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHibernateMain {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-hibernate.xml");
        PersonDAO personDAO = context.getBean(PersonDAO.class);

        // save person 1
        Person person1 = new Person();
        person1.setName("John Snow");
        person1.setCountry("North");
        personDAO.save(person1);
        System.out.println("Person1::" + person1);

        // save person 2
        Person person2 = new Person();
        person2.setName("Putin");
        person2.setCountry("Russia");
        personDAO.save(person2);
        System.out.println("Person2::" + person2);

        // update person 2
        person2.setName("Vladimir Putin");
        personDAO.update(person2);

        // delete person 1
        personDAO.delete(person1);

        // get all
        for (Person p : personDAO.list()) {
            System.out.println("Person List::" + p);
        }

        //close resources
        context.close();
    }
}
