package com.arkenna.indienest.backend.iam.interfaces.rest;

import com.arkenna.indienest.backend.iam.domain.model.valueobjects.Email;
import com.arkenna.indienest.backend.iam.domain.services.AccountCommandService;
import com.arkenna.indienest.backend.iam.infrastructure.persistence.jpa.repositories.AccountRepository;
import com.arkenna.indienest.backend.iam.interfaces.rest.resources.AuthenticatedAccountResource;
import com.arkenna.indienest.backend.iam.interfaces.rest.resources.SignInResource;
import com.arkenna.indienest.backend.iam.interfaces.rest.resources.SignUpResource;
import com.arkenna.indienest.backend.iam.interfaces.rest.transform.AuthenticatedAccountResourceFromEntityAssembler;
import com.arkenna.indienest.backend.iam.interfaces.rest.transform.SignInCommandFromResourceAssembler;
import com.arkenna.indienest.backend.iam.interfaces.rest.transform.SignUpCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/auth", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Authentication", description = "Available Authentication Endpoints")
public class AuthenticationController {

    private final AccountCommandService accountCommandService;
    private final AccountRepository accountRepository;

    public AuthenticationController(AccountCommandService accountCommandService, AccountRepository accountRepository) {
        this.accountCommandService = accountCommandService;
        this.accountRepository = accountRepository;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@RequestBody SignUpResource resource) {
        var command = SignUpCommandFromResourceAssembler.toCommandFromResource(resource);
        var userId = accountCommandService.handle(command);

        if (userId.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(userId.get().toString(), HttpStatus.CREATED);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<AuthenticatedAccountResource> signIn(@RequestBody SignInResource resource) {
        var command = SignInCommandFromResourceAssembler.toCommandFromResource(resource);
        var token = accountCommandService.handle(command);

        if (token.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        var accountOpt = accountRepository.findByEmail(new Email(resource.email()));

        if (accountOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        var authResource = AuthenticatedAccountResourceFromEntityAssembler.toResourceFromEntity(accountOpt.get(), token.get());
        return ResponseEntity.ok(authResource);
    }
}