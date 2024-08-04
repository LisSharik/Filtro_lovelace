package com.riwi.filtro_lovelace.infrastructure.helpers.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import com.riwi.filtro_lovelace.api.dto.request.ClassBasicRequest;
import com.riwi.filtro_lovelace.api.dto.response.ClassResponse;
import com.riwi.filtro_lovelace.api.dto.response.basics_responses.ClassBasicResponse;
import com.riwi.filtro_lovelace.domain.entities.ClassEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClassMapper  {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "lessons", ignore = true)
    @Mapping(target = "students", ignore = true)
    ClassEntity toClassEntity(ClassBasicRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "lessons", ignore = true)
    @Mapping(target = "students", ignore = true)
    ClassEntity toUpdateEntity(ClassBasicRequest request, @MappingTarget ClassEntity entity);
    
    @InheritInverseConfiguration
    ClassBasicResponse toClassBasicResponse(ClassEntity entity);

    @InheritInverseConfiguration
    ClassResponse toClassResponse(ClassEntity entity);
    // Multimedia toClassEntity(MultimediaBasicRequest request);


}
