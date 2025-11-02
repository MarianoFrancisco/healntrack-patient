package com.sa.healntrack.patient_service.patient.application.port.in.update_patient;

import com.sa.healntrack.patient_service.patient.domain.value_object.Gender;

public record UpdatePatientCommand(

        String fullName,
        Gender gender,
        String address,
        String email,
        String phoneNumber,
        String emergencyPhoneNumber
        
) { }
