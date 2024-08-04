package com.riwi.filtro_lovelace.domain.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.filtro_lovelace.domain.entities.ClassEntity;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
    Page<ClassEntity> findByActiveTrue(Pageable pageable);
    Page<ClassEntity> findByActiveTrueAndNameContainingIgnoreCase(String name, Pageable pageable);
}
