package com.riwi.filtro_lovelace.api.controllers.basic_controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.filtro_lovelace.util.enums.SortType;

@RestController
public interface GetAllByNameMethodController<RBS> {
    @GetMapping
    public ResponseEntity<Page<RBS>> getAllWithName(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestHeader(required = false) SortType sortType,
        @RequestParam(required = false) String name

    );
}
