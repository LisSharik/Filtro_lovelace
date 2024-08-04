package com.riwi.filtro_lovelace.infrastructure.helpers.mappers;

import com.riwi.filtro_lovelace.api.dto.request.StudentBasicRequest;
import com.riwi.filtro_lovelace.api.dto.response.StudentResponse;
import com.riwi.filtro_lovelace.api.dto.response.basics_responses.ClassBasicResponse;
import com.riwi.filtro_lovelace.api.dto.response.basics_responses.StudentBasicResponse;
import com.riwi.filtro_lovelace.domain.entities.ClassEntity;
import com.riwi.filtro_lovelace.domain.entities.Student;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-04T09:21:17-0500",
    comments = "version: 1.6.0.Beta2, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student toClassEntity(StudentBasicRequest request) {
        if ( request == null ) {
            return null;
        }

        Student student = new Student();

        student.setActive( request.getActive() );
        student.setEmail( request.getEmail() );
        student.setName( request.getName() );

        return student;
    }

    @Override
    public Student toUpdateEntity(StudentBasicRequest request, Student entity) {
        if ( request == null ) {
            return entity;
        }

        entity.setActive( request.getActive() );
        entity.setEmail( request.getEmail() );
        entity.setName( request.getName() );

        return entity;
    }

    @Override
    public StudentBasicResponse toStudentBasicResponse(Student entity) {
        if ( entity == null ) {
            return null;
        }

        StudentBasicResponse.StudentBasicResponseBuilder<?, ?> studentBasicResponse = StudentBasicResponse.builder();

        studentBasicResponse.active( entity.getActive() );
        studentBasicResponse.createdAt( entity.getCreatedAt() );
        studentBasicResponse.email( entity.getEmail() );
        studentBasicResponse.id( entity.getId() );
        studentBasicResponse.name( entity.getName() );

        return studentBasicResponse.build();
    }

    @Override
    public StudentResponse toStudentResponse(Student entity) {
        if ( entity == null ) {
            return null;
        }

        StudentResponse.StudentResponseBuilder<?, ?> studentResponse = StudentResponse.builder();

        studentResponse.active( entity.getActive() );
        studentResponse.createdAt( entity.getCreatedAt() );
        studentResponse.email( entity.getEmail() );
        studentResponse.id( entity.getId() );
        studentResponse.name( entity.getName() );
        studentResponse.classEntity( classEntityToClassBasicResponse( entity.getClassEntity() ) );

        return studentResponse.build();
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
