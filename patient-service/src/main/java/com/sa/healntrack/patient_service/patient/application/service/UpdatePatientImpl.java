package com.sa.healntrack.patient_service.patient.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sa.healntrack.patient_service.common.application.exception.EntityNotFoundException;
import com.sa.healntrack.patient_service.patient.application.mapper.PatientMapper;
import com.sa.healntrack.patient_service.patient.application.port.in.update_patient.UpdatePatient;
import com.sa.healntrack.patient_service.patient.application.port.in.update_patient.UpdatePatientCommand;
import com.sa.healntrack.patient_service.patient.application.port.out.messaging.PublishPatientUpdated;
import com.sa.healntrack.patient_service.patient.application.port.out.persistence.FindPatientById;
import com.sa.healntrack.patient_service.patient.application.port.out.persistence.SavePatient;
import com.sa.healntrack.patient_service.patient.domain.Patient;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class UpdatePatientImpl implements UpdatePatient {
    
    private final PatientMapper mapper;
    private final FindPatientById findPatientById;
    private final SavePatient savePatient;
    private final PublishPatientUpdated publishPatientUpdated;

    @Override
    public Patient update(UUID id, UpdatePatientCommand updatePatientCommand) {
        Patient patient = findPatientById.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No existe un paciente con el id: " + id));
        Patient updatedPatient = mapper.updateDomain(updatePatientCommand, patient);
        Patient patientSaved = savePatient.save(updatedPatient);
        publishPatientUpdated.publishUpdatedMessage(patientSaved);
        return patientSaved;
    }

}
