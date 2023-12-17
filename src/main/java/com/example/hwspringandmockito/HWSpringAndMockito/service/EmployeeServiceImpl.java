package com.example.hwspringandmockito.HWSpringAndMockito.service;

import com.example.hwspringandmockito.HWSpringAndMockito.exception.EmployeeAlreadyAddedException;
import com.example.hwspringandmockito.HWSpringAndMockito.exception.EmployeeNotFoundException;
import com.example.hwspringandmockito.HWSpringAndMockito.exception.EmployeeStorageIsFullException;
import com.example.hwspringandmockito.HWSpringAndMockito.exception.InvalidInputException;
import com.example.hwspringandmockito.HWSpringAndMockito.model.Employee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Map<String, Employee> employees = new HashMap<>(Map.of());

    {
        employees.put("Тролль", new Employee("Борис", "Тролль", 1, 23000));
        employees.put("Кранова", new Employee("Матильда", "Кранова", 1, 13000));
        employees.put("Врунишкин", new Employee("Аркадий", "Врунишкин", 2, 35000));
        employees.put("Грустный", new Employee("Олег", "Грустный", 3, 11000));
        employees.put("Бристоль", new Employee("Матеос", "Бристоль", 1, 20000));
        employees.put("Медлеходов", new Employee("Бронислав", "Медлеходов", 2, 30000));
        employees.put("Горгона", new Employee("Медуза", "Горгона", 3, 18000));
        employees.put("Наглышов", new Employee("Глав", "Наглышов", 2, 37000));
        employees.put("Простофилин", new Employee("Иван", "Простофилин", 3, 7000));
    }

    @Override
    public Collection<Employee> employeeList() {
        return Collections.unmodifiableCollection(employees.values());
    }

    @Override
    public Employee addEmployee(Employee employee) throws Exception {
        validateInput(employee.getFirstName(),employee.getLastName());
        if (employees.size() >= 13) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.containsKey(employee.getFullName()) == true) {
            throw new EmployeeAlreadyAddedException();
        } else {
            employees.put(employee.getFullName(), employee);
        }
        return employee;
    }

    @Override
    public Employee removeEmployee(Employee employee) throws Exception {

        validateInput(employee.getFirstName(),employee.getLastName());

        if (employees.containsKey(employee.getFullName()) == false) {
            throw new EmployeeNotFoundException();
        } else {
            return employees.remove(employee.getFullName());
        }

    }

    @Override
    public Employee findEmployee(Employee employee) throws Exception {

        validateInput(employee.getFirstName(),employee.getLastName());

        if (employees.containsKey(employee.getFullName()) == false) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(employee.getFullName());
    }

    private void validateInput(String firstName, String lastName) throws Exception {
        if (!(isAlpha(firstName) && isAlpha(lastName))){
            throw new InvalidInputException();
        }
    }

}