package com.sa.healntrack.patient_service.patient.infrastructure.adapter.out.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sa.healntrack.patient_service.patient.infrastructure.adapter.out.persistence.entity.PatientEntity;

public interface PatientEntityRepository extends JpaRepository<PatientEntity, UUID>, JpaSpecificationExecutor<PatientEntity> {

    boolean existsByCui(String cui);

}
