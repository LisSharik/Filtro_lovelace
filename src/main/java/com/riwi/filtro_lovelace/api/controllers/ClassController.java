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
import com.riwi.filtro_lovelace.api.dto.request.ClassBasicRequest;
import com.riwi.filtro_lovelace.api.dto.response.ClassResponse;
import com.riwi.filtro_lovelace.api.dto.response.basics_responses.ClassBasicResponse;
import com.riwi.filtro_lovelace.infrastructure.services.abstract_services.IClassService;
import com.riwi.filtro_lovelace.util.enums.SortType;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/classes")
public class ClassController implements
        DisableMethodController<ClassResponse>,
        BasicCrudMethodController<ClassResponse, ClassBasicResponse, ClassBasicRequest, Long>,
        GetAllByNameMethodController<ClassBasicResponse> {

    @Autowired
    private final IClassService classService;

    @Override
    public ResponseEntity<Page<ClassBasicResponse>> getAllWithName(int page, int size, SortType sortType, String name) {
        if (Objects.isNull(sortType))
            sortType = SortType.NONE;
        return ResponseEntity.ok(this.classService.getAllWithName(page - 1, size, sortType, name));
    }

    @Override
    public ResponseEntity<ClassResponse> getById(Long id) {
        return ResponseEntity.ok(this.classService.getById(id));
    }

    @Override
    public ResponseEntity<ClassBasicResponse> insert(ClassBasicRequest request) {
        return ResponseEntity.ok(this.classService.create(request));
    }

    @Override
    public ResponseEntity<ClassResponse> update(Long id, ClassBasicRequest request) {
        return ResponseEntity.ok(this.classService.update(id, request));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        this.classService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<ClassResponse> disable(Long id) {
        return ResponseEntity.ok(this.classService.disable(id));
    }

}
