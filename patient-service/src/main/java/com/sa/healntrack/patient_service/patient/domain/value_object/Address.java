package com.sa.healntrack.patient_service.patient.domain.value_object;

public record Address(String value) {
   
    private static final int MIN_LENGTH = 5;

    public Address {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("La direccion no puede ser nula");
        }
        if (value.trim().length() < MIN_LENGTH) {
            throw new IllegalArgumentException("La direccion debe superar los " + MIN_LENGTH + " caracteres");
        }
    }
    
}
