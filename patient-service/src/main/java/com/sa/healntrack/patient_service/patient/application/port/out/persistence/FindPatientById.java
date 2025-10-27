package com.sa.healntrack.patient_service.patient.application.port.out.persistence;

import java.util.Optional;
import java.util.UUID;

import com.sa.healntrack.patient_service.patient.domain.Patient;

public interface FindPatientById {
    
    Optional<Patient> find(UUID id);

}
