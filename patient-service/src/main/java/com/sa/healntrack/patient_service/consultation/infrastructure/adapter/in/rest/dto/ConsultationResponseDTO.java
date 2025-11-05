package com.sa.healntrack.patient_service.consultation.infrastructure.adapter.in.rest.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record ConsultationResponseDTO(

        UUID id,
        UUID patientId,
        UUID employeeId,
        LocalDate date,
        String reason,
        String diagnosis,
        String treatment,
        BigDecimal totalFee

) { }
