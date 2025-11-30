package com.arkenna.indienest.backend.project.application.internal.commandservices;

import com.arkenna.indienest.backend.project.domain.model.aggregates.Art;
import com.arkenna.indienest.backend.project.domain.model.commands.CreateArtCommand;
import com.arkenna.indienest.backend.project.domain.model.valueobjects.AccountId;
import com.arkenna.indienest.backend.project.domain.model.valueobjects.ProjectName;
import com.arkenna.indienest.backend.project.domain.services.ArtCommandService;
import com.arkenna.indienest.backend.project.infrastructure.persistence.jpa.respositories.ArtRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Art Command Service Implementation
 */
@Service
public class ArtCommandServiceImpl implements ArtCommandService {

    private final ArtRepository artRepository;

    /**
     * Constructor
     *
     * @param artRepository The {@link ArtRepository} instance
     */
    public ArtCommandServiceImpl(ArtRepository artRepository) {
        this.artRepository = artRepository;
    }

    // inherited javadoc
    @Override
    public Optional<Art> handle(CreateArtCommand command){
        var accountId = new AccountId(command.authorId());
        var projectName = new ProjectName(command.name());
        if(artRepository.existsByAccountIdAndName(accountId, projectName)){
            throw new IllegalArgumentException("Art with account id and name already exists");
        }
        var art = new Art(command);
        artRepository.save(art);
        return Optional.of(art);
    }

}
