package pro.sky.java.course2.employeebook.service;

import pro.sky.java.course2.employeebook.domain.Employee;

import java.util.Collection;

public interface EmployeeService {
    void removeEmployee(String firstName, String lastName);
    void addEmployee(String firstName, String lastName, int department, int salary);
    Employee findEmployee(String firstName, String lastName);
    Collection<Employee> getAllEmployees();
}

