package com.example.hwspringandmockito.HWSpringAndMockito.controller;

import com.example.hwspringandmockito.HWSpringAndMockito.model.Employee;
import com.example.hwspringandmockito.HWSpringAndMockito.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class HWSpringAndMockitoDepartmentController {

    private final DepartmentService employeeServiceDepartmentImpl;

    public HWSpringAndMockitoDepartmentController(DepartmentService employeeServiceDepartmentImpl) {
        this.employeeServiceDepartmentImpl = employeeServiceDepartmentImpl;
    }


    @GetMapping
    public String greetingsDepartments() {
        return employeeServiceDepartmentImpl.greetingsDepartments();
    }

    @GetMapping(path = "/min-salary")
    public Employee departmentsMinSalary(@RequestParam(value = "department", required = false) Integer department) {
        return employeeServiceDepartmentImpl.departmentsMinSalary(department);
    }

    @GetMapping(path = "/max-salary")
    public Employee departmentsMaxSalary(@RequestParam(value = "department", required = false) Integer department) {
        return employeeServiceDepartmentImpl.departmentsMaxSalary(department);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<?> departmentList(@RequestParam(value = "department", required = false) Integer department) {
        return department == null ?
                ResponseEntity.ok(employeeServiceDepartmentImpl.departmentsMap())
                :
                ResponseEntity.ok(employeeServiceDepartmentImpl.departmentList(department));
    }

}
