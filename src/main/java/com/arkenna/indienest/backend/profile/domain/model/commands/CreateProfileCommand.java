package com.arkenna.indienest.backend.profile.domain.model.commands;

public record CreateProfileCommand(
        String description,
        String image,
        Integer accountId,
        Integer portfolioId
) {
}
