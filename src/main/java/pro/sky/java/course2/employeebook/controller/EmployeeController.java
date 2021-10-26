package pro.sky.java.course2.employeebook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.employeebook.domain.Employee;
import pro.sky.java.course2.employeebook.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String showWelcomeMessage() {
        return "Добро пожаловать в книгу сотрудников!";
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        employeeService.add(firstName, lastName);
        return "Сотрудник " + firstName + " " + lastName + " успешно создан!";
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        employeeService.remove(firstName, lastName);
        return "Сотрудник " + firstName + " " + lastName + " успешно удален!";
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.find(firstName, lastName);
    }

}
