package com.bakigoal.jdbc.dao;

import com.bakigoal.jdbc.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeDAOJDBCTemplateImpl implements EmployeeDAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(Employee employee) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] args = new Object[]{employee.getId(), employee.getName(), employee.getRole()};

        int out = jdbcTemplate.update(INSERT_QUERY, args);
        if (out != 0) {
            System.out.println("EmployeeDAOJDBCTemplateImpl::Employee saved with id=" + employee.getId());
        } else {
            System.out.println("EmployeeDAOJDBCTemplateImpl::Employee save failed with id=" + employee.getId());
        }
    }

    @Override
    public Employee getById(int id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        return jdbcTemplate.queryForObject(SELECT_BY_ID_QUERY, new Object[]{id}, (resultSet, rowNum) -> {
            Employee employee = new Employee();
            employee.setId(resultSet.getInt("id"));
            employee.setName(resultSet.getString("name"));
            employee.setRole(resultSet.getString("role"));
            return employee;
        });
    }

    @Override
    public void update(Employee employee) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] args = new Object[]{employee.getName(), employee.getRole(), employee.getId()};

        int out = jdbcTemplate.update(UPDATE_QUERY, args);
        if (out != 0) {
            System.out.println("EmployeeDAOJDBCTemplateImpl::Employee updated with id=" + employee.getId());
        } else {
            System.out.println("EmployeeDAOJDBCTemplateImpl::No Employee found with id=" + employee.getId());
        }
    }

    @Override
    public void deleteById(int id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        int out = jdbcTemplate.update(DELETE_QUERY, id);
        if (out != 0) {
            System.out.println("EmployeeDAOJDBCTemplateImpl::Employee deleted with id=" + id);
        } else {
            System.out.println("EmployeeDAOJDBCTemplateImpl::No Employee found with id=" + id);
        }
    }

    @Override
    public List<Employee> getAll() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Employee> empList = new ArrayList<>();

        List<Map<String, Object>> empRows = jdbcTemplate.queryForList(SELECT_ALL_QUERY);

        for (Map<String, Object> empRow : empRows) {
            Employee emp = new Employee();
            emp.setId(Integer.parseInt(String.valueOf(empRow.get("id"))));
            emp.setName(String.valueOf(empRow.get("name")));
            emp.setRole(String.valueOf(empRow.get("role")));
            empList.add(emp);
        }
        return empList;
    }
}
