package ru.artemii.employee.payload.mapper;

import org.springframework.stereotype.Component;
import ru.artemii.employee.entity.EmployeeEntity;
import ru.artemii.employee.payload.EmployeePayload;

@Component
public class EmployeeMapper {

    public EmployeePayload toPayload(EmployeeEntity employee) {
        return EmployeePayload.builder()
                .firstname(employee.getFirstname())
                .lastname(employee.getLastname())
                .birthday(employee.getBirthday())
                .salary(employee.getSalary())
                .build();
    }

    public EmployeeEntity toEntity(EmployeePayload employee) {
        return EmployeeEntity.builder()
                .firstname(employee.getFirstname())
                .lastname(employee.getLastname())
                .birthday(employee.getBirthday())
                .salary(employee.getSalary())
                .build();
    }
}
