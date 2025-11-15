package com.arkenna.indienest.backend.iam.domain.services;

import com.arkenna.indienest.backend.iam.domain.model.commands.CreateUserCommand;
import com.arkenna.indienest.backend.iam.domain.model.commands.UpdateUserCommand;

import java.util.Optional;

public interface UserCommandService {
    Optional<Integer> handle(CreateUserCommand command);
    Optional<Integer> handle(UpdateUserCommand command);

}
