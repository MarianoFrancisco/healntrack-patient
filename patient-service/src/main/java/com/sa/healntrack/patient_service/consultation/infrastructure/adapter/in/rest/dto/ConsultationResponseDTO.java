package com.sa.healntrack.patient_service.consultation.infrastructure.adapter.in.rest.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import com.sa.healntrack.patient_service.patient.infrastructure.adapter.in.rest.dto.PatientResponseDTO;

public record ConsultationResponseDTO(

        UUID id,
        PatientResponseDTO patient,
        UUID doctorId,
        LocalDate date,
        String reason,
        String diagnosis,
        String treatment,
        BigDecimal totalFee

) { }
