package com.sa.healntrack.patient_service.consultation.infrastructure.adapter.out.rest.employee;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.sa.healntrack.patient_service.consultation.application.port.out.rest.employee.VerifyActiveDoctor;
import com.sa.healntrack.patient_service.consultation.infrastructure.adapter.out.rest.employee.client.EmployeeClient;
import com.sa.healntrack.patient_service.consultation.infrastructure.adapter.out.rest.employee.dto.EmployeeResponseDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class EmployeeAPI implements VerifyActiveDoctor {
    
    private final EmployeeClient employeeClient;

    @Override
    public boolean verify(UUID id) {
        EmployeeResponseDTO employee = employeeClient.findById(id);
        boolean isDoctor = employee.department().code().contains("MED");
        return isDoctor && employee.isActive();
    }

}
