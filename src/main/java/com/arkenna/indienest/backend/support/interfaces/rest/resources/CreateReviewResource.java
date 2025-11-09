package com.arkenna.indienest.backend.support.interfaces.rest.resources;

public record CreateReviewResource(Integer userId, Integer projectId, String comment, Integer rating) {
}
