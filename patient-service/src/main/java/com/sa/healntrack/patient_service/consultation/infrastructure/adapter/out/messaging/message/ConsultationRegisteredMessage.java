package com.sa.healntrack.patient_service.consultation.infrastructure.adapter.out.messaging.message;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record ConsultationRegisteredMessage(

        UUID patientId,
        BigDecimal totalFee,
        LocalDate date

) { }
