package com.riwi.filtro_lovelace.infrastructure.services.abstract_services;

import com.riwi.filtro_lovelace.api.dto.request.LessonBasicRequest;
import com.riwi.filtro_lovelace.api.dto.response.LessonResponse;
import com.riwi.filtro_lovelace.api.dto.response.LessonToMultimediaResponse;
import com.riwi.filtro_lovelace.api.dto.response.basics_responses.LessonBasicResponse;
import com.riwi.filtro_lovelace.infrastructure.services.abstract_services.basic_abstract_services.IBasicCrudService;
import com.riwi.filtro_lovelace.infrastructure.services.abstract_services.basic_abstract_services.IDisableService;
import com.riwi.filtro_lovelace.infrastructure.services.abstract_services.basic_abstract_services.IGetAllByNameService;

public interface ILessonService extends
        IBasicCrudService<LessonBasicRequest, LessonResponse, LessonResponse, Long>,
        IDisableService<Long, LessonResponse>,
        IGetAllByNameService<LessonBasicResponse> {
    
        public String FIELD_BY_SORT = "title";

        public LessonToMultimediaResponse getByIdMultimedia(Long id);
            
}
