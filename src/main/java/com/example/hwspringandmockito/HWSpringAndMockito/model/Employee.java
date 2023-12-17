package com.example.hwspringandmockito.HWSpringAndMockito.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.*;

public class Employee {

    private final String firstName;
    private final String lastName;
    private Integer department;
    private Integer salary;



    public Employee(String firstName, String lastName, int department, int salary) {
        this.firstName = capitalize(firstName.toLowerCase());
        this.lastName = capitalize(lastName.toLowerCase());
        this.department = department;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String toString() {
        return "firstName: " + getFirstName() + ", lastName: " + getLastName() + ". department: " + getDepartment() + ". salary: " + getSalary() + ".";
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Employee employee = (Employee) other;
        return Objects.equals(getFirstName(), employee.firstName) &&
                Objects.equals(getLastName(), employee.lastName) &&
                Objects.equals(getDepartment(), employee.department) &&
                Objects.equals(getSalary(), employee.salary);
    }

    public int hashCode() {
        return Objects.hash(firstName, lastName, department, salary);
    }

}
