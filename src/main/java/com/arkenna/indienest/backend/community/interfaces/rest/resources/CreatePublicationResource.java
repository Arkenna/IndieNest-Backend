package com.arkenna.indienest.backend.community.interfaces.rest.resources;

/**
 * The CreatePublicationCommand Resource
 */
public record CreatePublicationResource(Integer userId, String title, String comment, String image) {
}
