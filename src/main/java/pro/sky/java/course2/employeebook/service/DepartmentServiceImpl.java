package pro.sky.java.course2.employeebook.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeebook.domain.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getMaxSalaryEmployeeByDepartment(int departmentId) {
        return employeeService.getAllEmployees()
                .stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(employee -> employee.getSalary()))
                .stream().findAny()
                .orElseThrow();
    }

    @Override
    public Employee getMinSalaryEmployeeByDepartment(int departmentId) {
        return employeeService.getAllEmployees()
                .stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .min(Comparator.comparingInt(employee -> employee.getSalary()))
                .stream().findAny()
                .orElseThrow();
    }

    @Override
    public Set<Employee> getAllDepartmentEmployees(int departmentId) {
        return employeeService.getAllEmployees()
                .stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .collect(Collectors.toSet());
    }

    @Override
    public List<Employee> getAllEmployeesSortedByDepartment() {
        return employeeService.getAllEmployees()
                .stream()
                .sorted(Comparator.comparing(Employee::getDepartmentId))
                .collect(Collectors.toList());
    }
}
