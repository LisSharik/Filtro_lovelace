package com.riwi.filtro_lovelace.domain.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.filtro_lovelace.domain.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Page<Student> findByActiveTrue(Pageable pageable);
    Page<Student> findByActiveTrueAndNameContainingIgnoreCase(String name, Pageable pageable);
}
