package com.example.hwspringandmockito.HWSpringAndMockito;


import com.example.hwspringandmockito.HWSpringAndMockito.model.Employee;
import com.example.hwspringandmockito.HWSpringAndMockito.service.EmployeeServiceDepartmentImpl;
import com.example.hwspringandmockito.HWSpringAndMockito.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeServiceDepartmentImplTest {
    EmployeeServiceImpl employeeService = Mockito.mock(EmployeeServiceImpl.class);
    EmployeeServiceDepartmentImpl departmentServiceImpl = new EmployeeServiceDepartmentImpl(employeeService);

    List<Employee> employees = Arrays.asList(
            new Employee("John", "Doe", 1, 1000),
            new Employee("Jane", "Doe", 1, 2000),
            new Employee("Джеймс", "Doe", 2, 3000),
            new Employee("Джуди", "Doe", 2, 4000)
    );

    @Test
    public void testGreetingsDepartments() {
        String expected = "<b>Добро пожаловать в раздел Депортаментов</b>";
        String actual = departmentServiceImpl.greetingsDepartments();
        assertEquals(expected, actual);
    }


    @Test

    public void testDepartmentsSumSalary() {
        Mockito.when(employeeService.employeeList()).thenReturn(employees);
        EmployeeServiceDepartmentImpl departmentService = new EmployeeServiceDepartmentImpl(employeeService);
        Integer expected = 3000;
        Integer actual = departmentService.departmentsSumSalary(1);
        assertEquals(expected, actual);
    }

    @Test
    public void testDepartmentsMinSalary() {
        Mockito.when(employeeService.employeeList()).thenReturn(employees);

        EmployeeServiceDepartmentImpl departmentService = new EmployeeServiceDepartmentImpl(employeeService);
        Employee expected = new Employee("John", "Doe", 1, 1000);
        Employee actual = departmentService.departmentsMinSalary(1);
        assertEquals(expected, actual);
    }

    @Test
    public void testDepartmentsMaxSalary() {
        Mockito.when(employeeService.employeeList()).thenReturn(employees);

        EmployeeServiceDepartmentImpl departmentService = new EmployeeServiceDepartmentImpl(employeeService);
        Employee expected = new Employee("Jane", "Doe", 1, 2000);
        Employee actual = departmentService.departmentsMaxSalary(1);
        assertEquals(expected, actual);
    }

    @Test
    public void testDepartmentList() {
        Mockito.when(employeeService.employeeList()).thenReturn(employees);
        EmployeeServiceDepartmentImpl departmentService = new EmployeeServiceDepartmentImpl(employeeService);
        List<Employee> expected = Arrays.asList(
                new Employee("John", "Doe", 1, 1000),
                new Employee("Jane", "Doe", 1, 2000));
        List<Employee> actual = departmentService.departmentList(1);
        assertEquals(expected, actual);
    }

}
