package com.example.Service;

import com.example.DTO.AnswerRequestDTO;
import com.example.DTO.AnswerResponseDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAnswerService {

    Mono<AnswerResponseDTO> postAnswer(AnswerRequestDTO answerRequestDTO);

    Mono<AnswerResponseDTO> getAnswerById(Long id);

    Flux<AnswerResponseDTO> getAllAnswers();

    Flux<AnswerResponseDTO> getAllAnswersByQuestionId(Long questionId);


}
