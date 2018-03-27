package com.bakigoal.aop.services;

import com.bakigoal.aop.model.Employee;

public class EmployeeService {

    private Employee employee;

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee e) {
        this.employee = e;
    }
}
