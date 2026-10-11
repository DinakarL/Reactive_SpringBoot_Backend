package com.example.Repository;

import com.example.Entity.Answer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface AnswerRepo extends ReactiveCrudRepository<Answer, Long> {

    Flux<Answer> findByTargetId(Long id);
}
