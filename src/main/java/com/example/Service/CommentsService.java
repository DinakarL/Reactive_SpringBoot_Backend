package com.example.Service;

import com.example.DTO.CommentResponseDTO;
import com.example.DTO.CommentsRequestDTO;
import com.example.Mapper.CommentsMapper;
import com.example.Repository.CommentsRepo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CommentsService implements ICommentsService {

    private final CommentsRepo commentsRepo;

    public CommentsService(CommentsRepo commentsRepo) {
        this.commentsRepo = commentsRepo;
    }

    @Override
    public Mono<CommentResponseDTO> postComment(CommentsRequestDTO commentsRequestDTO) {
        return commentsRepo.save(CommentsMapper.toComments(commentsRequestDTO))
                .map(CommentsMapper::toCommentResponseDTO);
    }

    @Override
    public Flux<CommentResponseDTO> getAllCommentsByAnswerId(Long answerId) {
        return commentsRepo.findByAnswerId(answerId)
                .map(CommentsMapper::toCommentResponseDTO);
    }
}
