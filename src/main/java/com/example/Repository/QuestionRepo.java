package com.example.Repository;

import com.example.Entity.Question;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
@Repository
public interface QuestionRepo extends ReactiveCrudRepository<Question,Long> {


}
