package com.arkenna.indienest.backend.iam.domain.model.commands;

public record CreateAccountCommand(
        Integer userId,
        String email,
        String password,
        String role,
        boolean isActive
) {
}