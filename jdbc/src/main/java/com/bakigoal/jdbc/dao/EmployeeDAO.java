package com.bakigoal.jdbc.dao;

import com.bakigoal.jdbc.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    void save(Employee employee);

    Employee getById(int id);

    void update(Employee employee);

    void deleteById(int id);

    List<Employee> getAll();

    // db queries
    String INSERT_QUERY = "INSERT INTO Employee (id, name, role) VALUES (?,?,?)";
    String SELECT_BY_ID_QUERY = "SELECT id, name, role FROM Employee WHERE id = ?";
    String UPDATE_QUERY = "UPDATE Employee SET name=?, role=? WHERE id=?";
    String DELETE_QUERY = "DELETE FROM Employee WHERE id=?";
    String SELECT_ALL_QUERY = "SELECT id, name, role FROM Employee";
}