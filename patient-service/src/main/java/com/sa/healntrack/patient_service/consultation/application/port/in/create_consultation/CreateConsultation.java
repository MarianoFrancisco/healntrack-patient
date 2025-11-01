package com.sa.healntrack.patient_service.consultation.application.port.in.create_consultation;

import com.sa.healntrack.patient_service.consultation.domain.Consultation;

public interface CreateConsultation {
    
    Consultation create(CreateConsultationCommand command);

}
