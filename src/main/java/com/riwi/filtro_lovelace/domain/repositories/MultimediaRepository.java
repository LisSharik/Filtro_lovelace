package com.riwi.filtro_lovelace.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.filtro_lovelace.domain.entities.Multimedia;

@Repository
public interface MultimediaRepository extends JpaRepository<Multimedia, Long> {
    
}
