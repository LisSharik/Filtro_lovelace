package com.riwi.filtro_lovelace.api.dto.request;

import java.util.List;


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
public class LessonBasicRequest {
    @NotBlank(message = "Title is required")
    @Size(min = 1, max = 255, message = "Title must be between 2 and 255 characters")
    private String title;

    @NotBlank(message = "Content is required")
    private String content;

    @NotNull(message = "Active is required")
    private Boolean active;

    @NotNull(message = "Class id is required")
    private Long classId;

    @NotNull(message = "Multimedia content is required")
    private List<MultimediaBasicRequest> multimediaContent;
    
}
