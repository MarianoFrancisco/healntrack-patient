package com.sa.healntrack.patient_service.consultation.infrastructure.adapter.out.messaging;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sa.healntrack.patient_service.common.infrastructure.exception.MessageSerializationException;
import com.sa.healntrack.patient_service.consultation.application.port.out.messaging.PublishConsultationRegistered;
import com.sa.healntrack.patient_service.consultation.domain.Consultation;
import com.sa.healntrack.patient_service.consultation.infrastructure.adapter.out.messaging.mapper.ConsultationMessagingMapper;
import com.sa.healntrack.patient_service.consultation.infrastructure.adapter.out.messaging.message.ConsultationRegisteredMessage;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ConsultationPublisher implements PublishConsultationRegistered {
    
    private final ObjectMapper objectMapper;
    private final ConsultationMessagingMapper mapper;
    private final KafkaTemplate<String, byte[]> template;

    @Override
    public void publishRegisteredMessage(Consultation consultation) {
        ConsultationRegisteredMessage message = mapper.toRegisteredMessate(consultation);
        try {
            template.send("consultation.registered", objectMapper.writeValueAsBytes(message));
        } catch (JsonProcessingException e) {
            throw new MessageSerializationException("No se pudo serializar el mensage");
        }
    }
    

}
