package pro.sky.java.course2.employeebook.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeebook.domain.Employee;
import pro.sky.java.course2.employeebook.exception.ArrayOverflowException;
import pro.sky.java.course2.employeebook.exception.EmployeeNotFoundException;

@Service
public class EmployeeService {
    private final Employee[] employees = new Employee[1];

    public void remove(String firstName, String lastName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            }
            if (firstName.equals(employees[i].getFirstName()) && lastName.equals(employees[i].getLastName())) {
                employees[i] = null;
                return;
            }
        }
        throw new EmployeeNotFoundException();
    }


    public void add(String firstName, String lastName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(firstName, lastName);
                return;
            }
        }
        throw new ArrayOverflowException();
    }

    public Employee find(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (firstName.equals(employee.getFirstName()) && lastName.equals(employee.getLastName())) {
                    return employee;
                }
            }
        throw new EmployeeNotFoundException();
    }

}

