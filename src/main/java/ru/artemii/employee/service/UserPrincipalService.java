package ru.artemii.employee.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.artemii.employee.repository.EmployeeRepository;
import ru.artemii.employee.security.UserPrincipal;

@Service
@RequiredArgsConstructor
public class UserPrincipalService implements UserDetailsService {
    private final EmployeeRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserPrincipal(
                repository.findByUsername(username)
                        .orElse(null)
        );
    }
}
