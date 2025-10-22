package ru.artemii.employee.payload.mapper;

import org.springframework.stereotype.Component;
import ru.artemii.employee.entity.EmployeeEntity;
import ru.artemii.employee.payload.EmployeeAuthPayload;

@Component
public class EmployeeAuthMapper {
    public EmployeeAuthPayload toPayload(EmployeeEntity employee) {
        return EmployeeAuthPayload.builder()
                .username(employee.getUsername())
                .password(employee.getPassword())
                .build();
    }

    public EmployeeEntity toEntity(EmployeeAuthPayload employee) {
        return EmployeeEntity.builder()
                .username(employee.getUsername())
                .password(employee.getPassword())
                .build();
    }
}
