package com.riwi.filtro_lovelace.api.dto.response.basics_responses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class ClassBasicResponse {
    private Long id;
    private String name;
    private String description;
    private LocalDate createdAt;
    private Boolean active;


}