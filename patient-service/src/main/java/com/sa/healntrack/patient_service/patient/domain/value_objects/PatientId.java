package com.sa.healntrack.patient_service.patient.domain.value_objects;

import java.util.Objects;
import java.util.UUID;

public record PatientId(UUID value) {

    public PatientId {
        Objects.requireNonNull(value, "El id del paciente no puede ser nulo");
    }

}
