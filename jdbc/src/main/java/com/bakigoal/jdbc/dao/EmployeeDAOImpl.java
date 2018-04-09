package com.bakigoal.jdbc.dao;

import com.bakigoal.jdbc.model.Employee;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void save(Employee employee) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(INSERT_QUERY)) {

            ps.setInt(1, employee.getId());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getRole());
            int out = ps.executeUpdate();
            if (out != 0) {
                System.out.println("Employee saved with id=" + employee.getId());
            } else System.out.println("Employee save failed with id=" + employee.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Employee getById(int id) {
        Employee emp = null;
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_BY_ID_QUERY)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                emp = new Employee();
                emp.setId(id);
                emp.setName(rs.getString("name"));
                emp.setRole(rs.getString("role"));
                System.out.println("Employee Found::" + emp);
            } else {
                System.out.println("No Employee found with id=" + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }

    public void update(Employee employee) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(UPDATE_QUERY)) {

            ps.setString(1, employee.getName());
            ps.setString(2, employee.getRole());
            ps.setInt(3, employee.getId());
            int out = ps.executeUpdate();
            if (out != 0) {
                System.out.println("Employee updated with id=" + employee.getId());
            } else System.out.println("No Employee found with id=" + employee.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(DELETE_QUERY)) {

            ps.setInt(1, id);
            int out = ps.executeUpdate();
            if (out != 0) {
                System.out.println("Employee deleted with id=" + id);
            } else System.out.println("No Employee found with id=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getAll() {
        List<Employee> empList = new ArrayList<>();

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_ALL_QUERY);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Employee emp = new Employee();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setRole(rs.getString("role"));
                empList.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empList;
    }
}
