package ru.artemii.employee.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.artemii.employee.payload.EmployeePayload;
import ru.artemii.employee.service.EmployeeService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<EmployeePayload> getEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployee(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<EmployeePayload>> getEmployees(@RequestParam(required = false) String sortBy) {
        return ResponseEntity.ok(employeeService.getEmployees(sortBy));
    }

    @PostMapping("/")
    public ResponseEntity<EmployeePayload> createEmployee(@Valid @RequestBody EmployeePayload employee) {
        return ResponseEntity.ok(employeeService.addEmployee(employee));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EmployeePayload> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeePayload employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/total-salary")
    public ResponseEntity<BigDecimal> getTotalBudget() {
        return ResponseEntity.ok(employeeService.getTotalBudget());
    }

    @GetMapping("/average-salary")
    public ResponseEntity<Integer> getAverageBudget() {
        return ResponseEntity.ok(employeeService.getAverageSalary());
    }
}
