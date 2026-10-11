package com.example.Controller;

import com.example.DTO.AnswerRequestDTO;
import com.example.DTO.AnswerResponseDTO;
import com.example.Repository.AnswerRepo;
import com.example.Service.IAnswerService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/quora/answer")
public class AnswerController {

    private final IAnswerService answerService;

    public AnswerController(IAnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping("/create")
    public Mono<AnswerResponseDTO> postAnswer(@RequestBody AnswerRequestDTO answerRequestDTO) {
        return answerService.postAnswer(answerRequestDTO)
                .doOnSuccess(answer -> System.out.println("Answer created successfully" + answer))
                .doOnError(error -> System.out.println("Error creating answer: " + error));
    }

    @GetMapping("/{id}")
    public Mono<AnswerResponseDTO> getAnswerById(@PathVariable("id") Long answerId) {
        return answerService.getAnswerById(answerId)
                .doOnSuccess(answer -> System.out.println("Answer created successfully" + answer))
                .doOnError(error -> System.out.println("Error creating answer: " + error));
    }

    @GetMapping
    public Flux<AnswerResponseDTO> getAllAnswers() {
        return answerService.getAllAnswers()
                .doOnComplete(() -> System.out.println("All answers Retrieved successfully"));
    }

    @GetMapping("/questionId")
    public Flux<AnswerResponseDTO> getAllAnswersByQuestionId(@RequestParam Long questionId) {
        return answerService.getAllAnswersByQuestionId(questionId)
                .doOnComplete(() -> System.out.println("All answers Retrieved successfully for Question ID :" + questionId ));
    }
}
