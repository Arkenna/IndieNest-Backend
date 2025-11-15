package com.arkenna.indienest.backend.iam.application.internal.outboundservices.hashing;

public interface HashingService {
    String encode(String password);
    boolean matches(String rawPassword, String encodedPassword);
}