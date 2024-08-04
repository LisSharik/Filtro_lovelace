package com.riwi.filtro_lovelace.domain.entities;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import com.riwi.filtro_lovelace.util.enums.MultimediaType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "multimedia")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Multimedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MultimediaType type;

    @Lob
    private String url;

    @CreationTimestamp
    private LocalDate createdAt;

    @Column(nullable = false)
    private Boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id", referencedColumnName = "id")
    private Lesson lesson;

}
