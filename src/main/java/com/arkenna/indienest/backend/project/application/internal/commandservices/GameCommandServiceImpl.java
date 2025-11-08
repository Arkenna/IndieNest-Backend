package com.arkenna.indienest.backend.project.application.internal.commandservices;

import com.arkenna.indienest.backend.project.domain.model.aggregates.Game;
import com.arkenna.indienest.backend.project.domain.model.commands.CreateGameCommand;
import com.arkenna.indienest.backend.project.domain.model.valueobjects.AccountId;
import com.arkenna.indienest.backend.project.domain.model.valueobjects.ProjectName;
import com.arkenna.indienest.backend.project.domain.services.GameCommandService;
import com.arkenna.indienest.backend.project.infrastructure.persistence.jpa.respositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Game Command Service Implementation
 */
@Service
public class GameCommandServiceImpl implements GameCommandService {

    private final GameRepository gameRepository;

    /**
     * Constructor
     *
     * @param gameRepository The {@link GameRepository} instance
     */
    public GameCommandServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    // inherited javadoc
    @Override
    public Optional<Game> handle(CreateGameCommand command){
        var accountId = new AccountId(command.authorId());
        var projectName = new ProjectName(command.name());
        if(gameRepository.existsByAccountIdAndName(accountId, projectName)){
            throw new IllegalArgumentException("Game with account id and name already exists");
        }
        var game = new Game(command);
        gameRepository.save(game);
        return Optional.of(game);
    }

}
