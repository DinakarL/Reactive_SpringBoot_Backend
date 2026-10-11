package com.example.Repository;


import com.example.Entity.QuestionElasticDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ElasticSearchRepo extends ElasticsearchRepository<QuestionElasticDocument,Long> {

    List<QuestionElasticDocument> findByTitleContainingOrContentContaining(String title, String content);
}
