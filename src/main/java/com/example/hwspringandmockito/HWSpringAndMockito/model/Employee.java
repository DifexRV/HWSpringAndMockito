package com.example.hwspringandmockito.HWSpringAndMockito.model;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.*;

public class Employee {

    private final String firstName;
    private final String lastName;
    private Integer id;
    private Integer salary;



    public Employee(String firstName, String lastName, int department, int salary) {
        this.firstName = capitalize(firstName.toLowerCase());
        this.lastName = capitalize(lastName.toLowerCase());
        this.id = department;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String toString() {
        return "firstName: " + getFirstName() + ", lastName: " + getLastName() + ". department: " + getId() + ". salary: " + getSalary() + ".";
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Employee employee = (Employee) other;
        return Objects.equals(getFirstName(), employee.firstName) &&
                Objects.equals(getLastName(), employee.lastName) &&
                Objects.equals(getId(), employee.id) &&
                Objects.equals(getSalary(), employee.salary);
    }

    public int hashCode() {
        return Objects.hash(firstName, lastName, id, salary);
    }

}
