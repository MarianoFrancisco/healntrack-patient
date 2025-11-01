package com.sa.healntrack.patient_service.consultation.domain.value_object;

import java.util.UUID;

public record DoctorId(UUID value) {
    
    public DoctorId {
        if (value == null) {
            throw new IllegalArgumentException("El id del doctor no puede ser nulo");
        }
    }

}
