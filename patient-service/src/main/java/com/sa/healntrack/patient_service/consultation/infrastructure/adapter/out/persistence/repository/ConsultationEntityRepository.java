package com.sa.healntrack.patient_service.consultation.infrastructure.adapter.out.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sa.healntrack.patient_service.consultation.infrastructure.adapter.out.persistence.entity.ConsultationEntity;

public interface ConsultationEntityRepository extends JpaRepository<ConsultationEntity, UUID> {
    
}
