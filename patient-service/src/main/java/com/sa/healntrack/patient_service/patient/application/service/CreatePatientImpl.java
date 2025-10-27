package com.sa.healntrack.patient_service.patient.application.service;


import org.springframework.stereotype.Service;

import com.sa.healntrack.patient_service.common.application.exception.EntityAlreadyExistsException;
import com.sa.healntrack.patient_service.patient.application.mapper.PatientMapper;
import com.sa.healntrack.patient_service.patient.application.port.in.create_patient.CreatePatient;
import com.sa.healntrack.patient_service.patient.application.port.in.create_patient.CreatePatientCommand;
import com.sa.healntrack.patient_service.patient.application.port.out.persistence.ExistsPatientByCui;
import com.sa.healntrack.patient_service.patient.application.port.out.persistence.SavePatient;
import com.sa.healntrack.patient_service.patient.domain.Patient;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class CreatePatientImpl implements CreatePatient {

    private final PatientMapper mapper;
    private final ExistsPatientByCui existsPatientByCui;
    private final SavePatient savePatient;

    @Override
    public Patient create(CreatePatientCommand command) {
        Patient patient = mapper.toDomain(command);
        String cui = patient.getCui().value();
        if (existsPatientByCui.exists(cui)) {
            throw new EntityAlreadyExistsException(
                    "Ya existe un paciente registrado con el CUI: " + cui);
        }
        return savePatient.save(patient);
    }

}
