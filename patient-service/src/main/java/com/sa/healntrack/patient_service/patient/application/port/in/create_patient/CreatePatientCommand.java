package com.sa.healntrack.patient_service.patient.application.port.in.create_patient;

import java.time.LocalDate;

import com.sa.healntrack.patient_service.patient.domain.value_object.Gender;

public record CreatePatientCommand(

        String cui,
        String fullName,
        LocalDate birthDate,
        Gender gender,
        String address,
        String email,
        String phoneNumber,
        String emergencyPhoneNumber
        
) { }
