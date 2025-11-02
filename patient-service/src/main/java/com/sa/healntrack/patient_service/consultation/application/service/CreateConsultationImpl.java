package com.sa.healntrack.patient_service.consultation.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sa.healntrack.patient_service.common.application.exception.EntityNotFoundException;
import com.sa.healntrack.patient_service.consultation.application.mapper.ConsultationMapper;
import com.sa.healntrack.patient_service.consultation.application.port.in.create_consultation.CreateConsultation;
import com.sa.healntrack.patient_service.consultation.application.port.in.create_consultation.CreateConsultationCommand;
import com.sa.healntrack.patient_service.consultation.application.port.out.persistence.SaveConsultation;
import com.sa.healntrack.patient_service.consultation.domain.Consultation;
import com.sa.healntrack.patient_service.patient.application.port.out.persistence.FindPatientById;
import com.sa.healntrack.patient_service.patient.domain.Patient;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class CreateConsultationImpl implements CreateConsultation {

    private final FindPatientById findPatientById;
    private final ConsultationMapper mapper;
    private final SaveConsultation saveConsultation;
    
    @Override
    public Consultation create(CreateConsultationCommand command) {
        Patient patient = findPatientById.findById(command.patientId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "No existe un paciente con el id: " + command.patientId()));
        // TODO: Doctor Validation
        Consultation newConsultation = mapper.toDomain(command, patient);
        Consultation consultation = saveConsultation.save(newConsultation);
        return consultation;
    }

}
