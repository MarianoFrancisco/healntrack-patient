package com.sa.healntrack.patient_service.patient.infrastructure.adapter.out.persistence;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sa.healntrack.patient_service.patient.application.port.in.get_all_patients.GetAllPatientsQuery;
import com.sa.healntrack.patient_service.patient.application.port.out.persistence.ExistsPatientByCui;
import com.sa.healntrack.patient_service.patient.application.port.out.persistence.FindAllPatients;
import com.sa.healntrack.patient_service.patient.application.port.out.persistence.FindPatientById;
import com.sa.healntrack.patient_service.patient.application.port.out.persistence.SavePatient;
import com.sa.healntrack.patient_service.patient.domain.Patient;
import com.sa.healntrack.patient_service.patient.infrastructure.adapter.out.persistence.entity.PatientEntity;
import com.sa.healntrack.patient_service.patient.infrastructure.adapter.out.persistence.mapper.PatientPersistenceMapper;
import com.sa.healntrack.patient_service.patient.infrastructure.adapter.out.persistence.repository.PatientEntityRepository;
import com.sa.healntrack.patient_service.patient.infrastructure.adapter.out.persistence.specification.PatientSpecs;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class PatientRepository implements SavePatient, ExistsPatientByCui, FindPatientById, FindAllPatients {

    private final PatientEntityRepository repository;
    private final PatientPersistenceMapper mapper;

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public Patient save(Patient patient) {
        PatientEntity entity = repository.save(mapper.toEntity(patient));
        return mapper.toDomain(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean exists(String cui) {
        return repository.existsByCui(cui);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Patient> findById(UUID id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Patient> findAll(GetAllPatientsQuery query) {
        Specification<PatientEntity> specs = Specification
                .allOf(
                        PatientSpecs.hasGender(query.gender()),
                        Specification.anyOf(
                                PatientSpecs.fullNameContains(query.searchTerm()),
                                PatientSpecs.CUIContains(query.searchTerm())));
        return repository.findAll(specs)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

}
