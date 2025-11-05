package com.sa.healntrack.patient_service.consultation.application.port.out.persistence;

import java.util.List;

import com.sa.healntrack.patient_service.consultation.application.port.in.get_all_consultations.GetAllConsultationsQuery;
import com.sa.healntrack.patient_service.consultation.domain.Consultation;

public interface FindAllConsultations {
    
    List<Consultation> findAll(GetAllConsultationsQuery query);

}
