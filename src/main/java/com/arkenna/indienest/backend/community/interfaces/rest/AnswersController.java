package com.arkenna.indienest.backend.community.interfaces.rest;


import com.arkenna.indienest.backend.community.domain.model.queries.GetAllAnswersQuery;
import com.arkenna.indienest.backend.community.domain.model.queries.GetAnswerByIdQuery;
import com.arkenna.indienest.backend.community.domain.services.AnswerCommandService;
import com.arkenna.indienest.backend.community.domain.services.AnswerQueryService;
import com.arkenna.indienest.backend.community.interfaces.rest.resources.CreateAnswerResource;
import com.arkenna.indienest.backend.community.interfaces.rest.resources.AnswerResource;
import com.arkenna.indienest.backend.community.interfaces.rest.transform.CreateAnswerCommandFromResourceAssembler;
import com.arkenna.indienest.backend.community.interfaces.rest.transform.AnswerResourceFromEntityAssembler;
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
@RequestMapping(value = "/api/v1/answers", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Answers", description = "Available Answer Endpoints")
public class AnswersController {

    private final AnswerCommandService  answerCommandService;
    private final AnswerQueryService answerQueryService;

    /**
     * Constructor
     *
     * @param answerCommandService The {@link AnswerCommandService} instance
     * @param answerQueryService The {@link AnswerQueryService} instance
     */
    public AnswersController(AnswerCommandService answerCommandService, AnswerQueryService answerQueryService) {
        this.answerCommandService = answerCommandService;
        this.answerQueryService = answerQueryService;
    }

    /**
     * Create a new Answer
     * @param resource The {@link CreateAnswerResource} instance
     * @return A {@link AnswerResource} resource for the created Answer, or a bad request response if the Answer could not be created.
     */
    @PostMapping
    @Operation(summary = "Create a new Answer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Answer created"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    public ResponseEntity<AnswerResource> createAnswer(@RequestBody CreateAnswerResource resource){

        var createAnswerCommand = CreateAnswerCommandFromResourceAssembler.toCommandFromResource(resource);
        var answer = answerCommandService.handle(createAnswerCommand);
        if(answer.isEmpty()) return ResponseEntity.badRequest().build();
        var createdAnswer = answer.get();
        var answerResource = AnswerResourceFromEntityAssembler.toResourceFromEntity(createdAnswer);
        return new  ResponseEntity<>(answerResource, HttpStatus.CREATED);
    }

    /**
     * Get an Answer by ID
     * @param answerId The Answer ID
     * @return A {@link AnswerResource} resource for the Answer, or a not found response if the Answer could not be found.
     */
    @GetMapping("/{answerId}")
    @Operation(summary = "Get a Answer by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Answer found"),
            @ApiResponse(responseCode = "404", description = "Answer not found")})
    public ResponseEntity<AnswerResource> getAnswerById(@PathVariable Integer answerId) {
        var getAnswerByIdQuery = new GetAnswerByIdQuery(answerId);
        var answer = answerQueryService.handle(getAnswerByIdQuery);
        if (answer.isEmpty()) return ResponseEntity.notFound().build();
        var answerEntity = answer.get();
        var answerResource = AnswerResourceFromEntityAssembler.toResourceFromEntity(answerEntity);
        return ResponseEntity.ok(answerResource);
    }

    /**
     * Get all Answers
     * @return A list of {@link AnswerResource} resources for all Answers, or a not found response if no Answers are found.
     */
    @GetMapping
    @Operation(summary = "Get all Answers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Answers found"),
            @ApiResponse(responseCode = "404", description = "Answers not found")})
    public ResponseEntity<List<AnswerResource>> getAllAnswers() {
        var answers = answerQueryService.handle(new GetAllAnswersQuery());
        if (answers.isEmpty()) return ResponseEntity.notFound().build();
        var answerResources = answers.stream()
                .map(AnswerResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(answerResources);
    }

}
