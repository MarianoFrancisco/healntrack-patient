package com.sa.healntrack.patient_service.consultation.domain.value_object;

public record Diagnosis(String value) {
    
    private static final int MIN_LENGTH = 5;

    public Diagnosis {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        }
        if (value.length() < MIN_LENGTH ) {
            throw new IllegalArgumentException(
                    "El diagnostico debe superar los " + MIN_LENGTH + " caracteres");
        }
    }

}
