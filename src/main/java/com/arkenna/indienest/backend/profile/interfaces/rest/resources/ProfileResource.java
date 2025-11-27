package com.arkenna.indienest.backend.profile.interfaces.rest.resources;

public record ProfileResource(
        Integer id,
        String description,
        String image,
        Integer accountId,
        Integer portfolioId
) {
}
