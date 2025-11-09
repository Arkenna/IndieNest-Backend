package com.arkenna.indienest.backend.support.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Project ID Value Object
 */
@Embeddable
public record ProjectId(Integer projectId) {

    public ProjectId {
        if (projectId == null || projectId < 1)
            throw new IllegalArgumentException("Project Id cannot be null or less than 1");
    }
}
