package com.riwi.filtro_lovelace.api.dto.response;

import com.riwi.filtro_lovelace.api.dto.request.MultimediaBasicRequest;
import com.riwi.filtro_lovelace.api.dto.response.basics_responses.LessonBasicResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = false)
public class MultimediaResponse extends MultimediaBasicRequest {
    private LessonBasicResponse lesson;
}
