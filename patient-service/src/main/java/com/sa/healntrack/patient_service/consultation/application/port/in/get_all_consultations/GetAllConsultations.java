package com.sa.healntrack.patient_service.consultation.application.port.in.get_all_consultations;

import java.util.List;

import com.sa.healntrack.patient_service.consultation.domain.Consultation;

public interface GetAllConsultations {
    
    List<Consultation> getAll(GetAllConsultationsQuery query);

}
