package com.example.hwspringandmockito.HWSpringAndMockito.service;

import com.example.hwspringandmockito.HWSpringAndMockito.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceDepartmentImpl implements DepartmentService {

    private final EmployeeServiceImpl employeeServiceimpl;

    public EmployeeServiceDepartmentImpl(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceimpl = employeeServiceImpl;
    }

    @Override
    public String greetingsDepartments() {
        return "<b>Добро пожаловать в раздел Депортаментов</b>";
    }


    @Override
    public Integer departmentsSumSalary(Integer id) {
        Integer sumSalary = employeeServiceimpl.employeeList().stream()
                .filter(dep -> dep != null && dep.getId() == id)
                .mapToInt(Employee::getSalary)
                .sum();
        return sumSalary;
    }

    @Override
    public Employee departmentsMinSalary(Integer id) {

        return employeeServiceimpl.employeeList().stream().filter(dep -> dep != null && dep.getId() == id)
                .min(Comparator.comparingInt(dep -> dep.getSalary()))
                .orElseThrow(() -> new RuntimeException("Позиция не найдена"));

    }

    @Override
    public Employee departmentsMaxSalary(Integer id) {

        return employeeServiceimpl.employeeList().stream().filter(dep -> dep != null && dep.getId() == id)
                .max(Comparator.comparingInt(dep -> dep.getSalary()))
                .orElseThrow(() -> new RuntimeException("Позиция не найдена"));

    }


    @Override
    public List<Employee> departmentList(Integer id) {
        return employeeServiceimpl.employeeList().stream()
                .filter(dep -> dep.getId() == id)
                .sorted(Comparator.comparingInt(dep -> dep.getSalary()))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> departmentMap() {

        return employeeServiceimpl.employeeList()
                .stream().collect(Collectors.groupingBy(dep -> dep.getId()));
    }
}