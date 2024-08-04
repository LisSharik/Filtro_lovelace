package com.riwi.filtro_lovelace.infrastructure.seeds;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.riwi.filtro_lovelace.domain.entities.ClassEntity;
import com.riwi.filtro_lovelace.domain.repositories.ClassRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class DatabaseSeed implements CommandLineRunner {

    @Autowired
    private final ClassRepository classRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info(" ========= Seeding database Cohort executed ========= ");

        if (classRepository.count() > 0)
            return;

        ClassEntity classEntity = new ClassEntity();
        classEntity.setName("Java");
        classEntity.setDescription("Java is a general-purpose programming language");
        classEntity.setActive(true);
        

        classRepository.save(classEntity);

    }

}
