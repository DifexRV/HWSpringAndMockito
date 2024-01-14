package com.example.hwspringandmockito.HWSpringAndMockito.controller;

import com.example.hwspringandmockito.HWSpringAndMockito.model.Employee;
import com.example.hwspringandmockito.HWSpringAndMockito.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class HWSpringAndMockitoDepartmentController {

    private final DepartmentService employeeServiceDepartmentImpl;

    public HWSpringAndMockitoDepartmentController(DepartmentService employeeServiceDepartmentImpl) {
        this.employeeServiceDepartmentImpl = employeeServiceDepartmentImpl;
    }


    @GetMapping
    public String greetingsDepartments() {
        return employeeServiceDepartmentImpl.greetingsDepartments();
    }

    @GetMapping(path = "{id}/salary/sum")
    public Integer departmentsSumSalary(@PathVariable("id") Integer id) {
        return employeeServiceDepartmentImpl.departmentsSumSalary(id);
    }

    @GetMapping(path = "/{id}/salary/min")
     public Employee departmentsMinSalary(@PathVariable("id") Integer id) {
        return employeeServiceDepartmentImpl.departmentsMinSalary(id);
    }

    @GetMapping(path = "/{id}/salary/max")
    public Employee departmentsMaxSalary(@PathVariable("id") Integer id) {
        return employeeServiceDepartmentImpl.departmentsMaxSalary(id);
    }

    @GetMapping(path = "/{id}/employees")
    public ResponseEntity<?> departmentList(@PathVariable(value = "id", required = false) Integer id) {
        return ResponseEntity.ok(employeeServiceDepartmentImpl.departmentList(id));
    }

    @GetMapping(path = "/employees")
    public ResponseEntity<?> departmentMap(@PathVariable(value = "id", required = false) Integer id) {
        return ResponseEntity.ok(employeeServiceDepartmentImpl.departmentMap());

    }

}
