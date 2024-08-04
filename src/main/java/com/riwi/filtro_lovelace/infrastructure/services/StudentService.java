package com.riwi.filtro_lovelace.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.filtro_lovelace.api.dto.request.StudentBasicRequest;
import com.riwi.filtro_lovelace.api.dto.response.StudentResponse;
import com.riwi.filtro_lovelace.api.dto.response.basics_responses.StudentBasicResponse;
import com.riwi.filtro_lovelace.domain.entities.ClassEntity;
import com.riwi.filtro_lovelace.domain.entities.Student;
import com.riwi.filtro_lovelace.domain.repositories.ClassRepository;
import com.riwi.filtro_lovelace.domain.repositories.StudentRepository;
import com.riwi.filtro_lovelace.infrastructure.helpers.generic_methods.GenericFindByIdMethod;
import com.riwi.filtro_lovelace.infrastructure.helpers.mappers.StudentMapper;
import com.riwi.filtro_lovelace.infrastructure.services.abstract_services.IStudentService;
import com.riwi.filtro_lovelace.util.enums.SortType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService implements IStudentService {

    @Autowired
    private final StudentRepository studentRepository;

    @Autowired
    private final ClassRepository classRepository;

    @Autowired
    private final StudentMapper studentMapper;

    @Autowired
    private final GenericFindByIdMethod<Student, Long> genericFindByIdMethod;

    @Autowired
    private final GenericFindByIdMethod<ClassEntity, Long> genericFindByIdMethodClass;


    @Override
    public StudentResponse getById(Long id) {
        Student student = this.genericFindByIdMethod.find(studentRepository, id, "Student");
        return this.studentMapper.toStudentResponse(student);
    }

    @Override
    public StudentBasicResponse create(StudentBasicRequest rq) {
        Student student = studentMapper.toClassEntity(rq);

        ClassEntity classEntity = this.genericFindByIdMethodClass.find(classRepository, rq.getClassId(), "Class");

        student.setClassEntity(classEntity);

        return studentMapper.toStudentBasicResponse(this.studentRepository.save(student));
    }

    @Override
    public StudentResponse update(Long id, StudentBasicRequest rq) {
        Student student = this.genericFindByIdMethod.find(studentRepository, id, "Student");
        student = this.studentMapper.toUpdateEntity(rq, student);
        return this.studentMapper.toStudentResponse(this.studentRepository.save(student));
    }

    @Override
    public void delete(Long id) {
        Student student = this.genericFindByIdMethod.find(studentRepository, id, "Student");
        this.studentRepository.delete(student);
    }

    @Override
    public StudentResponse disable(Long id) {
        Student student = this.genericFindByIdMethod.find(studentRepository, id, "Student");
        student.setActive(!student.getActive());    
        return this.studentMapper.toStudentResponse(this.studentRepository.save(student));
    }

    @Override
    public Page<StudentBasicResponse> getAllWithName(int page, int size, SortType sortType, String name) {
        if(page < 0) page = 0;

        PageRequest pagination = null;

        switch (sortType) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }

        Page<Student> students;

        if(name == null || name.isEmpty()){
            students = this.studentRepository.findByActiveTrue(pagination);
        }else{
            students = this.studentRepository.findByActiveTrueAndNameContainingIgnoreCase(name, pagination);
        }

        

        return students.map(this.studentMapper::toStudentBasicResponse);
    }

}
