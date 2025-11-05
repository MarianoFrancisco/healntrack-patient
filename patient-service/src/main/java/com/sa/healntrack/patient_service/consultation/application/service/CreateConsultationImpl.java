package com.sa.healntrack.patient_service.consultation.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sa.healntrack.patient_service.common.application.exception.EntityNotFoundException;
import com.sa.healntrack.patient_service.consultation.application.mapper.ConsultationMapper;
import com.sa.healntrack.patient_service.consultation.application.port.in.create_consultation.CreateConsultation;
import com.sa.healntrack.patient_service.consultation.application.port.in.create_consultation.CreateConsultationCommand;
import com.sa.healntrack.patient_service.consultation.application.port.out.persistence.SaveConsultation;
import com.sa.healntrack.patient_service.consultation.application.port.out.rest.employee.VerifyActiveDoctor;
import com.sa.healntrack.patient_service.consultation.domain.Consultation;
import com.sa.healntrack.patient_service.patient.application.port.out.persistence.ExistsPatientById;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class CreateConsultationImpl implements CreateConsultation {

    private final ExistsPatientById existsPatientById;
    private final ConsultationMapper mapper;
    private final SaveConsultation saveConsultation;
    private final VerifyActiveDoctor verifyActiveDoctor;
    
    @Override
    public Consultation create(CreateConsultationCommand command) {
        if (!existsPatientById.existsById(command.patientId())) {
            throw new EntityNotFoundException(
                    "No existe un paciente con el id: " + command.patientId());
        }
        if (!verifyActiveDoctor.verify(command.employeeId())) {
            throw new EntityNotFoundException(
                    "No existe un medico activo con el id: " + command.employeeId());
        }
        Consultation consultation = mapper.toDomain(command);
        return saveConsultation.save(consultation);
    }

}
