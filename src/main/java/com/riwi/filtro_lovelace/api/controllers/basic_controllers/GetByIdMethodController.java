package com.riwi.filtro_lovelace.api.controllers.basic_controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public interface GetByIdMethodController<RS> {
    @GetMapping("/{id}")
    public ResponseEntity<RS> getById(@PathVariable Long id);
    
}
