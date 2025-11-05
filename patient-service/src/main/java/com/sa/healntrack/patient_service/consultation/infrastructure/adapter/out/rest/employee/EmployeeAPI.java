package com.sa.healntrack.patient_service.consultation.infrastructure.adapter.out.rest.employee;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.sa.healntrack.patient_service.consultation.application.port.out.rest.employee.GetDepartment;
import com.sa.healntrack.patient_service.consultation.infrastructure.adapter.out.rest.employee.client.EmployeeClient;
import com.sa.healntrack.patient_service.consultation.infrastructure.adapter.out.rest.employee.dto.EmployeeResponseDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class EmployeeAPI implements GetDepartment {
    
    private final EmployeeClient employeeClient;

    @Override
    public String get(UUID id) {
        EmployeeResponseDTO employee = employeeClient.findById(id);
        if (employee.isActive()) {
            return employee.department().code();
        }
        return null;
    }

}
