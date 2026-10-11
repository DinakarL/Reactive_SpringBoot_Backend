package com.example.Producer;

import com.example.Configuration.KafkaConfig;
import com.example.Events.ViewCountEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<Long, Object> kafkaTemplate;

    public void handleViewCountEvent(ViewCountEvent viewCountEvent) {
        kafkaTemplate.send(KafkaConfig.TOPIC_NAME, viewCountEvent.getTargetId(), viewCountEvent)
                .whenComplete((result, error) -> {
                    if (error != null) {
                        System.out.println("Error created while producing the event :" + error.getMessage());
                    }
                });
    }
}
