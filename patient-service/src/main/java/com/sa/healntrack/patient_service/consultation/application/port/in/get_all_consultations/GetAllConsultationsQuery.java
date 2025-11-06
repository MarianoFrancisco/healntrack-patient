package com.sa.healntrack.patient_service.consultation.application.port.in.get_all_consultations;

import java.time.LocalDate;
import java.util.UUID;

public record GetAllConsultationsQuery(

        UUID patientId,
        UUID employeeId,
        LocalDate dateFrom,
        LocalDate dateTo

) {
    
}
