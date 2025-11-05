package com.sa.healntrack.patient_service.consultation.infrastructure.adapter.out.rest.employee.client;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sa.healntrack.patient_service.consultation.infrastructure.adapter.out.rest.employee.dto.EmployeeResponseDTO;

@FeignClient(name = "employee-service", path = "/api/v1/employees")
public interface EmployeeClient {
    
    @GetMapping("/id/{id}")
    EmployeeResponseDTO findById(@PathVariable UUID id);

}
