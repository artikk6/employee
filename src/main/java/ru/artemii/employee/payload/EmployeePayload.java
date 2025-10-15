package ru.artemii.employee.payload;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class EmployeePayload {
    @NotBlank(message = "name is mandatory")
    @Size(min=2, max = 255)
    private String firstname;

    @NotBlank(message = "surname is mandatory")
    @Size(min=2, max = 255)
    private String lastname;

    @NotNull(message = "birthday is mandatory")
    @PastOrPresent
    private LocalDate birthday;

    @Min(22_440)
    @Max(2_000_000)
    private BigDecimal salary;
}
