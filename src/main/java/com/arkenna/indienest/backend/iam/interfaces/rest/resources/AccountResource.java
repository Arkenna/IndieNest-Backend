package com.arkenna.indienest.backend.iam.interfaces.rest.resources;


public record AccountResource(
        Integer id,
        Integer userId,
        String email,
        String role,
        boolean isActive
) {
}
