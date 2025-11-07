package com.sa.healntrack.patient_service.patient.infrastructure.adapter.out.messaging;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sa.healntrack.patient_service.common.infrastructure.exception.MessageSerializationException;
import com.sa.healntrack.patient_service.patient.application.port.out.messaging.PublishPatientCreated;
import com.sa.healntrack.patient_service.patient.application.port.out.messaging.PublishPatientUpdated;
import com.sa.healntrack.patient_service.patient.domain.Patient;
import com.sa.healntrack.patient_service.patient.infrastructure.adapter.out.messaging.mapper.PatientMessagingMapper;
import com.sa.healntrack.patient_service.patient.infrastructure.adapter.out.messaging.message.PatientCreatedMessage;
import com.sa.healntrack.patient_service.patient.infrastructure.adapter.out.messaging.message.PatientUpdatedMessage;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class PatientPusblisher  implements PublishPatientCreated, PublishPatientUpdated{
    
    private final ObjectMapper objectMapper;
    private final PatientMessagingMapper mapper;
    private final KafkaTemplate<String, byte[]> template;

    @Override
    public void publishCreatedMessage(Patient patient) {
        PatientCreatedMessage message = mapper.toCreatedMessage(patient);
        try {
            template.send("patient.created", objectMapper.writeValueAsBytes(message));
        } catch (JsonProcessingException e) {
            throw new MessageSerializationException("No se pudo serializar el mensage");
        }
    }

    @Override
    public void publishUpdatedMessage(Patient patient) {
        PatientUpdatedMessage message = mapper.toUpdatedMessage(patient);
        try {
            template.send("patient.updated", objectMapper.writeValueAsBytes(message));
        } catch (JsonProcessingException e) {
            throw new MessageSerializationException("No se pudo serializar el mensage");
        }
    }

}
