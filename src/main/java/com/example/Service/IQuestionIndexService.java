package com.example.Service;

import com.example.Entity.Question;
import com.example.Entity.QuestionElasticDocument;
import org.springframework.stereotype.Service;


public interface IQuestionIndexService {

    void createQuestionIndex(Question question);
}
