package com.sa.healntrack.patient_service.consultation.domain.value_object;

public record Treatment(String value) {
    
    private static final int MIN_LENGTH = 5;

    public Treatment {
        if (value != null && value.trim().length() < MIN_LENGTH) {
            throw new IllegalArgumentException("El tratamiento debe superar los " + MIN_LENGTH + " caracteres");
        }
    }

}
