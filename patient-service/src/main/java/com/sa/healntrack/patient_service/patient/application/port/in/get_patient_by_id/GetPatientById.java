package com.sa.healntrack.patient_service.patient.application.port.in.get_patient_by_id;

import java.util.UUID;

import com.sa.healntrack.patient_service.patient.domain.Patient;

public interface GetPatientById {
    
    Patient get(UUID id);

}
