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
import com.riwi.filtro_lovelace.api.dto.request.LessonBasicRequest;
import com.riwi.filtro_lovelace.api.dto.response.LessonResponse;
import com.riwi.filtro_lovelace.api.dto.response.LessonToMultimediaResponse;
import com.riwi.filtro_lovelace.api.dto.response.basics_responses.LessonBasicResponse;
import com.riwi.filtro_lovelace.infrastructure.services.abstract_services.ILessonService;
import com.riwi.filtro_lovelace.util.enums.SortType;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@AllArgsConstructor
@RequestMapping("/lessons")
public class LessonController implements
        BasicCrudMethodController<LessonResponse, LessonResponse, LessonBasicRequest, Long>,
        DisableMethodController<LessonResponse>,
        GetAllByNameMethodController<LessonBasicResponse> {

    @Autowired
    private final ILessonService lessonService;

    @Override
    public ResponseEntity<LessonResponse> getById(Long id) {
        return ResponseEntity.ok(this.lessonService.getById(id));
    }

    @Override
    public ResponseEntity<LessonResponse> insert(LessonBasicRequest request) {
        return ResponseEntity.ok(this.lessonService.create(request));
    }

    @Override
    public ResponseEntity<LessonResponse> update(Long id, LessonBasicRequest request) {
        return ResponseEntity.ok(this.lessonService.update(id, request));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        this.lessonService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Page<LessonBasicResponse>> getAllWithName(int page, int size, SortType sortType, String name) {
        if (Objects.isNull(sortType))
            sortType = SortType.NONE;

        return ResponseEntity.ok(this.lessonService.getAllWithName(page - 1, size, sortType, name));

    }

    @Override
    public ResponseEntity<LessonResponse> disable(Long id) {
        return ResponseEntity.ok(this.lessonService.disable(id));
    }

    @GetMapping("/{id}/multimedia")
    public ResponseEntity<LessonToMultimediaResponse> getByIdMultimedia(@PathVariable Long id) {
        return ResponseEntity.ok(this.lessonService.getByIdMultimedia(id));
    }
    

}
