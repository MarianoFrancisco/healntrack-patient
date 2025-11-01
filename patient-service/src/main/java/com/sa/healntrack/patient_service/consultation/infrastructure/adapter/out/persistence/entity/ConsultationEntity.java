package com.sa.healntrack.patient_service.consultation.infrastructure.adapter.out.persistence.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.sa.healntrack.patient_service.patient.infrastructure.adapter.out.persistence.entity.PatientEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Data
@Table(name = "consultation")
@Entity
public class ConsultationEntity {
    
    @Id
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;
    private UUID doctorId;
    private LocalDate date;
    private String reason;
    private String diagnosis;
    private String treatment;
    private BigDecimal totalFee;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
