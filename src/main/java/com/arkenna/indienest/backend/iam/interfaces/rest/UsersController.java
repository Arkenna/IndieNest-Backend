package com.arkenna.indienest.backend.iam.interfaces.rest;

import com.arkenna.indienest.backend.iam.domain.model.queries.GetAllUsersQuery;
import com.arkenna.indienest.backend.iam.domain.model.queries.GetUserByIdQuery;
import com.arkenna.indienest.backend.iam.domain.services.UserCommandService;
import com.arkenna.indienest.backend.iam.domain.services.UserQueryService;
import com.arkenna.indienest.backend.iam.interfaces.rest.resources.UpdateUserResource;
import com.arkenna.indienest.backend.iam.interfaces.rest.resources.UserResource;
import com.arkenna.indienest.backend.iam.interfaces.rest.transform.UpdateUserCommandFromResourceAssembler;
import com.arkenna.indienest.backend.iam.interfaces.rest.transform.UserResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Users", description = "Available User Endpoints")
public class UsersController {

    private final UserQueryService userQueryService;
    private final UserCommandService userCommandService;

    public UsersController(UserQueryService userQueryService, UserCommandService userCommandService) {
        this.userQueryService = userQueryService;
        this.userCommandService = userCommandService;
    }

    @GetMapping
    public ResponseEntity<List<UserResource>> getAllUsers() {
        var query = new GetAllUsersQuery();
        var users = userQueryService.handle(query);
        var userResources = users.stream()
                .map(UserResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(userResources);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResource> getUserById(@PathVariable Integer id) {
        var query = new GetUserByIdQuery(id);
        var user = userQueryService.handle(query);
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return ResponseEntity.ok(userResource);
    }


    @PutMapping("/{id}")
    public ResponseEntity<UserResource> updateUser(@PathVariable Integer id, @RequestBody UpdateUserResource resource) {
        var command = UpdateUserCommandFromResourceAssembler.toCommandFromResource(id, resource);
        var updatedUserId = userCommandService.handle(command);

        if (updatedUserId.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        var query = new GetUserByIdQuery(updatedUserId.get());
        var updatedUser = userQueryService.handle(query);

        if (updatedUser.isEmpty()) {
            return ResponseEntity.status(500).build();
        }

        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(updatedUser.get());
        return ResponseEntity.ok(userResource);
    }
}