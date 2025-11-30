package com.arkenna.indienest.backend.iam.application.internal.queryservices;

import com.arkenna.indienest.backend.iam.domain.model.aggregates.User;
import com.arkenna.indienest.backend.iam.domain.model.queries.GetAllUsersQuery;
import com.arkenna.indienest.backend.iam.domain.model.queries.GetUserByIdQuery;
import com.arkenna.indienest.backend.iam.domain.services.UserQueryService;
import com.arkenna.indienest.backend.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> handle(GetUserByIdQuery query) {
        return userRepository.findById(query.id());
    }

    @Override
    public List<User> handle(GetAllUsersQuery query) {
        return userRepository.findAll();
    }
}