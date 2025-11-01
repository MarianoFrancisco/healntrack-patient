package com.sa.healntrack.patient_service.consultation.infrastructure.adapter.out.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sa.healntrack.patient_service.consultation.domain.Consultation;
import com.sa.healntrack.patient_service.consultation.infrastructure.adapter.out.persistence.entity.ConsultationEntity;
import com.sa.healntrack.patient_service.patient.infrastructure.adapter.out.persistence.mapper.PatientPersistenceMapper;

@Mapper(componentModel = "spring", uses = PatientPersistenceMapper.class)
public interface ConsultationPersistenceMapper {

    Consultation toDomain(ConsultationEntity entity);

    @Mapping(target = "id", source = "consultation.id.value")
    @Mapping(target = "doctorId", source = "consultation.doctorId.value")
    @Mapping(target = "reason", source = "consultation.reason.value")
    @Mapping(target = "diagnosis", source = "consultation.diagnosis.value")
    @Mapping(target = "treatment", source = "consultation.treatment.value")
    @Mapping(target = "totalFee", source = "consultation.totalFee.value")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    ConsultationEntity toEntity(Consultation consultation);
    
}
