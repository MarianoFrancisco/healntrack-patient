package com.sa.healntrack.patient_service.patient.domain.value_object;

public enum PatientGender {
    MALE,
    FEMALE,
    OTHER;

    public static PatientGender fromString(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El genero no puede ser nulo");
        }
        try {
            return PatientGender.valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("El genero es invalido");
        }
    }

}
