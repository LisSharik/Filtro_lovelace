package com.riwi.filtro_lovelace.api.controllers.basic_controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public interface PutMethodController<RS, RQ> {
    @PutMapping("/{id}")
    public ResponseEntity<RS> update(@PathVariable Long id, @Validated @RequestBody RQ request);
    
}
