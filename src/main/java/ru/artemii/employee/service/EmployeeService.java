package ru.artemii.employee.service;

import ru.artemii.employee.payload.EmployeePayload;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeService {
    EmployeePayload getEmployee(Long id);
    List<EmployeePayload> getEmployees(String sortBy);
    EmployeePayload addEmployee(EmployeePayload employee);
    EmployeePayload updateEmployee(Long id, EmployeePayload employee);
    void deleteEmployee(Long id);
    BigDecimal getTotalBudget();
    Integer getAverageSalary();
}
