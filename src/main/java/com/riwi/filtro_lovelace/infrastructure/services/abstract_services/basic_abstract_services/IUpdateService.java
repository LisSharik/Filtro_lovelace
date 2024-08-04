package com.riwi.filtro_lovelace.infrastructure.services.abstract_services.basic_abstract_services;

public interface IUpdateService<RQ, RS, ID> {
    public RS update(ID id, RQ rq);
}
