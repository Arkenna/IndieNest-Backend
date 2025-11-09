package com.arkenna.indienest.backend.community.application.internal.queryservices;

import com.arkenna.indienest.backend.community.domain.model.aggregates.Answer;
import com.arkenna.indienest.backend.community.domain.model.queries.GetAllAnswersQuery;
import com.arkenna.indienest.backend.community.domain.model.queries.GetAnswerByIdQuery;
import com.arkenna.indienest.backend.community.domain.services.AnswerQueryService;
import com.arkenna.indienest.backend.community.infrastructure.persistence.jpa.repositories.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Answer Query Service Implementation
 */
@Service
public class AnswerQueryServiceImpl implements AnswerQueryService {

    private final AnswerRepository answerRepository;

    /**
     * Constructor
     *
     * @param answerRepository The {@link AnswerRepository} instance
     */
    public AnswerQueryServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    //inherited javadoc
    @Override
    public List<Answer> handle(GetAllAnswersQuery query) {
        return this.answerRepository.findAll();
    }

    //inherited javadoc
    @Override
    public Optional<Answer> handle(GetAnswerByIdQuery query) {
        return this.answerRepository.findById(query.id());
    }
}
