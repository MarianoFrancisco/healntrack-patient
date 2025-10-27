package com.sa.healntrack.patient_service.patient.infrastructure.adapter.in.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sa.healntrack.patient_service.patient.application.port.in.create_patient.CreatePatient;
import com.sa.healntrack.patient_service.patient.application.port.in.get_all_patients.GetAllPatients;
import com.sa.healntrack.patient_service.patient.application.port.in.get_patient_by_id.GetPatientById;
import com.sa.healntrack.patient_service.patient.application.port.in.update_patient.UpdatePatient;
import com.sa.healntrack.patient_service.patient.domain.Patient;
import com.sa.healntrack.patient_service.patient.infrastructure.adapter.in.rest.dto.CreatePatientRequestDTO;
import com.sa.healntrack.patient_service.patient.infrastructure.adapter.in.rest.dto.PatientResponseDTO;
import com.sa.healntrack.patient_service.patient.infrastructure.adapter.in.rest.dto.SearchPatientsRequestDTO;
import com.sa.healntrack.patient_service.patient.infrastructure.adapter.in.rest.dto.UpdatePatientRequestDTO;
import com.sa.healntrack.patient_service.patient.infrastructure.adapter.in.rest.mapper.PatientRestMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@RequestMapping("/api/v1/patients")
@RestController
public class PatientController {

    private final PatientRestMapper mapper;
    private final CreatePatient createPatient;
    private final UpdatePatient updatePatient;
    private final GetAllPatients getAllPatients;
    private final GetPatientById getPatientById;

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getAll(SearchPatientsRequestDTO requestDTO) {
        List<Patient> patients = getAllPatients.getAll(mapper.toQuery(requestDTO));
        return ResponseEntity.status(HttpStatus.OK)
                .body(patients
                        .stream()
                        .map(mapper::toResponseDTO)
                        .toList());
    } 

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> get(@PathVariable UUID id) {
        Patient patient = getPatientById.get(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(mapper.toResponseDTO(patient));
    }
    

    @PostMapping
    public ResponseEntity<PatientResponseDTO> create(
            @RequestBody @Valid CreatePatientRequestDTO requestDTO) {
        Patient createdPatient = createPatient.create(mapper.toCommand(requestDTO));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toResponseDTO(createdPatient));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> update(
            @PathVariable UUID id,
            @RequestBody @Valid UpdatePatientRequestDTO requestDTO) {
        Patient updatedPatient = updatePatient.update(id, mapper.toCommand(requestDTO));
        return ResponseEntity.status(HttpStatus.OK)
                .body(mapper.toResponseDTO(updatedPatient));
    }
    

}
