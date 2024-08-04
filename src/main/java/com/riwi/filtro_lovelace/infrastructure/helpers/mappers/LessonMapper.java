package com.riwi.filtro_lovelace.infrastructure.helpers.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import com.riwi.filtro_lovelace.api.dto.request.LessonBasicRequest;
import com.riwi.filtro_lovelace.api.dto.response.LessonResponse;
import com.riwi.filtro_lovelace.api.dto.response.LessonToMultimediaResponse;
import com.riwi.filtro_lovelace.api.dto.response.basics_responses.LessonBasicResponse;
import com.riwi.filtro_lovelace.domain.entities.Lesson;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LessonMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "classEntity", ignore = true)
    @Mapping(target = "multimediaContent", ignore = true)
    Lesson toClassEntity(LessonBasicRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "classEntity", ignore = true)
     @Mapping(target = "multimediaContent", ignore = true)
    Lesson toUpdateEntity(LessonBasicRequest request, @MappingTarget Lesson entity);

    @InheritInverseConfiguration
    LessonBasicResponse toLessonBasicResponse(Lesson entity);

    @InheritInverseConfiguration
    LessonToMultimediaResponse toLessonToMultimediaResponse(Lesson entity);

    @InheritInverseConfiguration
    LessonResponse toLessonResponse(Lesson entity);


}
