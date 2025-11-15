package com.arkenna.indienest.backend.iam.interfaces.rest.resources;

public record CreateUserResource(
        String name,
        String phoneNumber
) {
}