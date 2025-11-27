package com.arkenna.indienest.backend.profile.interfaces.rest.resources;

public record CreateProfileResource(
        String description,
        String image,
        Integer accountId,
        Integer portfolioId
) {
}
