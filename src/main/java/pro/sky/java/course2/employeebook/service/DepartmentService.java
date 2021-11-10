package pro.sky.java.course2.employeebook.service;

import pro.sky.java.course2.employeebook.domain.Employee;

import java.util.List;
import java.util.Set;

public interface DepartmentService {
    Employee getMaxSalaryEmployeeByDepartment(int departmentId);
    Employee getMinSalaryEmployeeByDepartment(int departmentId);
    Set<Employee> getAllDepartmentEmployees(int departmentId);
    List<Employee> getAllEmployeesSortedByDepartment();
}
