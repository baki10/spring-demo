package com.bakigoal.hibernate.dao;

import com.bakigoal.hibernate.model.Person;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class PersonDAOImpl implements PersonDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        try {
            return this.sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            return this.sessionFactory.openSession();
        }
    }

    /**
     * We are using Hibernate session transaction management
     */
    @Override
    public void save(Person p) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
    }

    /**
     * Spring declarative transaction management using @Transactional annotation
     */
    @Override
    @Transactional
    public void update(Person p) {
        Session session = getSession();
        Person person = session.get(Person.class, p.getId());
        person.setName(p.getName());
        person.setCountry(p.getCountry());
    }

    @Override
    @Transactional
    public void delete(Person p) {
        Session session = getSession();
        session.delete(p);
    }

    @Override
    public List<Person> list() {
        Session session = getSession();
        return session.createQuery("from Person", Person.class).list();
    }
}
