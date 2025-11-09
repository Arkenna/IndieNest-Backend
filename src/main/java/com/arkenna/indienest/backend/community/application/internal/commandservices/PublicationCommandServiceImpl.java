package com.arkenna.indienest.backend.community.application.internal.commandservices;

import com.arkenna.indienest.backend.community.domain.model.aggregates.Publication;
import com.arkenna.indienest.backend.community.domain.model.commands.CreatePublicationCommand;
import com.arkenna.indienest.backend.community.domain.model.valueobjects.PublicationTitle;
import com.arkenna.indienest.backend.community.domain.model.valueobjects.UserId;
import com.arkenna.indienest.backend.community.domain.services.PublicationCommandService;
import com.arkenna.indienest.backend.community.infrastructure.persistence.jpa.repositories.PublicationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Publication Command Service Implementation
 */
@Service
public class PublicationCommandServiceImpl implements PublicationCommandService {

    private final PublicationRepository PublicationRepository;

    /**
     * Constructor
     * @param PublicationRepository The {@link PublicationRepository} instance
     */
    public PublicationCommandServiceImpl(PublicationRepository PublicationRepository) {
        this.PublicationRepository = PublicationRepository;
    }

    // inherited javadoc
    @Override
    public Optional<Publication> handle(CreatePublicationCommand command){

        var userId = new UserId(command.userId());
        var title = new PublicationTitle(command.title());
        if(PublicationRepository.existsByUserIdAndTitle(userId, title)){
            throw new IllegalArgumentException("Publication with userId and title already exists");
        }
        var Publication = new Publication(command);
        PublicationRepository.save(Publication);
        return Optional.of(Publication);
    }
}
