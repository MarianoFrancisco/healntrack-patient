package com.sa.healntrack.patient_service.consultation.application.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sa.healntrack.patient_service.consultation.application.port.in.get_all_consultations.GetAllConsultations;
import com.sa.healntrack.patient_service.consultation.application.port.in.get_all_consultations.GetAllConsultationsQuery;
import com.sa.healntrack.patient_service.consultation.application.port.out.persistence.FindAllConsultations;
import com.sa.healntrack.patient_service.consultation.domain.Consultation;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class GetAllConsultationsImpl implements GetAllConsultations {
    
    private final FindAllConsultations findAllConsultations;

    @Override
    public List<Consultation> getAll(GetAllConsultationsQuery query) {
        return findAllConsultations.findAll(query);
    }

}
