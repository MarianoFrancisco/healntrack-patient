package com.sa.healntrack.patient_service.patient.domain.value_objects;

import java.util.regex.Pattern;

public record PhoneNumber(String value) {

    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("^\\d{8}$");

    public PhoneNumber {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El numero de telefono no puede ser nulo");
        }
        if (!PHONE_NUMBER_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("El numero de telefono debe ser de 8 digitos");
        }
    }

}
