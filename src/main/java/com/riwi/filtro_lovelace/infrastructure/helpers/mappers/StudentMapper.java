package com.riwi.filtro_lovelace.infrastructure.helpers.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import com.riwi.filtro_lovelace.api.dto.request.StudentBasicRequest;
import com.riwi.filtro_lovelace.api.dto.response.StudentResponse;
import com.riwi.filtro_lovelace.api.dto.response.basics_responses.StudentBasicResponse;
import com.riwi.filtro_lovelace.domain.entities.Student;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "classEntity", ignore = true)
    Student toClassEntity(StudentBasicRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "classEntity", ignore = true)
    Student toUpdateEntity(StudentBasicRequest request, @MappingTarget Student entity);

    @InheritInverseConfiguration
    StudentBasicResponse toStudentBasicResponse(Student entity);

    @InheritInverseConfiguration
    StudentResponse toStudentResponse(Student entity);


}
