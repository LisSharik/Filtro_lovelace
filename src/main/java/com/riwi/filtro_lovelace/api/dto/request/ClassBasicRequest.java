package com.riwi.filtro_lovelace.api.dto.request;

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
public class ClassBasicRequest {
    @NotBlank(message = "Name is required")
    @Size(min = 1, max = 255, message = "Name must be between 2 and 255 characters")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Active is required")
    private Boolean active;
    
}
