package com.sa.healntrack.patient_service.patient.infrastructure.adapter.out.persistence.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Data
@Table(name = "patient")
@Entity
public class PatientEntity {

    @Id
    private UUID id;
    private String cui;
    private String fullName;
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private PatientEntityGender gender;
    private String address;
    private String email;
    private String phoneNumber;
    private String emergencyPhoneNumber;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
