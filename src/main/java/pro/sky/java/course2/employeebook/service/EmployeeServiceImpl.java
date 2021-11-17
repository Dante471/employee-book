package pro.sky.java.course2.employeebook.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeebook.domain.Employee;
import pro.sky.java.course2.employeebook.exception.EmployeeNotFoundException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        if (employees.containsKey(firstName + lastName)) {
            Employee employeeForReturn = employees.get(firstName + lastName);
            employees.remove(firstName + lastName);
            return employeeForReturn;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int departmentId, int salary) {
        employees.put(firstName + lastName, new Employee(firstName, lastName, departmentId, salary));
        return employees.get(firstName + lastName);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {

        return employees.values()
                .stream()
                .filter(employee -> (employee.getFirstName() + employee.getLastName()).equals(firstName + lastName))
                .findAny()
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return employees.values();
    }

}

