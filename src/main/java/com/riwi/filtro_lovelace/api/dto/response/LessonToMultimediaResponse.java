package com.riwi.filtro_lovelace.api.dto.response;

import java.util.List;

import com.riwi.filtro_lovelace.api.dto.response.basics_responses.LessonBasicResponse;
import com.riwi.filtro_lovelace.api.dto.response.basics_responses.MultimediaBasicResponse;

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
public class LessonToMultimediaResponse extends LessonBasicResponse{
        private List<MultimediaBasicResponse> multimediaContent;

}
