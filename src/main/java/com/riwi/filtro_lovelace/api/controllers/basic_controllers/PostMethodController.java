package com.riwi.filtro_lovelace.api.controllers.basic_controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface PostMethodController<RS, RQ> {
    @PostMapping
    public ResponseEntity<RS> insert(@Validated @RequestBody RQ request);
}
