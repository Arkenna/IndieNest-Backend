package com.arkenna.indienest.backend.project.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * AudioCategory Value Object
 */
@Embeddable
public enum AudioCategory {
    SOUNDTRACK,
    INSTRUMENTAL,
    VOICE_ACTING,
    SOUND_EFFECT,
    OTHER
}
