package pro.sky.java.course2.employeebook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.employeebook.domain.Employee;
import pro.sky.java.course2.employeebook.service.DepartmentServiceImpl;
import pro.sky.java.course2.employeebook.service.UserMessageServiceImpl;

import java.util.Collection;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentServiceImpl departmentService;
    private final UserMessageServiceImpl userMessageService;

    public DepartmentController(DepartmentServiceImpl departmentService, UserMessageServiceImpl userMessageService) {
        this.departmentService = departmentService;
        this.userMessageService = userMessageService;
    }

    @GetMapping
    public String showWelcomeMessage() {
        return userMessageService.showGreetings();
    }

    @GetMapping("/max-salary")
    public Employee showMaxSalaryEmployeeByDepartment(@RequestParam int departmentId) {
        return departmentService.getMaxSalaryEmployeeByDepartment(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee showMinSalaryEmployeeByDepartment(@RequestParam int departmentId) {
        return departmentService.getMinSalaryEmployeeByDepartment(departmentId);
    }

    @GetMapping("/all")
    public Collection<Employee> showAllEmployeesByDepartment(Integer departmentId) {
        return departmentService.getAllEmployeesByDepartmentId(departmentId);
    }

}
