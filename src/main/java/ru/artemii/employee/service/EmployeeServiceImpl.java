package ru.artemii.employee.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.artemii.employee.entity.EmployeeEntity;
import ru.artemii.employee.payload.EmployeePayload;
import ru.artemii.employee.payload.mapper.EmployeeMapper;
import ru.artemii.employee.repository.EmployeeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeePayload getEmployee(Long id) {
        return employeeMapper.toPayload(getEntityEmployee(id));
    }

    @Override
    public List<EmployeePayload> getEmployees() {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        if (employees.isEmpty()) throw new RuntimeException("employees is empty");

        return employees.stream().map(employeeMapper::toPayload).toList();
    }

    @Override
    public EmployeePayload addEmployee(EmployeePayload employee) {
        return employeeMapper.toPayload(employeeRepository.save(employeeMapper.toEntity(employee)));
    }

    @Override
    public EmployeePayload updateEmployee(Long id, EmployeePayload employee) {
        EmployeeEntity employeeEntity = getEntityEmployee(id);
        employeeEntity.setFirstname(employee.getFirstname());
        employeeEntity.setLastname(employee.getLastname());
        employeeEntity.setBirthday(employee.getBirthday());
        employeeEntity.setSalary(employee.getSalary());

        employeeRepository.save(employeeEntity);
        return employeeMapper.toPayload(employeeEntity);
    }

    @Override
    @Transactional
    public void deleteEmployee(Long id) {
        employeeRepository.delete(getEntityEmployee(id));
    }

    private EmployeeEntity getEntityEmployee(Long id) {
        return employeeRepository.findById(id).orElseThrow();
    }
}
