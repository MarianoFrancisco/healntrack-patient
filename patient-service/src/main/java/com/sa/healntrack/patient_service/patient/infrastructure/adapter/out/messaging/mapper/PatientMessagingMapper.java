package com.sa.healntrack.patient_service.patient.infrastructure.adapter.out.messaging.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sa.healntrack.patient_service.patient.domain.Patient;
import com.sa.healntrack.patient_service.patient.infrastructure.adapter.out.messaging.message.PatientCreatedMessage;
import com.sa.healntrack.patient_service.patient.infrastructure.adapter.out.messaging.message.PatientUpdatedMessage;

@Mapper(componentModel = "spring")
public interface PatientMessagingMapper {

    @Mapping(target = "id", source = "patient.id.value")
    @Mapping(target = "cui", source = "patient.cui.value")
    @Mapping(target = "fullName", source = "patient.fullName.value")
    PatientCreatedMessage toCreatedMessage(Patient patient);

    @Mapping(target = "id", source = "patient.id.value")
    @Mapping(target = "fullName", source = "patient.fullName.value")
    PatientUpdatedMessage toUpdatedMessage(Patient patient);
    
}
