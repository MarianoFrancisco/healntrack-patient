package com.sa.healntrack.patient_service.patient.infrastructure.adapter.in.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sa.healntrack.patient_service.patient.application.port.in.create_patient.CreatePatientCommand;
import com.sa.healntrack.patient_service.patient.application.port.in.get_all_patients.GetAllPatientsQuery;
import com.sa.healntrack.patient_service.patient.application.port.in.update_patient.UpdatePatientCommand;
import com.sa.healntrack.patient_service.patient.domain.Patient;
import com.sa.healntrack.patient_service.patient.infrastructure.adapter.in.rest.dto.CreatePatientRequestDTO;
import com.sa.healntrack.patient_service.patient.infrastructure.adapter.in.rest.dto.SearchPatientsRequestDTO;
import com.sa.healntrack.patient_service.patient.infrastructure.adapter.in.rest.dto.PatientResponseDTO;
import com.sa.healntrack.patient_service.patient.infrastructure.adapter.in.rest.dto.UpdatePatientRequestDTO;

@Mapper(componentModel = "spring")
public interface PatientRestMapper {

    CreatePatientCommand toCommand(CreatePatientRequestDTO requestDTO);

    UpdatePatientCommand toCommand(UpdatePatientRequestDTO requestDTO);

    @Mapping(target = "searchTerm", source = "q")
    GetAllPatientsQuery toQuery(SearchPatientsRequestDTO requestDTO);

    @Mapping(target = "id", source = "patient.id.value")
    @Mapping(target = "cui", source = "patient.cui.value")
    @Mapping(target = "fullName", source = "patient.fullName.value")
    @Mapping(target = "email", source = "patient.email.value")
    @Mapping(target = "phoneNumber", source = "patient.phoneNumber.value")
    @Mapping(target = "emergencyPhoneNumber", source = "patient.emergencyPhoneNumber.value")
    PatientResponseDTO toResponseDTO(Patient patient);

}
