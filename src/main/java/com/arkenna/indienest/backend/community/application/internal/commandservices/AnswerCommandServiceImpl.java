package com.arkenna.indienest.backend.community.application.internal.commandservices;

import com.arkenna.indienest.backend.community.domain.model.aggregates.Answer;
import com.arkenna.indienest.backend.community.domain.model.commands.CreateAnswerCommand;
import com.arkenna.indienest.backend.community.domain.model.valueobjects.AnswerComment;
import com.arkenna.indienest.backend.community.domain.model.valueobjects.UserId;
import com.arkenna.indienest.backend.community.domain.services.AnswerCommandService;
import com.arkenna.indienest.backend.community.infrastructure.persistence.jpa.repositories.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Answer Command Service Implementation
 */
@Service
public class AnswerCommandServiceImpl implements AnswerCommandService {

    private final AnswerRepository answerRepository;

    /**
     * Constructor
     * @param answerRepository The {@link AnswerRepository} instance
     */
    public AnswerCommandServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    // inherited javadoc
    @Override
    public Optional<Answer> handle(CreateAnswerCommand command){

        var userId = new UserId(command.userId());
        var comment = new AnswerComment(command.comment());
        if(answerRepository.existsByUserIdAndComment(userId, comment)){
            throw new IllegalArgumentException("Answer with userId and comment already exists");
        }
        var answer = new Answer(command);
        answerRepository.save(answer);
        return Optional.of(answer);
    }
}
