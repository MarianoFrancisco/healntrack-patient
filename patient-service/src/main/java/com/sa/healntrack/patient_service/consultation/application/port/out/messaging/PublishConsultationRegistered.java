package com.sa.healntrack.patient_service.consultation.application.port.out.messaging;

import com.sa.healntrack.patient_service.consultation.domain.Consultation;

public interface PublishConsultationRegistered {
    
    void publishRegisteredMessage(Consultation consultation);

}
