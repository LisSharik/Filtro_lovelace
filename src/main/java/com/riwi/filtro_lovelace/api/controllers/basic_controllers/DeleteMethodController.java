package com.riwi.filtro_lovelace.api.controllers.basic_controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface DeleteMethodController{
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id);
}
