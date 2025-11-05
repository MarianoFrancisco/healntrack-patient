package com.sa.healntrack.patient_service.consultation.infrastructure.adapter.in.rest.dto;

import java.util.UUID;

public record SearchConsultationsRequestDTO(

        UUID patientId,
        UUID employeeId

) { }
