package com.example.Service;

import com.example.DTO.AnswerRequestDTO;
import com.example.DTO.AnswerResponseDTO;
import com.example.Mapper.AnswerMapper;
import com.example.Repository.AnswerRepo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AnswerService implements IAnswerService {

    private final AnswerRepo answerRepo;
    private final ICommentsService commentsService;

    public AnswerService(AnswerRepo answerRepo, ICommentsService commentsService) {
        this.answerRepo = answerRepo;
        this.commentsService = commentsService;
    }

    @Override
    public Mono<AnswerResponseDTO> postAnswer(AnswerRequestDTO answerRequestDTO) {
        return answerRepo.save(AnswerMapper.toAnswer(answerRequestDTO))
                .map(AnswerMapper::toAnswerResponseDTO);
    }

    @Override
    public Mono<AnswerResponseDTO> getAnswerById(Long id) {
        return answerRepo.findById(id)
                .map(AnswerMapper::toAnswerResponseDTO);
    }

    @Override
    public Flux<AnswerResponseDTO> getAllAnswers() {
        return answerRepo.findAll()
                .map(AnswerMapper::toAnswerResponseDTO);
    }

    @Override
    public Flux<AnswerResponseDTO> getAllAnswersByQuestionId(Long questionId) {

//        Default statement for the method

//        return answerRepo.findByTargetId(questionId)
//                .map(AnswerMapper::toAnswerResponseDTO);

        return answerRepo.findByTargetId(questionId)
                .flatMap(answer -> {
                    AnswerResponseDTO answerResponseDTO = AnswerMapper.toAnswerResponseDTO(answer);
                    return commentsService.getAllCommentsByAnswerId(answer.getId())
                            .collectList()
                            .map(comments -> {
                                answerResponseDTO.setComments(comments);
                                return answerResponseDTO;
                            });
                });
    }
}
