package com.example.Service;

import com.example.Entity.Question;
import com.example.Entity.QuestionElasticDocument;
import com.example.Repository.ElasticSearchRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionIndexService implements IQuestionIndexService {

    private final ElasticSearchRepo elasticSearchRepo;

    @Override
    public void createQuestionIndex(Question question) {
        QuestionElasticDocument questionElasticDocument =QuestionElasticDocument.builder()
                .id(question.getId())
                .title(question.getTitle())
                .content(question.getContent())
                .build();
        elasticSearchRepo.save(questionElasticDocument);
    }
}
