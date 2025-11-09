package com.arkenna.indienest.backend.support.interfaces.rest.resources;

public record ReviewResource(Integer id, Integer userId, Integer projectId, String comment, Integer rating) {
}
