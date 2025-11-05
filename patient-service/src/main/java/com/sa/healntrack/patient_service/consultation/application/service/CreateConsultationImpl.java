package com.sa.healntrack.patient_service.consultation.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sa.healntrack.patient_service.common.application.exception.EntityNotFoundException;
import com.sa.healntrack.patient_service.consultation.application.mapper.ConsultationMapper;
import com.sa.healntrack.patient_service.consultation.application.port.in.create_consultation.CreateConsultation;
import com.sa.healntrack.patient_service.consultation.application.port.in.create_consultation.CreateConsultationCommand;
import com.sa.healntrack.patient_service.consultation.application.port.out.persistence.SaveConsultation;
import com.sa.healntrack.patient_service.consultation.application.port.out.rest.employee.GetDepartment;
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
    private final GetDepartment getDepartment;
    
    @Override
    public Consultation create(CreateConsultationCommand command) {
        boolean existsPatient = existsPatientById.existsById(command.patientId());
        if (!existsPatient) {
            throw new EntityNotFoundException(
                    "No existe un paciente con el id: " + command.patientId());
        }
        String department = getDepartment.get(command.doctorId());
        if (department == null) {
            throw new IllegalArgumentException("El empleado no se encuentra activo");
        }
        boolean isDoctor = department.contains("MED");
        if (!isDoctor) {
            throw new IllegalArgumentException("Solo se pueden asignar médicos");
        }
        Consultation newConsultation = mapper.toDomain(command);
        Consultation consultation = saveConsultation.save(newConsultation);
        return consultation;
    }

}
