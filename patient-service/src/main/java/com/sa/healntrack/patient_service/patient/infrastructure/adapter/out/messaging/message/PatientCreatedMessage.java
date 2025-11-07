package com.sa.healntrack.patient_service.patient.infrastructure.adapter.out.messaging.message;

import java.util.UUID;

public record PatientCreatedMessage(

        UUID id,
        String cui,
        String fullName

) { }
