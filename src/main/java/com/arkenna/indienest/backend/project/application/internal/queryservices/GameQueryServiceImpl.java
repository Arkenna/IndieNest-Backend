package com.arkenna.indienest.backend.project.application.internal.queryservices;

import com.arkenna.indienest.backend.project.domain.model.aggregates.Game;
import com.arkenna.indienest.backend.project.domain.model.queries.GetAllGamesQuery;
import com.arkenna.indienest.backend.project.domain.model.queries.GetGameByIdQuery;
import com.arkenna.indienest.backend.project.domain.services.GameQueryService;
import com.arkenna.indienest.backend.project.infrastructure.persistence.jpa.respositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Game Query Service Implementation
 */
@Service
public class GameQueryServiceImpl implements GameQueryService {

    private final GameRepository gameRepository;

    /**
     * Constructor
     * @param gameRepository The {@link GameRepository} instance
     */
    public GameQueryServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    // inherited javadoc
    @Override
    public List<Game> handle(GetAllGamesQuery query){
        return gameRepository.findAll();
    }

    //inherited javadoc
    @Override
    public Optional<Game> handle(GetGameByIdQuery query){
        return gameRepository.findById(query.id());
    }
}
