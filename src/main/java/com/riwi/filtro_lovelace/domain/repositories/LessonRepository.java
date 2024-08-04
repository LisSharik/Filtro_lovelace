package com.riwi.filtro_lovelace.domain.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.filtro_lovelace.domain.entities.Lesson;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    
    Page<Lesson> findByActiveTrue(Pageable pageable);
    Page<Lesson> findByActiveTrueAndTitleContainingIgnoreCase(String name, Pageable pageable);
}
