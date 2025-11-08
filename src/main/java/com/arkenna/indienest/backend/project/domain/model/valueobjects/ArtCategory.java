package com.arkenna.indienest.backend.project.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * ArtCategory Value Object
 */
@Embeddable
public enum ArtCategory {
    PIXEL_ART,
    POSTER,
    FAN_ART,
    CHARACTER_DESIGN,
    CONCEPT_ART,
    BACKGROUND_DESIGN
}
