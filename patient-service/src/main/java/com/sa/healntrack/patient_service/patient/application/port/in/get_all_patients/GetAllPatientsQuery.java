package com.sa.healntrack.patient_service.patient.application.port.in.get_all_patients;

import com.sa.healntrack.patient_service.patient.domain.value_object.Gender;

public record GetAllPatientsQuery(

    String searchTerm,
    Gender gender

) { }
