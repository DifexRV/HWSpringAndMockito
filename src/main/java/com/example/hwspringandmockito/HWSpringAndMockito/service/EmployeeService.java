package com.example.hwspringandmockito.HWSpringAndMockito.service;

import com.example.hwspringandmockito.HWSpringAndMockito.model.Employee;

import java.util.Collection;

public interface EmployeeService {

    Collection<Employee> employeeList();
    Employee addEmployee(Employee employee) throws Exception;

    Employee removeEmployee(Employee employee) throws Exception;

    Employee findEmployee(Employee employee) throws Exception;

}