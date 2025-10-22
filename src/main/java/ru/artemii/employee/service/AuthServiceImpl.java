package ru.artemii.employee.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.artemii.employee.entity.EmployeeEntity;
import ru.artemii.employee.enums.RoleAccess;
import ru.artemii.employee.exception.NotFoundException;
import ru.artemii.employee.payload.EmployeeAuthPayload;
import ru.artemii.employee.repository.EmployeeRepository;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public void register(EmployeeAuthPayload employee) {
        if (employeeRepository.existsByUsername(employee.getUsername()))
            throw new NotFoundException("employee already exists");

        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                .username(employee.getUsername())
                .password(encoder.encode(employee.getPassword()))
                .role(RoleAccess.USER)
                .build();
        employeeRepository.save(employeeEntity);
    }

    @Override
    public void login(EmployeeAuthPayload employee) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        employee.getUsername(),
                        employee.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }


}

