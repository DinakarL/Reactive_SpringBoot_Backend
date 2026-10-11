package com.example.Mapper;

import com.example.DTO.AnswerResponseDTO;
import com.example.DTO.QuestionRequestDTO;
import com.example.DTO.QuestionResponseDTO;
import com.example.Entity.Answer;
import com.example.Entity.Question;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;

public class QuestionMapper {

    public static Question toQuestion(QuestionRequestDTO questionRequestDTO) {
        return Question.builder()
                .title(questionRequestDTO.getTitle())
                .content(questionRequestDTO.getContent())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static QuestionResponseDTO toQuestionResponseDTO(Question question) {
        return QuestionResponseDTO.builder()
                .id(question.getId())
                .title(question.getTitle())
                .content(question.getContent())
                .views(question.getViews())
                .createdAt(question.getCreatedAt())
                .updatedAt(question.getUpdatedAt())
                .build();
    }

    public static QuestionResponseDTO toQuestionResponseDTO(Question question, List<AnswerResponseDTO> answer) {
        return QuestionResponseDTO.builder()
                .id(question.getId())
                .title(question.getTitle())
                .content(question.getContent())
                .views(question.getViews())
                .createdAt(question.getCreatedAt())
                .updatedAt(question.getUpdatedAt())
                .answers(answer)
                .build();
    }
}