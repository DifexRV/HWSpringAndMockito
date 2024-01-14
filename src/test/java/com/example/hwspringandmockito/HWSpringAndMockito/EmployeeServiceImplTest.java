package com.example.hwspringandmockito.HWSpringAndMockito;

import com.example.hwspringandmockito.HWSpringAndMockito.exception.EmployeeAlreadyAddedException;
import com.example.hwspringandmockito.HWSpringAndMockito.exception.EmployeeNotFoundException;
import com.example.hwspringandmockito.HWSpringAndMockito.exception.EmployeeStorageIsFullException;
import com.example.hwspringandmockito.HWSpringAndMockito.exception.InvalidInputException;
import com.example.hwspringandmockito.HWSpringAndMockito.model.Employee;
import com.example.hwspringandmockito.HWSpringAndMockito.service.EmployeeService;
import com.example.hwspringandmockito.HWSpringAndMockito.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceImplTest {

    EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
    Employee newEmployee = new Employee("Jhon", "Doe", 4, 25000);

    @Test
    public void testAddEmployee() throws Exception {
        Employee addedEmployee = employeeServiceImpl.addEmployee(newEmployee);
        assertEquals(newEmployee, addedEmployee);
        assertTrue(employeeServiceImpl.employeeList().contains(newEmployee));
        assertThrows(EmployeeAlreadyAddedException.class, () -> employeeServiceImpl.addEmployee(newEmployee));
        assertThrows(EmployeeAlreadyAddedException.class, () -> {
            for (int i = 0; i < 10; i++) {
                employeeServiceImpl.addEmployee(new Employee("First", "Last", i * 1, i * 110000));
            }
            employeeServiceImpl.addEmployee(new Employee("First", "Last", 1, 110000));
        });
    }

    @Test
    public void testRemoveEmployee() throws Exception {
        employeeServiceImpl.addEmployee(newEmployee);
        Employee removedEmployee = employeeServiceImpl.removeEmployee(newEmployee);
        assertEquals(newEmployee, removedEmployee);
        assertFalse(employeeServiceImpl.employeeList().contains(newEmployee));
        assertThrows(EmployeeNotFoundException.class, () -> employeeServiceImpl.removeEmployee(newEmployee));
    }

    @Test
    public void testFindEmployee() throws Exception {
        Employee employeeToFind = employeeServiceImpl.addEmployee(newEmployee);
        assertEquals(employeeToFind, employeeServiceImpl.findEmployee(employeeToFind));
        assertThrows(EmployeeNotFoundException.class, () -> {
            Employee notFoundEmployee = new Employee("Jane", "Doe", 5, 30000);
            employeeServiceImpl.findEmployee(notFoundEmployee);
        });

    }

    @Test
    public void testValidateInput() throws Exception {

        assertDoesNotThrow(() -> employeeServiceImpl.validateInput("John", "Doe"));
        assertThrows(InvalidInputException.class, () -> employeeServiceImpl.validateInput("John123", "Doe"));
        assertThrows(InvalidInputException.class, () -> employeeServiceImpl.validateInput("John", "Doe!@#"));

    }

}
