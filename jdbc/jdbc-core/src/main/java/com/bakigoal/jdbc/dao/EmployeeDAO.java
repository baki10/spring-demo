package com.bakigoal.jdbc.dao;

import com.bakigoal.jdbc.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    void save(Employee employee);

    Employee getById(int id);

    void update(Employee employee);

    void deleteById(int id);

    List<Employee> getAll();
}