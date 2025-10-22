package ru.artemii.employee.service;

import ru.artemii.employee.payload.EmployeeAuthPayload;

public interface AuthService {
    void register(EmployeeAuthPayload employee);
    void login(EmployeeAuthPayload employee);
}
