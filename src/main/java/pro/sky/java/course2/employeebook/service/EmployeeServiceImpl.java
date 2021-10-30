package pro.sky.java.course2.employeebook.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeebook.domain.Employee;
import pro.sky.java.course2.employeebook.exception.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees = new ArrayList<>();
    private Employee employeeForSearch;

    @Override
    public String removeEmployee(String firstName, String lastName) {
        employeeForSearch = new Employee(firstName,lastName);
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).equals(employeeForSearch)) {
                employees.remove(i);
                return String.format("Сотрудник %s %s успешно удален!", firstName, lastName);
            }
        }
        throw new EmployeeNotFoundException();
    }

    public String addEmployee(String firstName, String lastName) {
        employees.add(new Employee(firstName, lastName));
        return String.format("Сотрудник %s %s успешно добавлен!", firstName, lastName);
    }

    public Employee findEmployee(String firstName, String lastName) {
        employeeForSearch = new Employee(firstName,lastName);
        for (Employee employee : employees) {
            if (employee.equals(employeeForSearch)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

}

