package ru.artemii.employee.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.artemii.employee.payload.EmployeeAuthPayload;
import ru.artemii.employee.service.AuthService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody EmployeeAuthPayload employee) {
        authService.register(employee);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody EmployeeAuthPayload employee) {
        authService.login(employee);
        return ResponseEntity.ok().build();
    }
}
