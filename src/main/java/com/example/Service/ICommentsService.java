package com.example.Service;

import com.example.DTO.CommentResponseDTO;
import com.example.DTO.CommentsRequestDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICommentsService {

    Mono<CommentResponseDTO> postComment(CommentsRequestDTO commentsRequestDTO);

    Flux<CommentResponseDTO> getAllCommentsByAnswerId(Long answerId);
}
