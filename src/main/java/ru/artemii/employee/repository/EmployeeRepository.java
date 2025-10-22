package ru.artemii.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import ru.artemii.employee.entity.EmployeeEntity;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    Optional<EmployeeEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
}
