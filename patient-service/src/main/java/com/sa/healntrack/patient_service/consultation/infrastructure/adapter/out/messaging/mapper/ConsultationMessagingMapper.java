package com.sa.healntrack.patient_service.consultation.infrastructure.adapter.out.messaging.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sa.healntrack.patient_service.consultation.domain.Consultation;
import com.sa.healntrack.patient_service.consultation.infrastructure.adapter.out.messaging.message.ConsultationRegisteredMessage;

@Mapper(componentModel = "spring")
public interface ConsultationMessagingMapper {
    
    @Mapping(target = "patientId", source = "consultation.patientId.value")
    @Mapping(target = "totalFee", source = "consultation.totalFee.value")
    ConsultationRegisteredMessage toRegisteredMessate(Consultation consultation);

}
