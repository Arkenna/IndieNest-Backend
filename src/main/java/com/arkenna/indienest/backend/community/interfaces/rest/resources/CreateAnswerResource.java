package com.arkenna.indienest.backend.community.interfaces.rest.resources;

/**
 * The CreateAnswer Command Resource
 */
public record CreateAnswerResource(Integer userId, Integer publicationId, String comment) {
}
