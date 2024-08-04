package com.riwi.filtro_lovelace.infrastructure.helpers.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import com.riwi.filtro_lovelace.api.dto.request.MultimediaBasicRequest;
import com.riwi.filtro_lovelace.api.dto.response.basics_responses.MultimediaBasicResponse;
import com.riwi.filtro_lovelace.domain.entities.Multimedia;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MultimediaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "lesson", ignore = true)
    Multimedia toClassEntity(MultimediaBasicRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "lesson", ignore = true)
    Multimedia toUpdateEntity(MultimediaBasicRequest request, @MappingTarget Multimedia entity);

    @InheritInverseConfiguration
    MultimediaBasicResponse toMultimediaBasicResponse(Multimedia entity);

}
