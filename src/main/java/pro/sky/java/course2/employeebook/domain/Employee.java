package pro.sky.java.course2.employeebook.domain;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private int departmentId;
    private int salary;


    public Employee(String firstName, String secondName, int departmentId, int salary) {
        this.firstName = firstName;
        this.lastName = secondName;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public int getSalary() {
        return salary;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return departmentId == employee.departmentId && salary == employee.salary && firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, departmentId, salary);
    }
}

