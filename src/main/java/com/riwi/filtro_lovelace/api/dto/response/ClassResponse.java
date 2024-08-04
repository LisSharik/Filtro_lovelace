package com.riwi.filtro_lovelace.api.dto.response;

import java.util.List;

import com.riwi.filtro_lovelace.api.dto.response.basics_responses.ClassBasicResponse;
import com.riwi.filtro_lovelace.api.dto.response.basics_responses.LessonBasicResponse;
import com.riwi.filtro_lovelace.api.dto.response.basics_responses.StudentBasicResponse;

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
public class ClassResponse extends ClassBasicResponse {
    private List<StudentBasicResponse> students;
    private List<LessonBasicResponse> lessons;
}
