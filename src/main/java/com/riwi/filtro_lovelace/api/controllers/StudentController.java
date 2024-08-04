package com.riwi.filtro_lovelace.api.controllers;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.filtro_lovelace.api.controllers.basic_controllers.BasicCrudMethodController;
import com.riwi.filtro_lovelace.api.controllers.basic_controllers.DisableMethodController;
import com.riwi.filtro_lovelace.api.controllers.basic_controllers.GetAllByNameMethodController;
import com.riwi.filtro_lovelace.api.dto.request.StudentBasicRequest;
import com.riwi.filtro_lovelace.api.dto.response.StudentResponse;
import com.riwi.filtro_lovelace.api.dto.response.basics_responses.StudentBasicResponse;
import com.riwi.filtro_lovelace.infrastructure.services.StudentService;
import com.riwi.filtro_lovelace.util.enums.SortType;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController implements
        BasicCrudMethodController<StudentResponse, StudentBasicResponse, StudentBasicRequest, Long>,
        DisableMethodController<StudentResponse>,
        GetAllByNameMethodController<StudentBasicResponse> {

    @Autowired
    private final StudentService studentService;

    @Override
    public ResponseEntity<StudentResponse> getById(Long id) {
        return ResponseEntity.ok(this.studentService.getById(id));
    }

    @Override
    public ResponseEntity<StudentBasicResponse> insert(StudentBasicRequest request) {
        return ResponseEntity.ok(this.studentService.create(request));
    }

    @Override
    public ResponseEntity<StudentResponse> update(Long id, StudentBasicRequest request) {
        return ResponseEntity.ok(this.studentService.update(id, request));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        this.studentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Page<StudentBasicResponse>> getAllWithName(int page, int size, SortType sortType,
            String name) {
        if(Objects.isNull(sortType)) sortType = SortType.NONE;

        return ResponseEntity.ok(this.studentService.getAllWithName(page - 1, size, sortType, name));
    }

    @Override
    public ResponseEntity<StudentResponse> disable(Long id) {
        return ResponseEntity.ok(this.studentService.disable(id));
    }

}
