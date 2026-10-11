package com.example.DTO;

import lombok.Data;

@Data
public class CommentsRequestDTO {

    public String content;
    public Long answerId;
    public Long parentCommentId;
}
