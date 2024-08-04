package com.riwi.filtro_lovelace.api.dto.request;

import com.riwi.filtro_lovelace.util.enums.MultimediaType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class MultimediaBasicRequest {
    @NotNull(message = "Type is required")
    private MultimediaType type;

    @NotBlank(message = "Url is required")
    private String url;

    @NotNull(message = "Active is required")
    private Boolean active;

    // @NotNull(message = "Lesson id is required")
    // private Long lessonId;

}
