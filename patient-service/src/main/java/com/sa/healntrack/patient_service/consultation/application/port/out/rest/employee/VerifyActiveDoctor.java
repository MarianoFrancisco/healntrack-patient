package com.sa.healntrack.patient_service.consultation.application.port.out.rest.employee;

import java.util.UUID;

public interface VerifyActiveDoctor {
    
    boolean verify(UUID id);

}
