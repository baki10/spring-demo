package com.bakigoal.hibernate.dao;

import com.bakigoal.hibernate.model.Person;

import java.util.List;

public interface PersonDAO {
    void save(Person p);

    void update(Person p);

    void delete(Person p);

    List<Person> list();
}
