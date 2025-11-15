package com.arkenna.indienest.backend.iam.interfaces.rest.resources;

public record UserResource(
        Integer id,
        String name,
        String phoneNumber
) {
}