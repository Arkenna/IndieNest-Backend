package com.arkenna.indienest.backend.iam.domain.model.commands;

public record CreateUserCommand(
        String name,
        String phoneNumber
) {
}