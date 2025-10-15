package ru.artemii.employee.service;

import ru.artemii.employee.payload.EmployeePayload;

import java.util.List;

public interface EmployeeService {
    EmployeePayload getEmployee(Long id);
    List<EmployeePayload> getEmployees();
    EmployeePayload addEmployee(EmployeePayload employee);
    EmployeePayload updateEmployee(Long id, EmployeePayload employee);
    void deleteEmployee(Long id);
}
