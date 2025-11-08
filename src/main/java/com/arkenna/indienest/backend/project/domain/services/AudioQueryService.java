package com.arkenna.indienest.backend.project.domain.services;

import com.arkenna.indienest.backend.project.domain.model.aggregates.Audio;
import com.arkenna.indienest.backend.project.domain.model.queries.GetAllAudiosQuery;
import com.arkenna.indienest.backend.project.domain.model.queries.GetAudioByIdQuery;

import java.util.List;
import java.util.Optional;

/**
 * Audio Query Service
 */
public interface AudioQueryService {

    /**
     * Handle Get All Audios Query
     *
     * @param query The {@link GetAllAudiosQuery} Query
     * @return A List of {@link Audio} instances
     */
    List<Audio> handle(GetAllAudiosQuery query);

    /**
     * Handle Get Audio By Id Query
     *
     * @param query the {@link GetAudioByIdQuery} Query
     * @return A {@link Audio} instance if the query is valid, otherwise empty
     */
    Optional<Audio> handle(GetAudioByIdQuery query);
}
