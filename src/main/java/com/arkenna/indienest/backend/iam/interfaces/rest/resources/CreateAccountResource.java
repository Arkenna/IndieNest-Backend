package com.arkenna.indienest.backend.iam.interfaces.rest.resources;

public record CreateAccountResource(
        Integer userId,
        String email,
        String password,
        String role,
        boolean isActive
) {
}