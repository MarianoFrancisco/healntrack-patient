package com.sa.healntrack.patient_service.consultation.application.port.out.persistence;

import com.sa.healntrack.patient_service.consultation.domain.Consultation;

public interface SaveConsultation {
    
    Consultation save(Consultation consultation);

}
