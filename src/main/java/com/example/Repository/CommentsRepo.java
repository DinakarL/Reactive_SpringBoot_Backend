package com.example.Repository;

import com.example.Entity.Comments;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CommentsRepo extends ReactiveCrudRepository<Comments, Long> {

    Flux<Comments> findByAnswerId(Long id);
}
