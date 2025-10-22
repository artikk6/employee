package ru.artemii.employee.payload;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class EmployeePayload {
    @Size(message = "Field firstname size must be between 2 and 255 characters", min = 2, max = 255)
    private String firstname;

    @Size(message = "Field lastname size must be between 2 and 255 characters", min = 2, max = 255)
    private String lastname;

    @NotBlank(message = "username is mandatory")
    @Size(message = "Field username size must be between 7 and 255 characters", min = 7, max = 255)
    private String username;

    @NotNull(message = "birthday is mandatory")
    @PastOrPresent(message = "the date cannot be current or later than current")
    private LocalDate birthday;

    @Min(message = "the salary cannot be less than 22,440", value = 22_440)
    @Max(message = "the salary cannot be more than 2,000,000", value = 2_000_000)
    private BigDecimal salary;
}
