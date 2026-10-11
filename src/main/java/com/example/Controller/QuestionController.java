package com.example.Controller;

import com.example.DTO.QuestionRequestDTO;
import com.example.DTO.QuestionResponseDTO;
import com.example.Service.IQuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/quora/question")
public class QuestionController {

    private final IQuestionService questionService;

    public QuestionController(IQuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/create")
    public Mono<QuestionResponseDTO> createQuestion(@RequestBody QuestionRequestDTO questionRequestDTO) {
        return questionService.createQuestion(questionRequestDTO)
                .doOnError(question -> System.out.println("Error creating question" + questionRequestDTO))
                .doOnSuccess(question -> System.out.println("Question Created Successfully" + questionRequestDTO));
    }

    @GetMapping("/{id}")
    public Mono<QuestionResponseDTO> getQuestionById(@PathVariable Long id){
        return questionService.getQuestionById(id)
                .doOnSuccess(question -> System.out.println("Question Retrieved Successfully"))
                .doOnError(question -> System.out.println("Question Retrieving Error"));
    }

    @GetMapping
    public Flux<QuestionResponseDTO> getAllQuestions(){
        return questionService.getAllQuestions()
                .doOnComplete(() -> System.out.println("All Questions Retrieved Successfully"));
    }

    @GetMapping()
    public Flux<QuestionResponseDTO> searchQuestion(@RequestParam String searchQuery){
        return questionService.searchQuestion(searchQuery);
    }


}
