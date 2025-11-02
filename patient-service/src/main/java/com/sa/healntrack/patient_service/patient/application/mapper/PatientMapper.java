package com.sa.healntrack.patient_service.patient.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sa.healntrack.patient_service.patient.application.port.in.create_patient.CreatePatientCommand;
import com.sa.healntrack.patient_service.patient.application.port.in.update_patient.UpdatePatientCommand;
import com.sa.healntrack.patient_service.patient.domain.Patient;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    Patient toDomain(CreatePatientCommand command);

    default Patient updateDomain(UpdatePatientCommand command, Patient patient) {
        return new Patient(
                patient.getId().value(),
                patient.getCui().value(),
                defaultIfNull(command.fullName(), patient.getFullName().value()),
                patient.getBirthDate(),
                defaultIfNull(command.gender(), patient.getGender()),
                defaultIfNull(command.address(), patient.getAddress().value()),
                defaultIfNull(command.email(), patient.getEmail().value()),
                defaultIfNull(command.phoneNumber(), patient.getPhoneNumber().value()),
                defaultIfNull(command.emergencyPhoneNumber(), patient.getEmergencyPhoneNumber().value()));
    }

    private static <T> T defaultIfNull(T value, T defaultValue) {
        return value != null ? value : defaultValue;
    }

}
