package com.riwi.filtro_lovelace.infrastructure.services.abstract_services;

import com.riwi.filtro_lovelace.infrastructure.services.abstract_services.basic_abstract_services.IBasicCrudService;
import com.riwi.filtro_lovelace.infrastructure.services.abstract_services.basic_abstract_services.IDisableService;
import com.riwi.filtro_lovelace.infrastructure.services.abstract_services.basic_abstract_services.IGetAllByNameService;
import com.riwi.filtro_lovelace.api.dto.request.StudentBasicRequest;
import com.riwi.filtro_lovelace.api.dto.response.StudentResponse;
import com.riwi.filtro_lovelace.api.dto.response.basics_responses.StudentBasicResponse;

public interface IStudentService extends
        IBasicCrudService<StudentBasicRequest, StudentResponse, StudentBasicResponse, Long>,
        IDisableService<Long, StudentResponse>,
        IGetAllByNameService<StudentBasicResponse> {
            
    public String FIELD_BY_SORT = "name";
}
