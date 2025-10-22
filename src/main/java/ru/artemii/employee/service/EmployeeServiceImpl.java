package ru.artemii.employee.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.artemii.employee.entity.EmployeeEntity;
import ru.artemii.employee.exception.NotFoundException;
import ru.artemii.employee.payload.EmployeePayload;
import ru.artemii.employee.payload.mapper.EmployeeMapper;
import ru.artemii.employee.repository.EmployeeRepository;

import java.math.BigDecimal;
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
    public List<EmployeePayload> getEmployees(String sortBy) {
        if (sortBy == null)
            sortBy = "firstname";
        List<EmployeeEntity> employees = employeeRepository.findAll(Sort.by(sortBy));
        return employees.stream().map(employeeMapper::toPayload).toList();
    }

    @Override
    @Transactional
    public EmployeePayload addEmployee(EmployeePayload employee) {
        return employeeMapper.toPayload(employeeRepository.save(employeeMapper.toEntity(employee)));
    }

    @Override
    @Transactional
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
        return employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employee with ID " + id + " not found"));
    }

    private BigDecimal getSumSalary() {
        return employeeRepository.findAll().stream()
                .map(EmployeeEntity::getSalary)
                .reduce((value, acc) -> acc.add(value))
                .orElse(BigDecimal.ZERO);
    }

    @Override
    public BigDecimal getTotalBudget() {
        return getSumSalary();
    }

    @Override
    public Integer getAverageSalary() {
        return (int) (getTotalBudget().longValue() / employeeRepository.count());
    }
}
