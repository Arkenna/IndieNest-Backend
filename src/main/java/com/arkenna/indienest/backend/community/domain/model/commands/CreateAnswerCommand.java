package com.arkenna.indienest.backend.community.domain.model.commands;

/**
 * Create Answer Command
 * @param userId User Id
 * @param publicationId Publication Id
 * @param comment Answer Comment
 */
public record CreateAnswerCommand(Integer userId, Integer publicationId, String comment) {
}
