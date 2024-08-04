package com.riwi.filtro_lovelace.api.dto.response.basics_responses;

import java.time.LocalDate;

import com.riwi.filtro_lovelace.util.enums.MultimediaType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class MultimediaBasicResponse {
    private Long id;
    private MultimediaType type;
    private String url;
    private LocalDate createdAt;
    private Boolean active;

}
