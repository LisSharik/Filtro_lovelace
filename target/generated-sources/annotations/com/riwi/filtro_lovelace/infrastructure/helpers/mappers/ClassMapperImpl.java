package com.riwi.filtro_lovelace.infrastructure.helpers.mappers;

import com.riwi.filtro_lovelace.api.dto.request.ClassBasicRequest;
import com.riwi.filtro_lovelace.api.dto.response.ClassResponse;
import com.riwi.filtro_lovelace.api.dto.response.basics_responses.ClassBasicResponse;
import com.riwi.filtro_lovelace.api.dto.response.basics_responses.LessonBasicResponse;
import com.riwi.filtro_lovelace.api.dto.response.basics_responses.StudentBasicResponse;
import com.riwi.filtro_lovelace.domain.entities.ClassEntity;
import com.riwi.filtro_lovelace.domain.entities.Lesson;
import com.riwi.filtro_lovelace.domain.entities.Student;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-04T09:20:59-0500",
    comments = "version: 1.6.0.Beta2, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class ClassMapperImpl implements ClassMapper {

    @Override
    public ClassEntity toClassEntity(ClassBasicRequest request) {
        if ( request == null ) {
            return null;
        }

        ClassEntity classEntity = new ClassEntity();

        classEntity.setActive( request.getActive() );
        classEntity.setDescription( request.getDescription() );
        classEntity.setName( request.getName() );

        return classEntity;
    }

    @Override
    public ClassEntity toUpdateEntity(ClassBasicRequest request, ClassEntity entity) {
        if ( request == null ) {
            return entity;
        }

        entity.setActive( request.getActive() );
        entity.setDescription( request.getDescription() );
        entity.setName( request.getName() );

        return entity;
    }

    @Override
    public ClassBasicResponse toClassBasicResponse(ClassEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ClassBasicResponse.ClassBasicResponseBuilder<?, ?> classBasicResponse = ClassBasicResponse.builder();

        classBasicResponse.active( entity.getActive() );
        classBasicResponse.createdAt( entity.getCreatedAt() );
        classBasicResponse.description( entity.getDescription() );
        classBasicResponse.id( entity.getId() );
        classBasicResponse.name( entity.getName() );

        return classBasicResponse.build();
    }

    @Override
    public ClassResponse toClassResponse(ClassEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ClassResponse.ClassResponseBuilder<?, ?> classResponse = ClassResponse.builder();

        classResponse.active( entity.getActive() );
        classResponse.createdAt( entity.getCreatedAt() );
        classResponse.description( entity.getDescription() );
        classResponse.id( entity.getId() );
        classResponse.name( entity.getName() );
        classResponse.lessons( lessonListToLessonBasicResponseList( entity.getLessons() ) );
        classResponse.students( studentListToStudentBasicResponseList( entity.getStudents() ) );

        return classResponse.build();
    }

    protected LessonBasicResponse lessonToLessonBasicResponse(Lesson lesson) {
        if ( lesson == null ) {
            return null;
        }

        LessonBasicResponse.LessonBasicResponseBuilder<?, ?> lessonBasicResponse = LessonBasicResponse.builder();

        lessonBasicResponse.active( lesson.getActive() );
        lessonBasicResponse.content( lesson.getContent() );
        lessonBasicResponse.createdAt( lesson.getCreatedAt() );
        lessonBasicResponse.id( lesson.getId() );
        lessonBasicResponse.title( lesson.getTitle() );

        return lessonBasicResponse.build();
    }

    protected List<LessonBasicResponse> lessonListToLessonBasicResponseList(List<Lesson> list) {
        if ( list == null ) {
            return null;
        }

        List<LessonBasicResponse> list1 = new ArrayList<LessonBasicResponse>( list.size() );
        for ( Lesson lesson : list ) {
            list1.add( lessonToLessonBasicResponse( lesson ) );
        }

        return list1;
    }

    protected StudentBasicResponse studentToStudentBasicResponse(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentBasicResponse.StudentBasicResponseBuilder<?, ?> studentBasicResponse = StudentBasicResponse.builder();

        studentBasicResponse.active( student.getActive() );
        studentBasicResponse.createdAt( student.getCreatedAt() );
        studentBasicResponse.email( student.getEmail() );
        studentBasicResponse.id( student.getId() );
        studentBasicResponse.name( student.getName() );

        return studentBasicResponse.build();
    }

    protected List<StudentBasicResponse> studentListToStudentBasicResponseList(List<Student> list) {
        if ( list == null ) {
            return null;
        }

        List<StudentBasicResponse> list1 = new ArrayList<StudentBasicResponse>( list.size() );
        for ( Student student : list ) {
            list1.add( studentToStudentBasicResponse( student ) );
        }

        return list1;
    }
}
