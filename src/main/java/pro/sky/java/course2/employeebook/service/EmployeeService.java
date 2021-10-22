package pro.sky.java.course2.employeebook.service;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final Employee[] employees = new Employee[1];

    public void remove(String firstName, String lastName){
        try {
            for (int i = 0; i < employees.length; i++) {
                if (firstName.equals(employees[i].getFirstName()) && lastName.equals(employees[i].getLastName())) {
                    employees[i] = null;
                }
            }
        } catch (NullPointerException e) {
            throw new EmployeeNotFoundException();
        }
    }

    public void add(String firstName, String lastName) {
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] == null) {
                    employees[i] = new Employee(firstName, lastName);
                    return;
                } else {
                    throw new ArrayOverflowException();
            }
        }
    }

    public Employee find(String firstName, String lastName) {
        try {
            for (Employee employee : employees) {
                if (firstName.equals(employee.getFirstName()) && lastName.equals(employee.getLastName())) {
                    return employee;
                }
            }
        } catch (NullPointerException e) {
            throw new EmployeeNotFoundException();
        }
        return null;
    }

}