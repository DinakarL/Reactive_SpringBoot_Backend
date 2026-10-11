package com.example.Repository;

import com.example.Entity.QuestionElasticDocument;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepo extends ReactiveCrudRepository<QuestionElasticDocument, Long> {

    List<QuestionElasticDocument>findByTitleContainingOrContentContaining(String title, String content);

}
