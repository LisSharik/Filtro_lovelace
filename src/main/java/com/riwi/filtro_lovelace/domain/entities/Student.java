package com.riwi.filtro_lovelace.domain.entities;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 255, nullable = false)
  private String name;
  
  @Column(length = 255, nullable = false)
  private String email;

  @CreationTimestamp
  private LocalDate createdAt;

  @Column(nullable = false)
  private Boolean active;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "class_id", referencedColumnName = "id")
  private ClassEntity classEntity;

}
