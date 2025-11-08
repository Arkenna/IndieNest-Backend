package com.arkenna.indienest.backend.project.domain.services;

import com.arkenna.indienest.backend.project.domain.model.aggregates.Art;
import com.arkenna.indienest.backend.project.domain.model.queries.GetAllArtsQuery;
import com.arkenna.indienest.backend.project.domain.model.queries.GetArtByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ArtQueryService {
    
    /**
     * Handle Get All Arts Query
     *
     * @param query The {@link GetAllArtsQuery} Query
     * @return A List of {@link Art} instances
     */
    List<Art> handle(GetAllArtsQuery query);

    /**
     * Handle Get Art By Id Query
     *
     * @param query the {@link GetArtByIdQuery} Query
     * @return A {@link Art} instance if the query is valid, otherwise empty
     */
    Optional<Art> handle(GetArtByIdQuery query);
}
