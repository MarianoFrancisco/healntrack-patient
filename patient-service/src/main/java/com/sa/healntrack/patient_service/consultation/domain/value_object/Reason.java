package com.sa.healntrack.patient_service.consultation.domain.value_object;

public record Reason(String value) {
    
    private static final int MIN_LENGTH = 5;

    public Reason {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("La razón no puede ser nulo");
        }
        if (value.length() < MIN_LENGTH ) {
            throw new IllegalArgumentException(
                    "La razón debe superar los " + MIN_LENGTH + " caracteres");
        }
    }

}
