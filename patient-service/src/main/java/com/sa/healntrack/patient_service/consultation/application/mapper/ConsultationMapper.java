package com.sa.healntrack.patient_service.consultation.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sa.healntrack.patient_service.consultation.application.port.in.create_consultation.CreateConsultationCommand;
import com.sa.healntrack.patient_service.consultation.domain.Consultation;

@Mapper(componentModel = "spring")
public interface ConsultationMapper {

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    Consultation toDomain(CreateConsultationCommand command);
    
}
