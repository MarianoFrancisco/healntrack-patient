package com.sa.healntrack.patient_service.patient.application.port.in.update_patient;

import java.util.UUID;

import com.sa.healntrack.patient_service.patient.domain.Patient;

public interface UpdatePatient {

    Patient update(UUID id, UpdatePatientCommand updatePatientCommand);
    
}
