package pro.sky.java.course2.employeebook.service;

import pro.sky.java.course2.employeebook.domain.Employee;

import java.util.Collection;

public interface DepartmentService {
    Employee getMaxSalaryEmployeeByDepartment(int departmentId);
    Employee getMinSalaryEmployeeByDepartment(int departmentId);
    Collection<Employee> getAllEmployeesByDepartmentId(Integer departmentId);
}
