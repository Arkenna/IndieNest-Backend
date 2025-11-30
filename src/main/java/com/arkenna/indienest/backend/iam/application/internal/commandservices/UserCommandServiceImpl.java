package com.arkenna.indienest.backend.iam.application.internal.commandservices;

import com.arkenna.indienest.backend.iam.domain.model.aggregates.User;
import com.arkenna.indienest.backend.iam.domain.model.commands.CreateUserCommand;
import com.arkenna.indienest.backend.iam.domain.model.commands.UpdateUserCommand;
import com.arkenna.indienest.backend.iam.domain.services.UserCommandService;
import com.arkenna.indienest.backend.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;

    public UserCommandServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Integer> handle(CreateUserCommand command) {
        var user = new User(command);
        var createdUser = userRepository.save(user);
        return Optional.of(createdUser.getId());
    }

    @Override
    public Optional<Integer> handle(UpdateUserCommand command) {
        return userRepository.findById(command.id()).map(user -> {
            user.updateName(command.name());
            user.updatePhoneNumber(command.phoneNumber());
            userRepository.save(user);
            return Optional.of(user.getId());
        }).orElse(Optional.empty());
    }
}