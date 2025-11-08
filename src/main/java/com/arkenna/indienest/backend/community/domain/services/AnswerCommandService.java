package com.arkenna.indienest.backend.community.domain.services;

import com.arkenna.indienest.backend.community.domain.model.aggregates.Answer;
import com.arkenna.indienest.backend.community.domain.model.commands.CreateAnswerCommand;

import java.util.Optional;

/**
 * Answer Command Service
 */
public interface AnswerCommandService {

    /**
     * Handle Create Answer Command
     * @param command The {@link CreateAnswerCommand} Command
     * @return A {@link Answer} instance if the command is valid, otherwise empty
     * @throws IllegalArgumentException if already exists an Answer with same UserId and Comment
     */
    Optional<Answer> handle(CreateAnswerCommand command);
}
