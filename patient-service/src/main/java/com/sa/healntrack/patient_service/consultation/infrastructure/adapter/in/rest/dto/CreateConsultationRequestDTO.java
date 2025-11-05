package com.sa.healntrack.patient_service.consultation.infrastructure.adapter.in.rest.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public record CreateConsultationRequestDTO(

        @NotNull(message = "El id del paciente es obligatorio")
        UUID patientId,

        @NotNull(message = "El id del doctor es obligatorio")
        UUID employeeId,

        @PastOrPresent(message = "La fecha no puede ser futura")
        @NotNull(message = "La fecha de consulta es obligatoria")
        LocalDate date,

        @Size(min = 5, message = "El diagnostico debe superar los {min} caracteres")
        @NotBlank(message = "El diagnostico es obligatorio")
        String reason,

        @Size(min = 5, message = "El diagnostico debe superar los {min} caracteres")
        @NotBlank(message = "El diagnostico es obligatorio")
        String diagnosis,

        @Size(min = 5, message = "El tratamiento debe superar los {min} caracteres")
        String treatment,

        @Min(0)
        @NotNull(message = "El costo de consulta es obligatorio")
        BigDecimal totalFee

) { }
