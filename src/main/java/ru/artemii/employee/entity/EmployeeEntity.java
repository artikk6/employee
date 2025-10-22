package ru.artemii.employee.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.artemii.employee.enums.RoleAccess;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "employee")
    private String firstname;

    @Column(columnDefinition = "company")
    private String lastname;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private RoleAccess role;

    private LocalDate birthday;

    @Column(precision = 10, scale = 2)
    private BigDecimal salary;

}
