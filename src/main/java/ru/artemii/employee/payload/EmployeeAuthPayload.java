package ru.artemii.employee.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeAuthPayload {
    private String username;
    private String password;
}
