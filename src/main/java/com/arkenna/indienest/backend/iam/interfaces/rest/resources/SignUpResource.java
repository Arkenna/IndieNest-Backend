package com.arkenna.indienest.backend.iam.interfaces.rest.resources;

public record SignUpResource(
        String name,
        String phoneNumber,
        String email,
        String password,
        String role
) {
}