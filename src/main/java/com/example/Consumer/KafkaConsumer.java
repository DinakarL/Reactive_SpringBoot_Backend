package com.example.Consumer;

import com.example.Configuration.KafkaConfig;
import com.example.Events.ViewCountEvent;
import com.example.Repository.QuestionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {


    private final QuestionRepo questionRepo;

    @KafkaListener(
            topics = KafkaConfig.TOPIC_NAME,
            groupId = "view-count-consumer",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void handleViewCountEvent(ViewCountEvent viewCountEvent) {
        questionRepo.findById(viewCountEvent.targetId)
                .flatMap(question -> {
                    Long views = question.getViews();
                    question.setViews(views + 1);
                    return questionRepo.save(question);
                })
                .subscribe(updatedQuestion -> {
                    System.out.println("view count incremented for question :" + updatedQuestion.getId());
                }, error -> {
                    System.out.println("Error occured while processing view count event" + error.getMessage());
                });
    }
}
