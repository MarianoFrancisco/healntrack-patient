package com.sa.healntrack.patient_service.patient.domain;

import java.time.LocalDate;
import java.util.UUID;

import com.sa.healntrack.patient_service.patient.domain.value_objects.CUI;
import com.sa.healntrack.patient_service.patient.domain.value_objects.Email;
import com.sa.healntrack.patient_service.patient.domain.value_objects.FullName;
import com.sa.healntrack.patient_service.patient.domain.value_objects.PatientGender;
import com.sa.healntrack.patient_service.patient.domain.value_objects.PatientId;
import com.sa.healntrack.patient_service.patient.domain.value_objects.PhoneNumber;

import lombok.Getter;

@Getter
public class Patient {

    private final PatientId id;
    private final CUI cui;
    private final FullName fullName;
    private final LocalDate birthDate;
    private final PatientGender gender;
    private final String address;
    private final Email email;
    private final PhoneNumber phoneNumber;
    private final PhoneNumber emergencyPhoneNumber;

    public Patient(UUID id, String cui, String fullName, LocalDate birthDate, String gender,
            String address, String email, String phoneNumber, String emergencyPhoneNumber) {
        this.id = new PatientId(id);
        this.cui = new CUI(cui);
        this.fullName = new FullName(fullName);
        this.birthDate = birthDate;
        this.gender = PatientGender.fromString(gender);
        this.address = address;
        this.email = new Email(email);
        this.phoneNumber = new PhoneNumber(phoneNumber);
        this.emergencyPhoneNumber = new PhoneNumber(emergencyPhoneNumber);
    }

}
