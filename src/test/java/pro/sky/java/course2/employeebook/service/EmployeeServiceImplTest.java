package pro.sky.java.course2.employeebook.service;

import org.junit.jupiter.api.Test;
import pro.sky.java.course2.employeebook.domain.Employee;
import pro.sky.java.course2.employeebook.exception.EmployeeNotFoundException;
import pro.sky.java.course2.employeebook.exception.IllegalNameException;

import java.util.Collection;

import static pro.sky.java.course2.employeebook.constants.EmployeeBookConstants.*;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceImplTest {


    private final EmployeeServiceImpl out = new EmployeeServiceImpl();

    @Test
    public void shouldReturnRemovedEmployee() {
        out.addEmployee(TEST_FIRST_NAME, TEST_LAST_NAME, TEST_DEPARTMENT1, TEST_SALARY);
        Employee result = out.removeEmployee(TEST_FIRST_NAME, TEST_LAST_NAME);
        assertEquals(TEST_EMPLOYEE, result);
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenEmployeeToRemoveAbsent() {
        assertThrows(EmployeeNotFoundException.class,
                () -> out.removeEmployee(TEST_FIRST_NAME, TEST_LAST_NAME));
    }

    @Test
    public void shouldReturnAddedEmployee() {
        Employee result = out.addEmployee(TEST_FIRST_NAME, TEST_LAST_NAME, TEST_DEPARTMENT1, TEST_SALARY);
        assertEquals(TEST_EMPLOYEE, result);
    }

    @Test
    public void shouldThrowIllegalNameExceptionWhenNameIsNotAlpha() {
        assertThrows(IllegalNameException.class,
                () -> out.addEmployee(INCORRECT_FIRST_NAME, INCORRECT_LAST_NAME, TEST_DEPARTMENT1, TEST_SALARY));
    }

    @Test
    public void shouldReplaceExistingEmployeeWhenNameExists() {
        out.addEmployee(TEST_FIRST_NAME, TEST_LAST_NAME, TEST_DEPARTMENT1, TEST_SALARY);
        out.addEmployee(TEST_FIRST_NAME, TEST_LAST_NAME, TEST_DEPARTMENT2, TEST_SALARY);
        assertNotEquals(TEST_DEPARTMENT1, out.findEmployee(TEST_FIRST_NAME, TEST_LAST_NAME).getDepartmentId());
    }

    @Test
    public void shouldCapitalizeEmployeeName() {
        Employee result = out.addEmployee(TEST_FIRST_NAME_SMALL_LETTER, TEST_LAST_NAME_SMALL_LETTER, TEST_DEPARTMENT1, TEST_SALARY);
        assertEquals(TEST_FIRST_NAME, result.getFirstName());
        assertEquals(TEST_LAST_NAME, result.getLastName());
    }

    @Test
    public void shouldReturnDesiredEmployee() {
        out.addEmployee(TEST_FIRST_NAME, TEST_LAST_NAME, TEST_DEPARTMENT1, TEST_SALARY);
        Employee result = out.findEmployee(TEST_FIRST_NAME, TEST_LAST_NAME);
        assertEquals(TEST_EMPLOYEE, result);
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenDesiredEmployeeIsMissing() {
        assertThrows(EmployeeNotFoundException.class,
                () -> out.findEmployee(TEST_FIRST_NAME,TEST_LAST_NAME));
    }

    @Test
    public void shouldReturnCorrectCollection() {
        out.addEmployee(TEST_FIRST_NAME, TEST_LAST_NAME, TEST_DEPARTMENT1, TEST_SALARY);
        out.addEmployee(TEST_FIRST_NAME2, TEST_LAST_NAME2, TEST_DEPARTMENT2, TEST_SALARY2);
        Collection<Employee> result = out.getAllEmployees();
        assertIterableEquals(CORRECT_COLLECTION, result);
    }

}
