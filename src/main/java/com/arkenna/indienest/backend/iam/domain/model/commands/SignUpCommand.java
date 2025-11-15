package com.arkenna.indienest.backend.iam.domain.model.commands;

public record SignUpCommand(
        String name,
        String phoneNumber,
        String email,
        String password,
        String role
) {
}