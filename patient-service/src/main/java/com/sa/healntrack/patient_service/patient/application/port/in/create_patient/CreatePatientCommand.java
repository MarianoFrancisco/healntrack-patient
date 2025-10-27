package com.sa.healntrack.patient_service.patient.application.port.in.create_patient;

import java.time.LocalDate;

public record CreatePatientCommand(

        String cui,
        String fullName,
        LocalDate birthDate,
        String gender,
        String address,
        String email,
        String phoneNumber,
        String emergencyPhoneNumber
        
) { }
