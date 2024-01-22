package com.example.hwspringandmockito.HWSpringAndMockito.service;

import com.example.hwspringandmockito.HWSpringAndMockito.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    String greetingsDepartments();

    Integer departmentsSumSalary(Integer id);
    Employee departmentsMinSalary(Integer id);
    Employee departmentsMaxSalary(Integer id);
    List<Employee> departmentList(Integer id);

    Map<Integer,List<Employee>> departmentMap();
}