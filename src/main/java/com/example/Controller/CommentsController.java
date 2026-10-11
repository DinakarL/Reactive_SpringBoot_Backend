package com.example.Controller;

import com.example.DTO.CommentResponseDTO;
import com.example.DTO.CommentsRequestDTO;
import com.example.Service.ICommentsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/quora/comment")
public class CommentsController {

    private final ICommentsService commentsService;

    public CommentsController(ICommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @PostMapping
    public Mono<CommentResponseDTO> postComment(@RequestBody CommentsRequestDTO commentsRequestDTO) {
        return commentsService.postComment(commentsRequestDTO)
                .doOnError(error -> System.out.println("Comment Posting Error" + commentsRequestDTO))
                .doOnSuccess(comment -> System.out.println("Comment Posting Successfully"));
    }
}
