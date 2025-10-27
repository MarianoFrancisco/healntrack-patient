package com.sa.healntrack.patient_service.patient.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sa.healntrack.patient_service.common.application.exception.EntityNotFoundException;
import com.sa.healntrack.patient_service.patient.application.port.in.get_patient_by_id.GetPatientById;
import com.sa.healntrack.patient_service.patient.application.port.out.persistence.FindPatientById;
import com.sa.healntrack.patient_service.patient.domain.Patient;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GetPatientByIdImpl implements GetPatientById {
    
    private final FindPatientById findPatientById;

    @Override
    public Patient get(UUID id) {
        Patient patient = findPatientById.find(id)
                .orElseThrow(() -> new EntityNotFoundException("No existe un paciente con el id: " + id));
        return patient;
    }

}
