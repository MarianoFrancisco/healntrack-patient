package com.sa.healntrack.patient_service.patient.infrastructure.adapter.in.rest.dto;

import jakarta.validation.constraints.Size;

public record UpdatePatientRequestDTO(

    @Size(max = 150, message = "El nombre no debe superar los {max} caracteres")
    String fullName,

    String gender,

    String address,

    @Size(max = 100, message = "El email no debe superar los {max} caracteres")
    String email,

    @Size(min = 8, max = 8, message = "El número de teléfono debe tener exactamente {min} digitos")
    String phoneNumber,

    @Size(min = 8, max = 8, message = "El número de teléfono debe tener exactamente {min} digitos")
    String emergencyPhoneNumber

) { }
