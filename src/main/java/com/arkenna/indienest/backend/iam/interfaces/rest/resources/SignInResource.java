package com.arkenna.indienest.backend.iam.interfaces.rest.resources;

public record SignInResource(
        String email,
        String password
) {
}