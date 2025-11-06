package com.sa.healntrack.patient_service.consultation.infrastructure.adapter.out.persistence.specificacion;

import java.time.LocalDate;
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
    
    public static Specification<ConsultationEntity> dateFrom(LocalDate dateFrom) {
        return (root, query, criteriaBuilder) -> (dateFrom == null)
                ? null
                : criteriaBuilder.greaterThanOrEqualTo(root.get("date"), dateFrom);
    }

    public static Specification<ConsultationEntity> dateTo(LocalDate dateTo) {
        return (root, query, criteriaBuilder) -> (dateTo == null)
                ? null
                : criteriaBuilder.lessThanOrEqualTo(root.get("date"), dateTo);
    }

}
