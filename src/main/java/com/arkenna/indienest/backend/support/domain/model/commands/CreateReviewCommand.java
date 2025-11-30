package com.arkenna.indienest.backend.support.domain.model.commands;

/**
 * Create Review Command
 */
public record CreateReviewCommand(Integer userId, Integer projectId, String comment, Integer rating) {
}
