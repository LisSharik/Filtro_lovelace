package com.riwi.filtro_lovelace.api.controllers.basic_controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface DisableMethodController<RS> {
    @PatchMapping("/{id}/disable")
    public ResponseEntity<RS> disable(@PathVariable Long id);
}
