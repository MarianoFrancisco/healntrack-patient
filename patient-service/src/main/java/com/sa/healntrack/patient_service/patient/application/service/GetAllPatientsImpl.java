package com.sa.healntrack.patient_service.patient.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sa.healntrack.patient_service.patient.application.port.in.get_all_patients.GetAllPatients;
import com.sa.healntrack.patient_service.patient.application.port.in.get_all_patients.GetAllPatientsQuery;
import com.sa.healntrack.patient_service.patient.application.port.out.persistence.FindAllPatients;
import com.sa.healntrack.patient_service.patient.domain.Patient;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GetAllPatientsImpl implements GetAllPatients {

    private final FindAllPatients findAllPatients;
    
    @Override
    public List<Patient> getAll(GetAllPatientsQuery query) {
        return findAllPatients.findAll(query);
    }

}
