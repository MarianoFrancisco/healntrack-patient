package com.sa.healntrack.patient_service.consultation.infrastructure.adapter.in.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sa.healntrack.patient_service.consultation.application.port.in.create_consultation.CreateConsultation;
import com.sa.healntrack.patient_service.consultation.application.port.in.get_all_consultations.GetAllConsultations;
import com.sa.healntrack.patient_service.consultation.domain.Consultation;
import com.sa.healntrack.patient_service.consultation.infrastructure.adapter.in.rest.dto.ConsultationResponseDTO;
import com.sa.healntrack.patient_service.consultation.infrastructure.adapter.in.rest.dto.CreateConsultationRequestDTO;
import com.sa.healntrack.patient_service.consultation.infrastructure.adapter.in.rest.dto.SearchConsultationsRequestDTO;
import com.sa.healntrack.patient_service.consultation.infrastructure.adapter.in.rest.mapper.ConsultationRestMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RequiredArgsConstructor
@RequestMapping("/api/v1/consultations")
@RestController
public class ConsultationController {
    
    private final ConsultationRestMapper mapper;
    private final CreateConsultation createConsultation;
    private final GetAllConsultations getAllConsultations;

    @PostMapping
    public ResponseEntity<ConsultationResponseDTO> create(
            @RequestBody @Valid CreateConsultationRequestDTO requestDTO) {
        Consultation consultation = createConsultation.create(mapper.toDomain(requestDTO));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toResponse(consultation));
    }

    @GetMapping
    public ResponseEntity<List<ConsultationResponseDTO>> getAll(
            SearchConsultationsRequestDTO requestDTO) {
        List<ConsultationResponseDTO> consultations = getAllConsultations
                .getAll(mapper.toQuery(requestDTO))
                .stream()
                .map(mapper::toResponse)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(consultations);
    }
    
    

}
