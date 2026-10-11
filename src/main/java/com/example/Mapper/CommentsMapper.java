package com.example.Mapper;

import com.example.DTO.CommentResponseDTO;
import com.example.DTO.CommentsRequestDTO;
import com.example.Entity.Comments;

import java.time.LocalDateTime;

public class CommentsMapper {

    public static Comments toComments(CommentsRequestDTO commentsRequestDTO) {
        return  Comments.builder()
                .content(commentsRequestDTO.getContent())
                .answerId(commentsRequestDTO.getAnswerId())
                .parentCommentId(commentsRequestDTO.getParentCommentId())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static CommentResponseDTO toCommentResponseDTO(Comments comments) {
        return CommentResponseDTO.builder()
                .content(comments.getContent())
                .answerId(comments.getAnswerId())
                .parentCommentId(comments.getParentCommentId())
                .createdAt(comments.getCreatedAt())
                .updatedAt(comments.getUpdatedAt())
                .build();
    }
}
