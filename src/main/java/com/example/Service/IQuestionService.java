package com.example.Service;

import com.example.DTO.QuestionRequestDTO;
import com.example.DTO.QuestionResponseDTO;
import com.example.Entity.Question;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IQuestionService {

     public Mono<QuestionResponseDTO> createQuestion(QuestionRequestDTO questionRequestDTO);

     public Mono<QuestionResponseDTO> getQuestionById(Long id);

     public Flux<QuestionResponseDTO> getAllQuestions();

     public Flux<QuestionResponseDTO> searchQuestion(String searchQuery);
}
