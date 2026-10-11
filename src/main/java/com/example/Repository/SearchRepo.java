package com.example.Repository;

import com.example.Entity.SearchQuestionByElasticSearch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface SearchRepo extends ReactiveCrudRepository<SearchQuestionByElasticSearch, Long> {

    List<SearchQuestionByElasticSearch>findByTitleContainingOrContentContaining(String title, String content);

}
