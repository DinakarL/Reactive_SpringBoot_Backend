package com.example.Service;


import com.example.DTO.QuestionRequestDTO;
import com.example.DTO.QuestionResponseDTO;
import com.example.Events.ViewCountEvent;
import com.example.Mapper.QuestionMapper;
import com.example.Producer.KafkaProducer;
import com.example.Repository.QuestionRepo;
import com.example.Repository.SearchRepo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;


@Service
public class QuestionService implements IQuestionService{

    private final QuestionRepo questionRepo;
    private final IAnswerService answerService;
    private final KafkaProducer kafkaProducer;
    private final SearchRepo searchRepo;

    public QuestionService(QuestionRepo questionRepo, IAnswerService answerService, KafkaProducer kafkaProducer, SearchRepo searchRepo) {
        this.questionRepo = questionRepo;
        this.answerService = answerService;
        this.kafkaProducer = kafkaProducer;
        this.searchRepo = searchRepo;
    }

    @Override
    public Mono<QuestionResponseDTO> createQuestion(QuestionRequestDTO questionRequestDTO) {
        return questionRepo.save(QuestionMapper.toQuestion(questionRequestDTO))
               .map(QuestionMapper::toQuestionResponseDTO);
    }

    @Override
    public Mono<QuestionResponseDTO> getQuestionById(Long id) {

        // approach - 02 -- getting all answer associated to the question ID
        return questionRepo.findById(id)
                .flatMap(question -> {
                    QuestionResponseDTO questionResponseDTO = QuestionMapper.toQuestionResponseDTO(question);

                    return answerService.getAllAnswersByQuestionId(id)
                            .collectList()
                            .map(answer -> {
                                questionResponseDTO.setAnswers(answer);
                                return questionResponseDTO;
                            })
                            .doOnError( error -> System.out.println("Error fetching question: " + error))
                            .doOnSuccess(response -> {
                                System.out.println("Question fetched successfully: " + response);
                                ViewCountEvent viewCountEvent = new ViewCountEvent(id, LocalDateTime.now());
                                kafkaProducer.handleViewCountEvent(viewCountEvent);
                            });
                });
        // Approach  - 01 -- just returning the question response
//        return questionRepo.findById(id)
//                .map(QuestionMapper::toQuestionResponseDTO);
    }

    @Override
    public Flux<QuestionResponseDTO> getAllQuestions() {
        return questionRepo.findAll()
                .map(QuestionMapper::toQuestionResponseDTO);

    }

    @Override
    public Flux<QuestionResponseDTO> searchQuestion(String searchQuery) {
        return searchRepo.findByTitleContainingOrContentContaining(searchQuery,searchQuery);
    }
}
