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
public class AnswerResponseDTO {

    public Long id;
    public String answer;
    public Long targetId;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;

    List<CommentResponseDTO> comments;
}
