package com.arkenna.indienest.backend.community.interfaces.rest.resources;

/**
 * The Publication Resource
 */
public record PublicationResource(Integer id, Integer userId, String title, String comment, String image) {
}
