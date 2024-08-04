package com.riwi.filtro_lovelace.infrastructure.services.abstract_services.basic_abstract_services;

public interface IDisableService<ID, RS> {
    public RS disable(ID id);
}
