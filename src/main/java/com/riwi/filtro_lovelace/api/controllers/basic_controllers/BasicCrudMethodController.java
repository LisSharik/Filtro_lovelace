package com.riwi.filtro_lovelace.api.controllers.basic_controllers;

import org.springframework.web.bind.annotation.RestController;

@RestController
public interface BasicCrudMethodController<RS, RBS, RQ, ID> extends
        GetByIdMethodController<RS>,
        PostMethodController<RBS, RQ>,
        PutMethodController<RS, RQ>,
        DeleteMethodController {

}
