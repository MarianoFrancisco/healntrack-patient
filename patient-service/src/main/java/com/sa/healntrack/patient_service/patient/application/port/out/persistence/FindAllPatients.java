package com.sa.healntrack.patient_service.patient.application.port.out.persistence;

import java.util.List;

import com.sa.healntrack.patient_service.patient.application.port.in.get_all_patients.GetAllPatientsQuery;
import com.sa.healntrack.patient_service.patient.domain.Patient;

public interface FindAllPatients {
    
    List<Patient> findAll(GetAllPatientsQuery query);

}
