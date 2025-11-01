package com.sa.healntrack.patient_service.patient.domain.value_object;

import java.util.regex.Pattern;

public record PhoneNumber(String value) {

    private static final int PHONE_NUMBER_LENGTH = 8;
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("^\\d{" + PHONE_NUMBER_LENGTH +"}$");

    public PhoneNumber {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El numero de telefono no puede ser nulo");
        }
        if (!PHONE_NUMBER_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("El numero de telefono debe ser de " + PHONE_NUMBER_LENGTH + " digitos");
        }
    }

}
