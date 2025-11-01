package com.sa.healntrack.patient_service.consultation.domain.value_object;

import java.util.UUID;

public record ConsultationId(UUID value) {
    
    public ConsultationId {
        if (value == null) {
            throw new IllegalArgumentException("El id de la consulta no puede ser nulo");
        }
    }

}
