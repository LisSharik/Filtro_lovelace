package com.riwi.filtro_lovelace.infrastructure.services.abstract_services;


import com.riwi.filtro_lovelace.api.dto.request.ClassBasicRequest;
import com.riwi.filtro_lovelace.api.dto.response.ClassResponse;
import com.riwi.filtro_lovelace.api.dto.response.basics_responses.ClassBasicResponse;
import com.riwi.filtro_lovelace.infrastructure.services.abstract_services.basic_abstract_services.IBasicCrudService;
import com.riwi.filtro_lovelace.infrastructure.services.abstract_services.basic_abstract_services.IDisableService;
import com.riwi.filtro_lovelace.infrastructure.services.abstract_services.basic_abstract_services.IGetAllByNameService;

public interface IClassService extends
        IBasicCrudService<ClassBasicRequest, ClassResponse, ClassBasicResponse, Long>,
        IDisableService<Long, ClassResponse>,
        IGetAllByNameService<ClassBasicResponse> {

        public String FIELD_BY_SORT = "name";
        
}
