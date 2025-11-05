package com.sa.healntrack.patient_service.patient.infrastructure.adapter.in.rest.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreatePatientRequestDTO(

        @NotBlank(message = "El CUI es obligatorio")
        @Size(min = 13, max = 13, message = "El CUI debe tener exactamente {min} caracteres")
        String cui,

        @NotBlank(message = "El nombre es obligatorio")
        @Size(max = 150, message = "El nombre no debe superar los {max} caracteres")
        String fullName,

        @NotNull(message = "La fecha de nacimiento es obligatoria")
        @Past(message = "La fecha de nacimiento debe ser pasada")
        LocalDate birthDate,

        @NotBlank(message = "El género es obligatorio")
        @Pattern(regexp = "MALE|FEMALE|OTHER", message = "El genero solo puede ser MALE, FEMALE u OTHER")
        String gender,

        @NotBlank(message = "La dirección es obligatoria")
        @Size(min = 5, message = "La dirección debe superar los {min} caracteres")
        String address,

        @NotBlank(message = "El email es obligatorio")
        @Size(max = 100, message = "El email no debe superar los {max} caracteres")
        String email,

        @NotBlank(message = "El número de teléfono es obligatorio")
        @Size(min = 8, max = 8, message = "El número de teléfono debe tener exactamente {min} digitos")
        String phoneNumber,

        @NotBlank(message = "El número de teléfono es obligatorio")
        @Size(min = 8, max = 8, message = "El número de teléfono debe tener exactamente {min} digitos")
        String emergencyPhoneNumber
        
) { }
