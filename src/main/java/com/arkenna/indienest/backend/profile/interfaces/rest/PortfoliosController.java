package com.arkenna.indienest.backend.profile.interfaces.rest;


import com.arkenna.indienest.backend.profile.domain.model.queries.GetAllPortfoliosQuery;
import com.arkenna.indienest.backend.profile.domain.model.queries.GetPortfolioByIdQuery;
import com.arkenna.indienest.backend.profile.domain.services.PortfolioCommandService;
import com.arkenna.indienest.backend.profile.domain.services.PortfolioQueryService;
import com.arkenna.indienest.backend.profile.interfaces.rest.resources.*;
import com.arkenna.indienest.backend.profile.interfaces.rest.transform.*;
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
@RequestMapping(value = "/api/v1/portfolios", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Portfolios", description = "Available Portfolio Endpoints")
public class PortfoliosController {

    private final PortfolioCommandService portfolioCommandService;
    private final PortfolioQueryService portfolioQueryService;

    /**
     * Constructor
     *
     * @param portfolioCommandService The {@link PortfolioCommandService} instance
     * @param portfolioQueryService The {@link PortfolioQueryService} instance
     */
    public PortfoliosController(PortfolioCommandService portfolioCommandService, PortfolioQueryService portfolioQueryService) {
        this.portfolioCommandService = portfolioCommandService;
        this.portfolioQueryService = portfolioQueryService;
    }

    /**
     * Create a new Portfolio
     * @param resource The {@link CreatePortfolioResource} instance
     * @return A {@link PortfolioResource} resource for the created Portfolio, or a bad request response if the Portfolio could not be created.
     */
    @PostMapping
    @Operation(summary = "Create a new Portfolio")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Portfolio created"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    public ResponseEntity<PortfolioResource> createPortfolio(@RequestBody CreatePortfolioResource resource){

        var createPortfolioCommand = CreatePortfolioCommandFromResourceAssembler.toCommandFromResource(resource);
        var portfolio = portfolioCommandService.handle(createPortfolioCommand);
        if(portfolio.isEmpty()) return ResponseEntity.badRequest().build();
        var createdPortfolio = portfolio.get();
        var portfolioResource = PortfolioResourceFromEntityAssembler.toResourceFromEntity(createdPortfolio);
        return new  ResponseEntity<>(portfolioResource, HttpStatus.CREATED);
    }

    /**
     * Get a Portfolio by ID
     * @param portfolioId The Portfolio ID
     * @return A {@link PortfolioResource} resource for the Portfolio, or a not found response if the Portfolio could not be found.
     */
    @GetMapping("/{portfolioId}")
    @Operation(summary = "Get a Portfolio by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Portfolio found"),
            @ApiResponse(responseCode = "404", description = "Portfolio not found")})
    public ResponseEntity<PortfolioResource> getPortfolioById(@PathVariable Integer portfolioId) {
        var getPortfolioByIdQuery = new GetPortfolioByIdQuery(portfolioId);
        var portfolio = portfolioQueryService.handle(getPortfolioByIdQuery);
        if (portfolio.isEmpty()) return ResponseEntity.notFound().build();
        var PortfolioEntity = portfolio.get();
        var portfolioResource = PortfolioResourceFromEntityAssembler.toResourceFromEntity(PortfolioEntity);
        return ResponseEntity.ok(portfolioResource);
    }

    /**
     * Get all Portfolios
     * @return A list of {@link PortfolioResource} resources for all Portfolios, or a not found response if no Portfolios are found.
     */
    @GetMapping
    @Operation(summary = "Get all Portfolios")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Portfolios found"),
            @ApiResponse(responseCode = "404", description = "Portfolios not found")})
    public ResponseEntity<List<PortfolioResource>> getAllPortfolios() {
        var portfolios = portfolioQueryService.handle(new GetAllPortfoliosQuery());
        if (portfolios.isEmpty()) return ResponseEntity.notFound().build();
        var portfolioResources = portfolios.stream()
                .map(PortfolioResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(portfolioResources);
    }


    @PutMapping("/add-game")
    @Operation(summary = "Add a game to a Portfolio")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Portfolio updated"),
            @ApiResponse(responseCode = "400", description = "Bad Request")})
    public ResponseEntity<PortfolioResource> addGameToCart(@RequestBody AddGameToPortfolioResource resource) {

        var command = AddGameToPortfolioCommandFromResourceAssembler.toCommandFromResource(resource);
        var portfolio = portfolioCommandService.handle(command);
        if(portfolio.isEmpty()) return ResponseEntity.badRequest().build();
        var createdPortfolio = portfolio.get();
        var portfolioResource = PortfolioResourceFromEntityAssembler.toResourceFromEntity(createdPortfolio);

        return ResponseEntity.ok(portfolioResource);
    }

    @PutMapping("/add-audio")
    @Operation(summary = "Add an audio to a Portfolio")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Portfolio updated"),
            @ApiResponse(responseCode = "400", description = "Bad Request")})
    public ResponseEntity<PortfolioResource> addGameToCart(@RequestBody AddAudioToPortfolioResource resource) {

        var command = AddAudioToPortfolioCommandFromResourceAssembler.toCommandFromResource(resource);
        var portfolio = portfolioCommandService.handle(command);
        if(portfolio.isEmpty()) return ResponseEntity.badRequest().build();
        var createdPortfolio = portfolio.get();
        var portfolioResource = PortfolioResourceFromEntityAssembler.toResourceFromEntity(createdPortfolio);

        return ResponseEntity.ok(portfolioResource);
    }

    @PutMapping("/add-art")
    @Operation(summary = "Add an art to a Portfolio")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Portfolio updated"),
            @ApiResponse(responseCode = "400", description = "Bad Request")})
    public ResponseEntity<PortfolioResource> addGameToCart(@RequestBody AddArtToPortfolioResource resource) {

        var command = AddArtToPortfolioCommandFromResourceAssembler.toCommandFromResource(resource);
        var portfolio = portfolioCommandService.handle(command);
        if(portfolio.isEmpty()) return ResponseEntity.badRequest().build();
        var createdPortfolio = portfolio.get();
        var portfolioResource = PortfolioResourceFromEntityAssembler.toResourceFromEntity(createdPortfolio);

        return ResponseEntity.ok(portfolioResource);
    }


    
}

