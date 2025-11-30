package com.arkenna.indienest.backend.profile.application.internal.commandservices;

import com.arkenna.indienest.backend.profile.domain.model.aggregates.Profile;
import com.arkenna.indienest.backend.profile.domain.model.commands.CreateProfileCommand;
import com.arkenna.indienest.backend.profile.domain.model.valueobjects.AccountId;
import com.arkenna.indienest.backend.profile.domain.services.ProfileCommandService;
import com.arkenna.indienest.backend.profile.infrastructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileCommandServiceImpl implements ProfileCommandService {

    private final ProfileRepository profileRepository;

    public ProfileCommandServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Optional<Profile> handle(CreateProfileCommand command){

        var accountId = new AccountId(command.accountId());
        if(profileRepository.existsByAccountId(accountId)){
            throw new IllegalArgumentException("Profile with same account ID already exists");
        }

        var profile = new Profile(command);
        profileRepository.save(profile);
        return Optional.of(profile);
    }
}
