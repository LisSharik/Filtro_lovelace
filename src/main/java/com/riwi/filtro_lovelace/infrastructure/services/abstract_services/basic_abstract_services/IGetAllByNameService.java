package com.riwi.filtro_lovelace.infrastructure.services.abstract_services.basic_abstract_services;

import org.springframework.data.domain.Page;

import com.riwi.filtro_lovelace.util.enums.SortType;

public interface IGetAllByNameService<RS> {
    public Page<RS> getAllWithName(int page, int size, SortType sortType, String name);
}
