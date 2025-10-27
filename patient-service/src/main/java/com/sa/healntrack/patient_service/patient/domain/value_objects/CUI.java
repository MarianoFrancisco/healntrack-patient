package com.sa.healntrack.patient_service.patient.domain.value_objects;

import java.util.regex.Pattern;

public record CUI(String value) {

    private static final Pattern CUI_PATTERN = Pattern.compile("^\\d{13}$");

    public CUI {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El CUI no puede ser nulo");
        }
        if (!CUI_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("El CUI debe ser de exactamente 13 digitos");
        }
    }

}
