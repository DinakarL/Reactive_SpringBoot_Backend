package com.example.Mapper;

import com.example.DTO.AnswerRequestDTO;
import com.example.DTO.AnswerResponseDTO;
import com.example.Entity.Answer;

import java.time.LocalDateTime;

public class AnswerMapper {

    public static Answer toAnswer(AnswerRequestDTO answerRequestDTO) {
        return Answer.builder()
                .targetId(answerRequestDTO.getTargetId())
                .content(answerRequestDTO.getAnswer())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static AnswerResponseDTO toAnswerResponseDTO(Answer answer) {
        return AnswerResponseDTO.builder()
                .id(answer.getId())
                .targetId(answer.getTargetId())
                .answer(answer.getContent())
                .createdAt(answer.getCreatedAt())
                .updatedAt(answer.getUpdatedAt())
                .build();

    }
}
