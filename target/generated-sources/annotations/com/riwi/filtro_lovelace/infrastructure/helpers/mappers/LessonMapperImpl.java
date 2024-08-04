package com.riwi.filtro_lovelace.infrastructure.helpers.mappers;

import com.riwi.filtro_lovelace.api.dto.request.LessonBasicRequest;
import com.riwi.filtro_lovelace.api.dto.response.LessonResponse;
import com.riwi.filtro_lovelace.api.dto.response.LessonToMultimediaResponse;
import com.riwi.filtro_lovelace.api.dto.response.basics_responses.ClassBasicResponse;
import com.riwi.filtro_lovelace.api.dto.response.basics_responses.LessonBasicResponse;
import com.riwi.filtro_lovelace.api.dto.response.basics_responses.MultimediaBasicResponse;
import com.riwi.filtro_lovelace.domain.entities.ClassEntity;
import com.riwi.filtro_lovelace.domain.entities.Lesson;
import com.riwi.filtro_lovelace.domain.entities.Multimedia;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-04T09:20:49-0500",
    comments = "version: 1.6.0.Beta2, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class LessonMapperImpl implements LessonMapper {

    @Override
    public Lesson toClassEntity(LessonBasicRequest request) {
        if ( request == null ) {
            return null;
        }

        Lesson lesson = new Lesson();

        lesson.setActive( request.getActive() );
        lesson.setContent( request.getContent() );
        lesson.setTitle( request.getTitle() );

        return lesson;
    }

    @Override
    public Lesson toUpdateEntity(LessonBasicRequest request, Lesson entity) {
        if ( request == null ) {
            return entity;
        }

        entity.setActive( request.getActive() );
        entity.setContent( request.getContent() );
        entity.setTitle( request.getTitle() );

        return entity;
    }

    @Override
    public LessonBasicResponse toLessonBasicResponse(Lesson entity) {
        if ( entity == null ) {
            return null;
        }

        LessonBasicResponse.LessonBasicResponseBuilder<?, ?> lessonBasicResponse = LessonBasicResponse.builder();

        lessonBasicResponse.active( entity.getActive() );
        lessonBasicResponse.content( entity.getContent() );
        lessonBasicResponse.createdAt( entity.getCreatedAt() );
        lessonBasicResponse.id( entity.getId() );
        lessonBasicResponse.title( entity.getTitle() );

        return lessonBasicResponse.build();
    }

    @Override
    public LessonToMultimediaResponse toLessonToMultimediaResponse(Lesson entity) {
        if ( entity == null ) {
            return null;
        }

        LessonToMultimediaResponse.LessonToMultimediaResponseBuilder<?, ?> lessonToMultimediaResponse = LessonToMultimediaResponse.builder();

        lessonToMultimediaResponse.active( entity.getActive() );
        lessonToMultimediaResponse.content( entity.getContent() );
        lessonToMultimediaResponse.createdAt( entity.getCreatedAt() );
        lessonToMultimediaResponse.id( entity.getId() );
        lessonToMultimediaResponse.title( entity.getTitle() );
        lessonToMultimediaResponse.multimediaContent( multimediaListToMultimediaBasicResponseList( entity.getMultimediaContent() ) );

        return lessonToMultimediaResponse.build();
    }

    @Override
    public LessonResponse toLessonResponse(Lesson entity) {
        if ( entity == null ) {
            return null;
        }

        LessonResponse.LessonResponseBuilder<?, ?> lessonResponse = LessonResponse.builder();

        lessonResponse.active( entity.getActive() );
        lessonResponse.content( entity.getContent() );
        lessonResponse.createdAt( entity.getCreatedAt() );
        lessonResponse.id( entity.getId() );
        lessonResponse.title( entity.getTitle() );
        lessonResponse.classEntity( classEntityToClassBasicResponse( entity.getClassEntity() ) );
        lessonResponse.multimediaContent( multimediaListToMultimediaBasicResponseList( entity.getMultimediaContent() ) );

        return lessonResponse.build();
    }

    protected MultimediaBasicResponse multimediaToMultimediaBasicResponse(Multimedia multimedia) {
        if ( multimedia == null ) {
            return null;
        }

        MultimediaBasicResponse.MultimediaBasicResponseBuilder<?, ?> multimediaBasicResponse = MultimediaBasicResponse.builder();

        multimediaBasicResponse.active( multimedia.getActive() );
        multimediaBasicResponse.createdAt( multimedia.getCreatedAt() );
        multimediaBasicResponse.id( multimedia.getId() );
        multimediaBasicResponse.type( multimedia.getType() );
        multimediaBasicResponse.url( multimedia.getUrl() );

        return multimediaBasicResponse.build();
    }

    protected List<MultimediaBasicResponse> multimediaListToMultimediaBasicResponseList(List<Multimedia> list) {
        if ( list == null ) {
            return null;
        }

        List<MultimediaBasicResponse> list1 = new ArrayList<MultimediaBasicResponse>( list.size() );
        for ( Multimedia multimedia : list ) {
            list1.add( multimediaToMultimediaBasicResponse( multimedia ) );
        }

        return list1;
    }

    protected ClassBasicResponse classEntityToClassBasicResponse(ClassEntity classEntity) {
        if ( classEntity == null ) {
            return null;
        }

        ClassBasicResponse.ClassBasicResponseBuilder<?, ?> classBasicResponse = ClassBasicResponse.builder();

        classBasicResponse.active( classEntity.getActive() );
        classBasicResponse.createdAt( classEntity.getCreatedAt() );
        classBasicResponse.description( classEntity.getDescription() );
        classBasicResponse.id( classEntity.getId() );
        classBasicResponse.name( classEntity.getName() );

        return classBasicResponse.build();
    }
}
