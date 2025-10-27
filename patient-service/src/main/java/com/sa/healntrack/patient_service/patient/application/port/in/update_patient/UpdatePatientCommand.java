package com.sa.healntrack.patient_service.patient.application.port.in.update_patient;

public record UpdatePatientCommand(

        String fullName,
        String gender,
        String address,
        String email,
        String phoneNumber,
        String emergencyPhoneNumber
        
) { }
