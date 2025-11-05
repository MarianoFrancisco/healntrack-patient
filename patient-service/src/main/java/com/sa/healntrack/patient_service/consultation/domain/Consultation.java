package com.sa.healntrack.patient_service.consultation.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import com.sa.healntrack.patient_service.consultation.domain.value_object.ConsultationId;
import com.sa.healntrack.patient_service.consultation.domain.value_object.Diagnosis;
import com.sa.healntrack.patient_service.consultation.domain.value_object.DoctorId;
import com.sa.healntrack.patient_service.consultation.domain.value_object.Money;
import com.sa.healntrack.patient_service.consultation.domain.value_object.Reason;
import com.sa.healntrack.patient_service.consultation.domain.value_object.Treatment;
import com.sa.healntrack.patient_service.patient.domain.value_object.PatientId;

import lombok.Getter;

@Getter
public class Consultation {
    
    private final ConsultationId id;
    private final PatientId patientId;
    private final DoctorId doctorId;
    private final LocalDate date;
    private final Reason reason;
    private final Diagnosis diagnosis;
    private final Treatment treatment;
    private final Money totalFee;

    public Consultation(UUID id, UUID patientId, UUID doctorId, LocalDate date,
            String reason, String diagnosis, String treatment, BigDecimal totalFee) {
        this.id = new ConsultationId(id);
        this.patientId = new PatientId(patientId);
        this.doctorId = new DoctorId(doctorId);
        this.date = date;
        this.reason = new Reason(reason);
        this.diagnosis = new Diagnosis(diagnosis);
        this.treatment = new Treatment(treatment);
        this.totalFee = new Money(totalFee);
    }

}
