package com.riwi.filtro_lovelace.infrastructure.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.filtro_lovelace.api.dto.request.ClassBasicRequest;
import com.riwi.filtro_lovelace.api.dto.response.ClassResponse;
import com.riwi.filtro_lovelace.api.dto.response.basics_responses.ClassBasicResponse;
import com.riwi.filtro_lovelace.domain.entities.ClassEntity;
import com.riwi.filtro_lovelace.domain.repositories.ClassRepository;
import com.riwi.filtro_lovelace.infrastructure.helpers.generic_methods.GenericFindByIdMethod;
import com.riwi.filtro_lovelace.infrastructure.helpers.mappers.ClassMapper;
import com.riwi.filtro_lovelace.infrastructure.services.abstract_services.IClassService;
import com.riwi.filtro_lovelace.util.enums.SortType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClassService implements IClassService {

    @Autowired
    private final ClassRepository classRepository;

    @Autowired
    private final ClassMapper classMapper;

    @Autowired
    private final GenericFindByIdMethod<ClassEntity, Long> genericFindByIdMethod;

    @Override
    public Page<ClassBasicResponse> getAllWithName(int page, int size, SortType sortType, String name) {
        if (page < 0)
            page = 0;

        PageRequest pagination = null;

        switch (sortType) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }

        Page<ClassEntity> classEntities;

        if(name == null || name.isEmpty()){
            classEntities = this.classRepository.findByActiveTrue(pagination);
        }else{
            classEntities = this.classRepository.findByActiveTrueAndNameContainingIgnoreCase(name, pagination);
        }


        return classEntities.map(this.classMapper::toClassBasicResponse);

    }

    @Override
    public ClassResponse getById(Long id) {
        ClassEntity classEntity = this.genericFindByIdMethod.find(classRepository, id, "Class");
        return this.classMapper.toClassResponse(classEntity);
    }

    @Override
    public ClassBasicResponse create(ClassBasicRequest rq) {
        ClassEntity classEntity = classMapper.toClassEntity(rq);
        classEntity.setLessons(new ArrayList<>());
        classEntity.setStudents(new ArrayList<>());

        return classMapper.toClassBasicResponse(this.classRepository.save(classEntity));

    }

    @Override
    public ClassResponse update(Long id, ClassBasicRequest rq) {
        ClassEntity classEntity = this.genericFindByIdMethod.find(classRepository, id, "Class");
        classEntity = this.classMapper.toUpdateEntity(rq, classEntity);
        return this.classMapper.toClassResponse(this.classRepository.save(classEntity));

    }

    @Override
    public void delete(Long id) {
        ClassEntity classEntity = this.genericFindByIdMethod.find(classRepository, id, "Class");
        this.classRepository.delete(classEntity);

    }

    @Override
    public ClassResponse disable(Long id) {
        ClassEntity classEntity = this.genericFindByIdMethod.find(classRepository, id, "Class");
        classEntity.setActive(!classEntity.getActive());

        return this.classMapper.toClassResponse(this.classRepository.save(classEntity));

    }

}
