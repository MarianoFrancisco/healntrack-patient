package com.sa.healntrack.patient_service.patient.domain.value_objects;

import java.util.regex.Pattern;

public record FullName(String value) {

    private static final Pattern FULL_NAME_PATTERN = Pattern.compile("^[\\p{L} ']+$");

    public FullName {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        }
        if (value.length() < 2 || value.length() > 100) {
            throw new IllegalArgumentException("El nombre debe tener entre 2 y 100 caracteres");
        }
        if (!FULL_NAME_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("El nombre no tiene un formato valido");
        }
        value = normalize(value);
    }

    private static String normalize(String value) {
        return value.trim().replaceAll("//s+", "");
    }

}
