package com.riwi.filtro_lovelace.infrastructure.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.filtro_lovelace.api.dto.request.LessonBasicRequest;
import com.riwi.filtro_lovelace.api.dto.response.LessonResponse;
import com.riwi.filtro_lovelace.api.dto.response.LessonToMultimediaResponse;
import com.riwi.filtro_lovelace.api.dto.response.basics_responses.LessonBasicResponse;
import com.riwi.filtro_lovelace.api.dto.response.basics_responses.MultimediaBasicResponse;
import com.riwi.filtro_lovelace.domain.entities.ClassEntity;
import com.riwi.filtro_lovelace.domain.entities.Lesson;
import com.riwi.filtro_lovelace.domain.entities.Multimedia;
import com.riwi.filtro_lovelace.domain.repositories.ClassRepository;
import com.riwi.filtro_lovelace.domain.repositories.LessonRepository;
import com.riwi.filtro_lovelace.domain.repositories.MultimediaRepository;
import com.riwi.filtro_lovelace.infrastructure.helpers.generic_methods.GenericFindByIdMethod;
import com.riwi.filtro_lovelace.infrastructure.helpers.mappers.LessonMapper;
import com.riwi.filtro_lovelace.infrastructure.helpers.mappers.MultimediaMapper;
import com.riwi.filtro_lovelace.infrastructure.services.abstract_services.ILessonService;
import com.riwi.filtro_lovelace.util.enums.SortType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LessonService implements ILessonService {

    @Autowired
    private final LessonRepository lessonRepository;

    @Autowired
    private final MultimediaRepository multimediaRepository;

    @Autowired
    private final ClassRepository classRepository;

    @Autowired
    private final LessonMapper lessonMapper;

    @Autowired
    private final MultimediaMapper multimediaMapper;

    @Autowired
    private final GenericFindByIdMethod<Lesson, Long> genericFindByIdMethod;


    @Autowired
    private final GenericFindByIdMethod<ClassEntity, Long> genericFindByIdClassMethod;

    @Override
    public LessonResponse getById(Long id) {
        Lesson lesson = this.genericFindByIdMethod.find(lessonRepository, id, "Lesson");

        List<MultimediaBasicResponse> multimediaContent = new ArrayList<>();

        lesson.getMultimediaContent().forEach(multimedia -> {
            multimediaContent.add(this.multimediaMapper.toMultimediaBasicResponse(multimedia));
        });

        LessonResponse lessonResponse = this.lessonMapper.toLessonResponse(lesson);

        lessonResponse.setMultimediaContent(multimediaContent);

        return lessonResponse;
    }

    @Override
    public LessonResponse create(LessonBasicRequest rq) {
        Lesson lesson = this.lessonMapper.toClassEntity(rq);

        ClassEntity classEntity = this.genericFindByIdClassMethod.find(classRepository, rq.getClassId(), "Class");

        lesson.setClassEntity(classEntity);

        this.lessonMapper.toLessonResponse(this.lessonRepository.save(lesson));

        List<MultimediaBasicResponse> multimediaContentReponse = new ArrayList<>();

        rq.getMultimediaContent().forEach(multimediaRequest -> {
            Multimedia multimedia = this.multimediaMapper.toClassEntity(multimediaRequest);
            multimedia.setLesson(lesson);
            multimediaContentReponse
                    .add(this.multimediaMapper.toMultimediaBasicResponse(this.multimediaRepository.save(multimedia)));
        });

        

        LessonResponse lessonResponse = this.lessonMapper.toLessonResponse(lesson);
        lessonResponse.setMultimediaContent(multimediaContentReponse);

        return lessonResponse;

    }

    @Override
    public LessonResponse update(Long id, LessonBasicRequest rq) {
        Lesson lesson = this.genericFindByIdMethod.find(lessonRepository, id, "Lesson");

        List<MultimediaBasicResponse> multimediaContentReponse = new ArrayList<>();

        rq.getMultimediaContent().forEach(multimediaRequest -> {
            Multimedia multimedia = this.multimediaMapper.toClassEntity(multimediaRequest);
            multimedia.setLesson(lesson);
            multimediaContentReponse
                    .add(this.multimediaMapper.toMultimediaBasicResponse(this.multimediaRepository.save(multimedia)));
        });

        LessonResponse lessonResponse = this.lessonMapper.toLessonResponse(lesson);
        lessonResponse.setMultimediaContent(multimediaContentReponse);

        this.lessonRepository.save(lesson);

        return lessonResponse;
    }

    @Override
    public void delete(Long id) {
        Lesson lesson = this.genericFindByIdMethod.find(lessonRepository, id, "Lesson");

        lesson.getMultimediaContent().forEach(multimedia -> {
            this.multimediaRepository.delete(multimedia);
        });

        this.lessonRepository.delete(lesson);
    }

    @Override
    public LessonResponse disable(Long id) {
        Lesson lesson = this.genericFindByIdMethod.find(lessonRepository, id, "Lesson");
        lesson.setActive(!lesson.getActive());

        List<MultimediaBasicResponse> multimediaContent = new ArrayList<>();

        lesson.getMultimediaContent().forEach(multimedia -> {
            multimedia.setActive(!multimedia.getActive());
            multimediaContent.add(this.multimediaMapper.toMultimediaBasicResponse(multimedia));
        });

        LessonResponse lessonResponse = this.lessonMapper.toLessonResponse(lesson);

        return lessonResponse;
    }

    @Override
    public Page<LessonBasicResponse> getAllWithName(int page, int size, SortType sortType, String name) {
        if(page < 0) page = 0;

        PageRequest pagination = null;

        switch (sortType) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }

        Page<Lesson> lessons;

        if  (name == null || name.isEmpty()) {
            lessons = this.lessonRepository.findByActiveTrue(pagination);
        } else {
            lessons = this.lessonRepository.findByActiveTrueAndTitleContainingIgnoreCase(name, pagination);
        }

        return lessons.map(this.lessonMapper::toLessonBasicResponse);
    }

    @Override
    public LessonToMultimediaResponse getByIdMultimedia(Long id) {
        Lesson lesson = this.genericFindByIdMethod.find(lessonRepository, id, "Lesson");

        List<MultimediaBasicResponse> multimediaContent = new ArrayList<>();

        lesson.getMultimediaContent().forEach(multimedia -> {
            multimediaContent.add(this.multimediaMapper.toMultimediaBasicResponse(multimedia));
        });

        LessonToMultimediaResponse lessonToMultimediaResponse = this.lessonMapper.toLessonToMultimediaResponse(lesson);

        lessonToMultimediaResponse.setMultimediaContent(multimediaContent);

        return lessonToMultimediaResponse;
    }

}
