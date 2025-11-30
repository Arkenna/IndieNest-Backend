package com.arkenna.indienest.backend.project.interfaces.rest;


import com.arkenna.indienest.backend.project.domain.model.queries.GetAllArtsQuery;
import com.arkenna.indienest.backend.project.domain.model.queries.GetArtByIdQuery;
import com.arkenna.indienest.backend.project.domain.services.ArtCommandService;
import com.arkenna.indienest.backend.project.domain.services.ArtQueryService;
import com.arkenna.indienest.backend.project.interfaces.rest.resources.CreateArtResource;
import com.arkenna.indienest.backend.project.interfaces.rest.resources.ArtResource;
import com.arkenna.indienest.backend.project.interfaces.rest.transform.CreateArtCommandFromResourceAssembler;
import com.arkenna.indienest.backend.project.interfaces.rest.transform.ArtResourceFromEntityAssembler;
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
@RequestMapping(value = "/api/v1/arts", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Arts", description = "Available Art Endpoints")
public class ArtsController {

    private final ArtCommandService  artCommandService;
    private final ArtQueryService artQueryService;

    /**
     * Constructor
     *
     * @param artCommandService The {@link ArtCommandService} instance
     * @param artQueryService The {@link ArtQueryService} instance
     */
    public ArtsController(ArtCommandService artCommandService, ArtQueryService artQueryService) {
        this.artCommandService = artCommandService;
        this.artQueryService = artQueryService;
    }

    /**
     * Create a new art
     * @param resource The {@link CreateArtResource} instance
     * @return A {@link ArtResource} resource for the created art, or a bad request response if the art could not be created.
     */
    @PostMapping
    @Operation(summary = "Create a new Art")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Art created"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    public ResponseEntity<ArtResource> createArt(@RequestBody CreateArtResource resource){

        var createArtCommand = CreateArtCommandFromResourceAssembler.toCommandFromResource(resource);
        var art = artCommandService.handle(createArtCommand);
        if(art.isEmpty()) return ResponseEntity.badRequest().build();
        var createdArt = art.get();
        var artResource = ArtResourceFromEntityAssembler.toResourceFromEntity(createdArt);
        return new  ResponseEntity<>(artResource, HttpStatus.CREATED);
    }

    /**
     * Get an art by ID
     * @param artId The art ID
     * @return A {@link ArtResource} resource for the art, or a not found response if the art could not be found.
     */
    @GetMapping("/{artId}")
    @Operation(summary = "Get a art by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Art found"),
            @ApiResponse(responseCode = "404", description = "Art not found")})
    public ResponseEntity<ArtResource> getArtById(@PathVariable Integer artId) {
        var getArtByIdQuery = new GetArtByIdQuery(artId);
        var art = artQueryService.handle(getArtByIdQuery);
        if (art.isEmpty()) return ResponseEntity.notFound().build();
        var artEntity = art.get();
        var artResource = ArtResourceFromEntityAssembler.toResourceFromEntity(artEntity);
        return ResponseEntity.ok(artResource);
    }

    /**
     * Get all arts
     * @return A list of {@link ArtResource} resources for all arts, or a not found response if no arts are found.
     */
    @GetMapping
    @Operation(summary = "Get all arts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Arts found"),
            @ApiResponse(responseCode = "404", description = "Arts not found")})
    public ResponseEntity<List<ArtResource>> getAllArts() {
        var arts = artQueryService.handle(new GetAllArtsQuery());
        if (arts.isEmpty()) return ResponseEntity.notFound().build();
        var artResources = arts.stream()
                .map(ArtResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(artResources);
    }

}
