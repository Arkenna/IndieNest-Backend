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
import com.arkenna.indienest.backend.profile.domain.model.commands.CreateProfileCommand;
import com.arkenna.indienest.backend.profile.domain.model.commands.CreatePortfolioCommand;
import com.arkenna.indienest.backend.profile.domain.services.ProfileCommandService;
import com.arkenna.indienest.backend.profile.domain.services.PortfolioCommandService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/authentication", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Authentication", description = "Available Authentication Endpoints")
public class AuthenticationController {

    private final AccountCommandService accountCommandService;
    private final AccountRepository accountRepository;
    private final ProfileCommandService profileCommandService;
    private final PortfolioCommandService portfolioCommandService;

    public AuthenticationController(AccountCommandService accountCommandService,
                                    AccountRepository accountRepository,
                                    ProfileCommandService profileCommandService,
                                    PortfolioCommandService portfolioCommandService) {
        this.accountCommandService = accountCommandService;
        this.accountRepository = accountRepository;
        this.profileCommandService = profileCommandService;
        this.portfolioCommandService = portfolioCommandService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@RequestBody SignUpResource resource) {
        var command = SignUpCommandFromResourceAssembler.toCommandFromResource(resource);

        var accountId = accountCommandService.handle(command);

        if (accountId.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }


        try {
            var createPortfolioCommand = new CreatePortfolioCommand();
            var portfolioOptional = portfolioCommandService.handle(createPortfolioCommand);

            if (portfolioOptional.isPresent()) {
                Integer portfolioId = portfolioOptional.get().getId();
                var createProfileCommand = new CreateProfileCommand(
                        "Hi! I'm " + resource.name(),
                        null,
                        accountId.get(),
                        portfolioId
                );

                profileCommandService.handle(createProfileCommand);
                System.out.println("Profile created sucessfully.");
            }

        } catch (Exception e) {
            System.err.println("Error creating automatic profile: " + e.getMessage());
            e.printStackTrace();
        }

        return new ResponseEntity<>("Account created successfully", HttpStatus.CREATED);
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