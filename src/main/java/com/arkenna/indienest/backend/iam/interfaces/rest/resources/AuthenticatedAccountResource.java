package com.arkenna.indienest.backend.iam.interfaces.rest.resources;

public record AuthenticatedAccountResource(
        Integer id,
        Integer userId,
        String email,
        String role,
        String token
) {
}