package com.arkenna.indienest.backend.iam.interfaces.rest.resources;

public record UpdateUserResource(
        String name,
        String phoneNumber
) {
}