package com.arkenna.indienest.backend.iam.domain.services;

import com.arkenna.indienest.backend.iam.domain.model.commands.CreateAccountCommand;
import com.arkenna.indienest.backend.iam.domain.model.commands.SignInCommand;
import com.arkenna.indienest.backend.iam.domain.model.commands.SignUpCommand;


import java.util.Optional;

public interface AccountCommandService {

    Optional<Integer> handle(CreateAccountCommand command);
    Optional<Integer> handle(SignUpCommand command);
    Optional<String> handle(SignInCommand command);

}
