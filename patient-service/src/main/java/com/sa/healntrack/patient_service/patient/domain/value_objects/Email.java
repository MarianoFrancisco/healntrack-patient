package com.sa.healntrack.patient_service.patient.domain.value_objects;

import java.util.regex.Pattern;

public record Email(String value) {

    private static final Pattern EMAIL_PATTERN = Pattern
            .compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    public Email {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El email no puede estar nulo");
        }
        if (!EMAIL_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("El email debe tener un formato valido");
        }
        value = normalize(value);
    }

    private static String normalize(String value) {
        return value.toLowerCase();
    }

}
