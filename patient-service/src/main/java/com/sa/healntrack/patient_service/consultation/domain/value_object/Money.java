package com.sa.healntrack.patient_service.consultation.domain.value_object;

import java.math.BigDecimal;

public record Money(BigDecimal value) {

    private static final BigDecimal MIN = new BigDecimal(0.00);
    
    public Money {
        if (value == null) {
            throw new IllegalArgumentException("El costo no puede ser nulo");
        }
        if (value.compareTo(MIN) < 0) {
            throw new IllegalArgumentException("El costo debe ser mayor a " + MIN);
        }
    }

}
