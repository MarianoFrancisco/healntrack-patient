package com.sa.healntrack.patient_service.patient.application.port.in.get_all_patients;

import java.util.List;

import com.sa.healntrack.patient_service.patient.domain.Patient;

public interface GetAllPatients {

    List<Patient> getAll(GetAllPatientsQuery query);
    
}
