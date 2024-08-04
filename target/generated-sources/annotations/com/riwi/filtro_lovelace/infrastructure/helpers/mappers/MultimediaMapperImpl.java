package com.riwi.filtro_lovelace.infrastructure.helpers.mappers;

import com.riwi.filtro_lovelace.api.dto.request.MultimediaBasicRequest;
import com.riwi.filtro_lovelace.api.dto.response.basics_responses.MultimediaBasicResponse;
import com.riwi.filtro_lovelace.domain.entities.Multimedia;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-04T09:21:07-0500",
    comments = "version: 1.6.0.Beta2, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class MultimediaMapperImpl implements MultimediaMapper {

    @Override
    public Multimedia toClassEntity(MultimediaBasicRequest request) {
        if ( request == null ) {
            return null;
        }

        Multimedia multimedia = new Multimedia();

        multimedia.setActive( request.getActive() );
        multimedia.setType( request.getType() );
        multimedia.setUrl( request.getUrl() );

        return multimedia;
    }

    @Override
    public Multimedia toUpdateEntity(MultimediaBasicRequest request, Multimedia entity) {
        if ( request == null ) {
            return entity;
        }

        entity.setActive( request.getActive() );
        entity.setType( request.getType() );
        entity.setUrl( request.getUrl() );

        return entity;
    }

    @Override
    public MultimediaBasicResponse toMultimediaBasicResponse(Multimedia entity) {
        if ( entity == null ) {
            return null;
        }

        MultimediaBasicResponse.MultimediaBasicResponseBuilder<?, ?> multimediaBasicResponse = MultimediaBasicResponse.builder();

        multimediaBasicResponse.active( entity.getActive() );
        multimediaBasicResponse.createdAt( entity.getCreatedAt() );
        multimediaBasicResponse.id( entity.getId() );
        multimediaBasicResponse.type( entity.getType() );
        multimediaBasicResponse.url( entity.getUrl() );

        return multimediaBasicResponse.build();
    }
}
