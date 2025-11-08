package com.arkenna.indienest.backend.project.domain.services;

import com.arkenna.indienest.backend.project.domain.model.aggregates.Game;
import com.arkenna.indienest.backend.project.domain.model.queries.GetAllGamesQuery;
import com.arkenna.indienest.backend.project.domain.model.queries.GetGameByIdQuery;

import java.util.List;
import java.util.Optional;

/**
 * Game Query Service
 */
public interface GameQueryService {

    /**
     * Handle Get All Games Query
     *
     * @param query The {@link GetAllGamesQuery} Query
     * @return A List of {@link Game} instances
     */
    List<Game> handle(GetAllGamesQuery query);

    /**
     * Handle Get Game By Id Query
     *
     * @param query the {@link GetGameByIdQuery} Query
     * @return A {@link Game} instance if the query is valid, otherwise empty
     */
    Optional<Game> handle(GetGameByIdQuery query);
}
