package com.example.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponseDTO {

    public String content;
    public Long answerId;
    public Long parentCommentId;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
}
