package com.sa.healntrack.patient_service.patient.application.port.out.persistence;

import com.sa.healntrack.patient_service.patient.domain.Patient;

public interface SavePatient {

    Patient save(Patient patient);

}
