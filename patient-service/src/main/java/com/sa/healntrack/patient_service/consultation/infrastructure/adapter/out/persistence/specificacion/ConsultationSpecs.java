package com.sa.healntrack.patient_service.consultation.infrastructure.adapter.out.persistence.specificacion;

import java.util.UUID;

import org.springframework.data.jpa.domain.Specification;

import com.sa.healntrack.patient_service.consultation.infrastructure.adapter.out.persistence.entity.ConsultationEntity;

public class ConsultationSpecs {
    
    public static Specification<ConsultationEntity> hasPatientId(UUID patientId) {
        return (root, query, criteriaBuilder) -> (patientId == null)
                ? null
                : criteriaBuilder.equal(root.get("patientId"), patientId);
    }

    public static Specification<ConsultationEntity> hasEmployeeId(UUID employeeId) {
        return (root, query, criteriaBuilder) -> (employeeId == null)
                ? null
                : criteriaBuilder.equal(root.get("employeeId"), employeeId);
    }

}
