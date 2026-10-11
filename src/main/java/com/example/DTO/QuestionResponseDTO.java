package com.example.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponseDTO {

    public Long id;
    public String title;
    public String content;
    public Long views;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;

    List<AnswerResponseDTO> answers;
}
