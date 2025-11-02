package com.sa.healntrack.patient_service.patient.infrastructure.adapter.out.persistence.specification;

import org.springframework.data.jpa.domain.Specification;

import com.sa.healntrack.patient_service.patient.domain.value_object.Gender;
import com.sa.healntrack.patient_service.patient.infrastructure.adapter.out.persistence.entity.PatientEntity;

public class PatientSpecs {

    public static Specification<PatientEntity> fullNameContains(String fullName) {
        return (root, query, criteriaBuilder) -> (fullName == null || fullName.isBlank())
                ? null
                : criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("fullName")),
                        "%" + fullName.toLowerCase() + "%");
    }

    public static Specification<PatientEntity> CUIContains(String cui) {
        return (root, query, criteriaBuilder) -> (cui == null || cui.isBlank())
                ? null
                : criteriaBuilder.like(
                        root.get("cui"),
                        "%" + cui + "%");
    }

    public static Specification<PatientEntity> hasGender(Gender gender) {
        return (root, query, criteriaBuilder) -> (gender == null)
                ? null
                : criteriaBuilder.equal(root.get("gender"), gender);
    }

}
