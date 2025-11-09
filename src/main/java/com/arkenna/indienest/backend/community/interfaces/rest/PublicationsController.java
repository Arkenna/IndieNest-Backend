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
@RequestMapping(value = "/api/v1/Publications", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Publications", description = "Available Publication Endpoints")
public class PublicationsController {

    private final PublicationCommandService  PublicationCommandService;
    private final PublicationQueryService PublicationQueryService;

    /**
     * Constructor
     *
     * @param PublicationCommandService The {@link PublicationCommandService} instance
     * @param PublicationQueryService The {@link PublicationQueryService} instance
     */
    public PublicationsController(PublicationCommandService PublicationCommandService, PublicationQueryService PublicationQueryService) {
        this.PublicationCommandService = PublicationCommandService;
        this.PublicationQueryService = PublicationQueryService;
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
        var Publication = PublicationCommandService.handle(createPublicationCommand);
        if(Publication.isEmpty()) return ResponseEntity.badRequest().build();
        var createdPublication = Publication.get();
        var PublicationResource = PublicationResourceFromEntityAssembler.toResourceFromEntity(createdPublication);
        return new  ResponseEntity<>(PublicationResource, HttpStatus.CREATED);
    }

    /**
     * Get an Publication by ID
     * @param PublicationId The Publication ID
     * @return A {@link PublicationResource} resource for the Publication, or a not found response if the Publication could not be found.
     */
    @GetMapping("/{PublicationId}")
    @Operation(summary = "Get a Publication by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Publication found"),
            @ApiResponse(responseCode = "404", description = "Publication not found")})
    public ResponseEntity<PublicationResource> getPublicationById(@PathVariable Integer PublicationId) {
        var getPublicationByIdQuery = new GetPublicationByIdQuery(PublicationId);
        var Publication = PublicationQueryService.handle(getPublicationByIdQuery);
        if (Publication.isEmpty()) return ResponseEntity.notFound().build();
        var PublicationEntity = Publication.get();
        var PublicationResource = PublicationResourceFromEntityAssembler.toResourceFromEntity(PublicationEntity);
        return ResponseEntity.ok(PublicationResource);
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
        var Publications = PublicationQueryService.handle(new GetAllPublicationsQuery());
        if (Publications.isEmpty()) return ResponseEntity.notFound().build();
        var PublicationResources = Publications.stream()
                .map(PublicationResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(PublicationResources);
    }

}
