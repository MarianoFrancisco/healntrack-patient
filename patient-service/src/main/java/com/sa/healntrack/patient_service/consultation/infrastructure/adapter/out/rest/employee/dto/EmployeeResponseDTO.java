package com.sa.healntrack.patient_service.consultation.infrastructure.adapter.out.rest.employee.dto;

import java.util.UUID;

public record EmployeeResponseDTO(

    UUID id,
    DepartmentResponseDTO department,
    boolean isActive

) { }
