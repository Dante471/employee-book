package pro.sky.java.course2.employeebook.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeebook.domain.Employee;
import pro.sky.java.course2.employeebook.exception.EmployeeNotFoundException;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public String removeEmployee(String firstName, String lastName) {
        if (employees.containsKey(firstName + lastName)) {
            employees.remove(firstName + lastName);
            return String.format("Сотрудник %s %s успешно удален!", firstName, lastName);
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public String addEmployee(String firstName, String lastName) {
        employees.put(firstName + lastName, new Employee(firstName, lastName));
        return String.format("Сотрудник %s %s успешно добавлен!", firstName, lastName);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        if (employees.containsKey(firstName + lastName)) {
            return employees.get(firstName + lastName);
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Map<String, Employee> getAllEmployees() {
        return employees;
    }

}

