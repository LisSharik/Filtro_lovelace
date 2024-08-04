package com.riwi.filtro_lovelace.infrastructure.services.abstract_services.basic_abstract_services;

public interface ICreateService<RQ, RS> {
    public RS create(RQ rq);
}
