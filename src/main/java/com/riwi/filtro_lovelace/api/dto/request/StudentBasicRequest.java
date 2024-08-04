package com.riwi.filtro_lovelace.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class StudentBasicRequest {
    @NotBlank(message = "Name is required")
    @Size(min = 1, max = 255, message = "Name must be between 2 and 255 characters")
    private String name;

    @Email(message = "Email is invalid")
    @NotBlank(message = "Email is required")
    @Size(min = 1, max = 255, message = "Email must be between 2 and 255 characters")
    private String email;

    @NotNull(message = "Active is required")
    private Boolean active;

    @NotNull(message = "ClassId is required")
    private Long classId;

}
