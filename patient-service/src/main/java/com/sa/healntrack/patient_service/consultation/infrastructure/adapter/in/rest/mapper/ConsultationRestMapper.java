package com.sa.healntrack.patient_service.consultation.infrastructure.adapter.in.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sa.healntrack.patient_service.consultation.application.port.in.create_consultation.CreateConsultationCommand;
import com.sa.healntrack.patient_service.consultation.domain.Consultation;
import com.sa.healntrack.patient_service.consultation.infrastructure.adapter.in.rest.dto.ConsultationResponseDTO;
import com.sa.healntrack.patient_service.consultation.infrastructure.adapter.in.rest.dto.CreateConsultationRequestDTO;
import com.sa.healntrack.patient_service.patient.infrastructure.adapter.in.rest.mapper.PatientRestMapper;

@Mapper(componentModel = "spring", uses = PatientRestMapper.class)
public interface ConsultationRestMapper {

    CreateConsultationCommand toDomain(CreateConsultationRequestDTO requestDTO);

    @Mapping(target = "id", source = "consultation.id.value")
    @Mapping(target = "patientId", source = "consultation.patientId.value")
    @Mapping(target = "doctorId", source = "consultation.doctorId.value")
    @Mapping(target = "reason", source = "consultation.reason.value")
    @Mapping(target = "diagnosis", source = "consultation.diagnosis.value")
    @Mapping(target = "treatment", source = "consultation.treatment.value")
    @Mapping(target = "totalFee", source = "consultation.totalFee.value")
    ConsultationResponseDTO toResponse(Consultation consultation);
    
}
