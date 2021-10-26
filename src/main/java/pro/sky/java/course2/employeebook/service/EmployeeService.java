package pro.sky.java.course2.employeebook.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeebook.domain.Employee;
import pro.sky.java.course2.employeebook.exception.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();

    public void remove(String firstName, String lastName) {
        for (int i = 0; i < employees.size(); i++) {
            if (firstName.equals(employees.get(i).getFirstName()) && lastName.equals(employees.get(i).getLastName())) {
                employees.remove(i);
                return;
            }
        }
        throw new EmployeeNotFoundException();
    }


    public void add(String firstName, String lastName) {
        employees.add(new Employee(firstName, lastName));
    }

    public Employee find(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (firstName.equals(employee.getFirstName()) && lastName.equals(employee.getLastName())) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public List<Employee> all() {
        return employees;
    }

}

