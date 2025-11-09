package com.arkenna.indienest.backend.community.domain.services;


import com.arkenna.indienest.backend.community.domain.model.aggregates.Answer;
import com.arkenna.indienest.backend.community.domain.model.queries.GetAllAnswersQuery;
import com.arkenna.indienest.backend.community.domain.model.queries.GetAnswerByIdQuery;

import java.util.List;
import java.util.Optional;

/**
 * Answer Query Service
 */
public interface AnswerQueryService {

    /**
     * Handle Get All Answers Query
     * @param query The {@link GetAllAnswersQuery} Query
     * @return A List of {@link Answer} instances
     */
    List<Answer> handle(GetAllAnswersQuery query);

    /**
     * Get Answer By Id Query
     * @param query The {@link GetAnswerByIdQuery} Query
     * @return A {@link Answer} instance if the query is valid, otherwise empty
     */
    Optional<Answer> handle(GetAnswerByIdQuery query);
}
