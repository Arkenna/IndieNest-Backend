package com.arkenna.indienest.backend.community.interfaces.rest;


import com.arkenna.indienest.backend.community.domain.model.queries.GetAllPublicationsQuery;
import com.arkenna.indienest.backend.community.domain.model.queries.GetPublicationByIdQuery;
import com.arkenna.indienest.backend.community.domain.services.PublicationCommandService;
import com.arkenna.indienest.backend.community.domain.services.PublicationQueryService;
import com.arkenna.indienest.backend.community.interfaces.rest.resources.CreatePublicationResource;
import com.arkenna.indienest.backend.community.interfaces.rest.resources.PublicationResource;
import com.arkenna.indienest.backend.community.interfaces.rest.transform.CreatePublicationCommandFromResourceAssembler;
import com.arkenna.indienest.backend.community.interfaces.rest.transform.PublicationResourceFromEntityAssembler;
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
@RequestMapping(value = "/api/v1/publications", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Publications", description = "Available Publication Endpoints")
public class PublicationsController {

    private final PublicationCommandService  publicationCommandService;
    private final PublicationQueryService publicationQueryService;

    /**
     * Constructor
     *
     * @param publicationCommandService The {@link PublicationCommandService} instance
     * @param publicationQueryService The {@link PublicationQueryService} instance
     */
    public PublicationsController(PublicationCommandService publicationCommandService, PublicationQueryService publicationQueryService) {
        this.publicationCommandService = publicationCommandService;
        this.publicationQueryService = publicationQueryService;
    }

    /**
     * Create a new Publication
     * @param resource The {@link CreatePublicationResource} instance
     * @return A {@link PublicationResource} resource for the created Publication, or a bad request response if the Publication could not be created.
     */
    @PostMapping
    @Operation(summary = "Create a new Publication")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Publication created"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    public ResponseEntity<PublicationResource> createPublication(@RequestBody CreatePublicationResource resource){

        var createPublicationCommand = CreatePublicationCommandFromResourceAssembler.toCommandFromResource(resource);
        var publication = publicationCommandService.handle(createPublicationCommand);
        if(publication.isEmpty()) return ResponseEntity.badRequest().build();
        var createdPublication = publication.get();
        var publicationResource = PublicationResourceFromEntityAssembler.toResourceFromEntity(createdPublication);
        return new  ResponseEntity<>(publicationResource, HttpStatus.CREATED);
    }

    /**
     * Get a Publication by ID
     * @param publicationId The Publication ID
     * @return A {@link PublicationResource} resource for the Publication, or a not found response if the Publication could not be found.
     */
    @GetMapping("/{publicationId}")
    @Operation(summary = "Get a Publication by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Publication found"),
            @ApiResponse(responseCode = "404", description = "Publication not found")})
    public ResponseEntity<PublicationResource> getPublicationById(@PathVariable Integer publicationId) {
        var getPublicationByIdQuery = new GetPublicationByIdQuery(publicationId);
        var publication = publicationQueryService.handle(getPublicationByIdQuery);
        if (publication.isEmpty()) return ResponseEntity.notFound().build();
        var publicationEntity = publication.get();
        var publicationResource = PublicationResourceFromEntityAssembler.toResourceFromEntity(publicationEntity);
        return ResponseEntity.ok(publicationResource);
    }

    /**
     * Get all Publications
     * @return A list of {@link PublicationResource} resources for all Publications, or a not found response if no Publications are found.
     */
    @GetMapping
    @Operation(summary = "Get all Publications")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Publications found"),
            @ApiResponse(responseCode = "404", description = "Publications not found")})
    public ResponseEntity<List<PublicationResource>> getAllPublications() {
        var publications = publicationQueryService.handle(new GetAllPublicationsQuery());
        if (publications.isEmpty()) return ResponseEntity.notFound().build();
        var publicationResources = publications.stream()
                .map(PublicationResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(publicationResources);
    }

}
