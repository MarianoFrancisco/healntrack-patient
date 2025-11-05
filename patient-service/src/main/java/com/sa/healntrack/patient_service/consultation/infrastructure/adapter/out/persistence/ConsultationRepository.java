package com.sa.healntrack.patient_service.consultation.infrastructure.adapter.out.persistence;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sa.healntrack.patient_service.consultation.application.port.in.get_all_consultations.GetAllConsultationsQuery;
import com.sa.healntrack.patient_service.consultation.application.port.out.persistence.FindAllConsultations;
import com.sa.healntrack.patient_service.consultation.application.port.out.persistence.SaveConsultation;
import com.sa.healntrack.patient_service.consultation.domain.Consultation;
import com.sa.healntrack.patient_service.consultation.infrastructure.adapter.out.persistence.entity.ConsultationEntity;
import com.sa.healntrack.patient_service.consultation.infrastructure.adapter.out.persistence.mapper.ConsultationPersistenceMapper;
import com.sa.healntrack.patient_service.consultation.infrastructure.adapter.out.persistence.repository.ConsultationEntityRepository;
import com.sa.healntrack.patient_service.consultation.infrastructure.adapter.out.persistence.specificacion.ConsultationSpecs;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class ConsultationRepository implements SaveConsultation, FindAllConsultations {

    private final ConsultationPersistenceMapper mapper;
    private final ConsultationEntityRepository repository;
    
    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public Consultation save(Consultation consultation) {
        ConsultationEntity entity = repository.save(
                mapper.toEntity(consultation));
        return mapper.toDomain(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Consultation> findAll(GetAllConsultationsQuery query) {
        Specification<ConsultationEntity> specs = Specification.allOf(
                ConsultationSpecs.hasPatientId(query.patientId()),
                ConsultationSpecs.hasDoctorId(query.doctorId()));
        return repository.findAll(specs).stream()
                .map(mapper::toDomain)
                .toList();
    }

}
