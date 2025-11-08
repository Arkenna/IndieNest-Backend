package com.arkenna.indienest.backend.project.interfaces.rest;

import com.arkenna.indienest.backend.project.domain.model.queries.GetAllGamesQuery;
import com.arkenna.indienest.backend.project.domain.model.queries.GetGameByIdQuery;
import com.arkenna.indienest.backend.project.domain.services.GameCommandService;
import com.arkenna.indienest.backend.project.domain.services.GameQueryService;
import com.arkenna.indienest.backend.project.interfaces.rest.resources.CreateGameResource;
import com.arkenna.indienest.backend.project.interfaces.rest.resources.GameResource;
import com.arkenna.indienest.backend.project.interfaces.rest.transform.CreateGameCommandFromResourceAssembler;
import com.arkenna.indienest.backend.project.interfaces.rest.transform.GameResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/games", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Games", description = "Available Game Endpoints")
public class GamesController {

    private final GameCommandService  gameCommandService;
    private final GameQueryService gameQueryService;

    /**
     * Constructor
     *
     * @param gameCommandService The {@link GameCommandService} instance
     * @param gameQueryService The {@link GameQueryService} instance
     */
    public GamesController(GameCommandService gameCommandService, GameQueryService gameQueryService) {
        this.gameCommandService = gameCommandService;
        this.gameQueryService = gameQueryService;
    }

    /**
     * Create a new game
     * @param resource The {@link CreateGameResource} instance
     * @return A {@link GameResource} resource for the created game, or a bad request response if the game could not be created.
     */
    @PostMapping
    @Operation(summary = "Create a new Game")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Game created"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    public ResponseEntity<GameResource> createGame(@RequestBody CreateGameResource resource){

        var createGameCommand = CreateGameCommandFromResourceAssembler.toCommandFromResource(resource);
        var game = gameCommandService.handle(createGameCommand);
        if(game.isEmpty()) return ResponseEntity.badRequest().build();
        var createdGame = game.get();
        var gameResource = GameResourceFromEntityAssembler.toResourceFromEntity(createdGame);
        return new  ResponseEntity<>(gameResource, HttpStatus.CREATED);
    }

    /**
     * Get a game by ID
     * @param gameId The game ID
     * @return A {@link GameResource} resource for the game, or a not found response if the game could not be found.
     */
    @GetMapping("/{gameId}")
    @Operation(summary = "Get a game by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Game found"),
            @ApiResponse(responseCode = "404", description = "Game not found")})
    public ResponseEntity<GameResource> getGameById(@PathVariable Integer gameId) {
        var getGameByIdQuery = new GetGameByIdQuery(gameId);
        var game = gameQueryService.handle(getGameByIdQuery);
        if (game.isEmpty()) return ResponseEntity.notFound().build();
        var gameEntity = game.get();
        var gameResource = GameResourceFromEntityAssembler.toResourceFromEntity(gameEntity);
        return ResponseEntity.ok(gameResource);
    }

    /**
     * Get all games
     * @return A list of {@link GameResource} resources for all games, or a not found response if no games are found.
     */
    @GetMapping
    @Operation(summary = "Get all games")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Games found"),
            @ApiResponse(responseCode = "404", description = "Games not found")})
    public ResponseEntity<List<GameResource>> getAllGames() {
        var games = gameQueryService.handle(new GetAllGamesQuery());
        if (games.isEmpty()) return ResponseEntity.notFound().build();
        var gameResources = games.stream()
                .map(GameResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(gameResources);
    }

}
