package com.arkenna.indienest.backend.community.interfaces.rest.resources;

/**
 * The Answer Resource
 */
public record AnswerResource(Integer id, Integer userId, Integer publicationId, String comment) {
}
