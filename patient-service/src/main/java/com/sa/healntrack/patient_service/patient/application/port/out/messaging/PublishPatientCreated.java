package com.sa.healntrack.patient_service.patient.application.port.out.messaging;

import com.sa.healntrack.patient_service.patient.domain.Patient;

public interface PublishPatientCreated {
    
    void publishCreatedMessage(Patient patient);

}
