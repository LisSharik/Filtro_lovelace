package com.riwi.filtro_lovelace.infrastructure.helpers.generic_methods;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.riwi.filtro_lovelace.util.excepcions.IdNotFoundException;

@Service
public class GenericFindByIdMethod<T,ID> {
    
    public T find(JpaRepository<T,ID> repository, ID id, String entityName) {
        return repository.findById(id).orElseThrow(() -> new IdNotFoundException(entityName));
    }



}
