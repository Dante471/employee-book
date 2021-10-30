package pro.sky.java.course2.employeebook.service;

import pro.sky.java.course2.employeebook.domain.Employee;

import java.util.List;

public interface EmployeeService {
    String removeEmployee(String firstName, String lastName);
    String addEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    List<Employee> getAllEmployees();
}
