package com.arkenna.indienest.backend.project.interfaces.rest;


import com.arkenna.indienest.backend.project.domain.model.queries.GetAllAudiosQuery;
import com.arkenna.indienest.backend.project.domain.model.queries.GetAudioByIdQuery;
import com.arkenna.indienest.backend.project.domain.services.AudioCommandService;
import com.arkenna.indienest.backend.project.domain.services.AudioQueryService;
import com.arkenna.indienest.backend.project.interfaces.rest.resources.CreateAudioResource;
import com.arkenna.indienest.backend.project.interfaces.rest.resources.AudioResource;
import com.arkenna.indienest.backend.project.interfaces.rest.transform.CreateAudioCommandFromResourceAssembler;
import com.arkenna.indienest.backend.project.interfaces.rest.transform.AudioResourceFromEntityAssembler;
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
@RequestMapping(value = "/api/v1/audios", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Audios", description = "Available Audio Endpoints")
public class AudiosController {

    private final AudioCommandService  audioCommandService;
    private final AudioQueryService audioQueryService;

    /**
     * Constructor
     *
     * @param audioCommandService The {@link AudioCommandService} instance
     * @param audioQueryService The {@link AudioQueryService} instance
     */
    public AudiosController(AudioCommandService audioCommandService, AudioQueryService audioQueryService) {
        this.audioCommandService = audioCommandService;
        this.audioQueryService = audioQueryService;
    }

    /**
     * Create a new audio
     * @param resource The {@link CreateAudioResource} instance
     * @return A {@link AudioResource} resource for the created audio, or a bad request response if the audio could not be created.
     */
    @PostMapping
    @Operation(summary = "Create a new Audio")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Audio created"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    public ResponseEntity<AudioResource> createAudio(@RequestBody CreateAudioResource resource){

        var createAudioCommand = CreateAudioCommandFromResourceAssembler.toCommandFromResource(resource);
        var audio = audioCommandService.handle(createAudioCommand);
        if(audio.isEmpty()) return ResponseEntity.badRequest().build();
        var createdAudio = audio.get();
        var audioResource = AudioResourceFromEntityAssembler.toResourceFromEntity(createdAudio);
        return new  ResponseEntity<>(audioResource, HttpStatus.CREATED);
    }

    /**
     * Get an audio by ID
     * @param audioId The audio ID
     * @return A {@link AudioResource} resource for the audio, or a not found response if the audio could not be found.
     */
    @GetMapping("/{audioId}")
    @Operation(summary = "Get a audio by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Audio found"),
            @ApiResponse(responseCode = "404", description = "Audio not found")})
    public ResponseEntity<AudioResource> getAudioById(@PathVariable Integer audioId) {
        var getAudioByIdQuery = new GetAudioByIdQuery(audioId);
        var audio = audioQueryService.handle(getAudioByIdQuery);
        if (audio.isEmpty()) return ResponseEntity.notFound().build();
        var audioEntity = audio.get();
        var audioResource = AudioResourceFromEntityAssembler.toResourceFromEntity(audioEntity);
        return ResponseEntity.ok(audioResource);
    }

    /**
     * Get all audios
     * @return A list of {@link AudioResource} resources for all audios, or a not found response if no audios are found.
     */
    @GetMapping
    @Operation(summary = "Get all audios")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Audios found"),
            @ApiResponse(responseCode = "404", description = "Audios not found")})
    public ResponseEntity<List<AudioResource>> getAllAudios() {
        var audios = audioQueryService.handle(new GetAllAudiosQuery());
        if (audios.isEmpty()) return ResponseEntity.notFound().build();
        var audioResources = audios.stream()
                .map(AudioResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(audioResources);
    }

}

