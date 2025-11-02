package com.sa.healntrack.patient_service.patient.infrastructure.adapter.in.rest.dto;

import jakarta.validation.constraints.Pattern;

public record SearchPatientsRequestDTO(

    String q,

    @Pattern(regexp = "MALE|FEMALE|OTHER", message = "El genero solo puede ser MALE, FEMALE u OTHER")
    String gender

) { }
