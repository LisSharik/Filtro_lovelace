package com.riwi.filtro_lovelace.infrastructure.services.abstract_services.basic_abstract_services;

public interface IGetByIdService<RS, ID> {
    public RS getById(ID id);
}
