package com.sa.healntrack.patient_service.patient.application.port.in.create_patient;

import com.sa.healntrack.patient_service.patient.domain.Patient;

public interface CreatePatient {

    Patient create(CreatePatientCommand command);

}
