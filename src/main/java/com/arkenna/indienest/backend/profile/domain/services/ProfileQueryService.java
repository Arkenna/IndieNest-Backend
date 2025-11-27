package com.arkenna.indienest.backend.profile.domain.services;

import com.arkenna.indienest.backend.profile.domain.model.aggregates.Profile;
import com.arkenna.indienest.backend.profile.domain.model.queries.GetAllProfilesQuery;
import com.arkenna.indienest.backend.profile.domain.model.queries.GetProfileByIdQuery;

import java.util.List;
import java.util.Optional;

/**
 * Profile Query Service
 */
public interface ProfileQueryService {

    /**
     * Handle Get All Profiles Query
     * @param query The {@link GetAllProfilesQuery} query
     * @return A List of {@link Profile} instances
     */
    List<Profile> handle(GetAllProfilesQuery query);

    /**
     * Handle Get Profile By ID Query
     * @param query The {@link GetProfileByIdQuery} query
     * @return A {@link Profile} instance
     */
    Optional<Profile> handle(GetProfileByIdQuery query);
}
