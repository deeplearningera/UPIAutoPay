package org.springboot.dto.request;

import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class MandateRequest {

    @NotNull(message = "User ID is mandatory")
    private Long userId;

    @NotNull(message = "Amount is mandatory")
    @Min(value = 1, message = "Amount must be greater than 0")
    private Double amount;

    @NotBlank(message = "Frequency is mandatory")
    private String frequency;

    @NotNull(message = "Start date is mandatory")
    @FutureOrPresent(message = "Start date must be in the present or future")
    private LocalDate startDate;

    @NotNull(message = "End date is mandatory")
    @Future(message = "End date must be in the future")
    private LocalDate endDate;

}
