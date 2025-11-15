package com.arkenna.indienest.backend.iam.domain.model.commands;

public record UpdateUserCommand(
        Integer id,
        String name,
        String phoneNumber
) {
}