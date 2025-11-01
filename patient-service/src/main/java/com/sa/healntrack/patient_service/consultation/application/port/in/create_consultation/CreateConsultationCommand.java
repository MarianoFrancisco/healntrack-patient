package com.sa.healntrack.patient_service.consultation.application.port.in.create_consultation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record CreateConsultationCommand(

        UUID patientId,
        UUID doctorId,
        LocalDate date,
        String reason,
        String diagnosis,
        String treatment,
        BigDecimal totalFee

) { }
