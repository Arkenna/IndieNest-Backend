package com.arkenna.indienest.backend.profile.application.internal.queryservices;

import com.arkenna.indienest.backend.profile.domain.model.aggregates.Profile;
import com.arkenna.indienest.backend.profile.domain.model.queries.GetAllProfilesQuery;
import com.arkenna.indienest.backend.profile.domain.model.queries.GetProfileByIdQuery;
import com.arkenna.indienest.backend.profile.domain.services.ProfileQueryService;
import com.arkenna.indienest.backend.profile.infrastructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileQueryServiceImpl implements ProfileQueryService {

    private final ProfileRepository profileRepository;

    public ProfileQueryServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public List<Profile> handle(GetAllProfilesQuery query){
        return this.profileRepository.findAll();
    }


    public Optional<Profile> handle(GetProfileByIdQuery query){
        return this.profileRepository.findById(query.id());
    }
}
