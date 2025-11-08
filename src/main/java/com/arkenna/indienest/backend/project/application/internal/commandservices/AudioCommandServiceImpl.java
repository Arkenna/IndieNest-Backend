package com.arkenna.indienest.backend.project.application.internal.commandservices;

import com.arkenna.indienest.backend.project.domain.model.aggregates.Audio;
import com.arkenna.indienest.backend.project.domain.model.commands.CreateAudioCommand;
import com.arkenna.indienest.backend.project.domain.model.valueobjects.AccountId;
import com.arkenna.indienest.backend.project.domain.model.valueobjects.ProjectName;
import com.arkenna.indienest.backend.project.domain.services.AudioCommandService;
import com.arkenna.indienest.backend.project.infrastructure.persistence.jpa.respositories.AudioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Audio Command Service Implementation
 */
@Service
public class AudioCommandServiceImpl implements AudioCommandService {

    private final AudioRepository audioRepository;

    /**
     * Constructor
     *
     * @param audioRepository The {@link AudioRepository} instance
     */
    public AudioCommandServiceImpl(AudioRepository audioRepository) {
        this.audioRepository = audioRepository;
    }

    // inherited javadoc
    public Optional<Audio> handle(CreateAudioCommand command){
        var accountId = new AccountId(command.authorId());
        var projectName = new ProjectName(command.name());
        if(audioRepository.existsByAccountIdAndName(accountId, projectName)){
            throw new IllegalArgumentException("Game with account id and name already exists");
        }
        var audio = new Audio(command);
        audioRepository.save(audio);
        return Optional.of(audio);
    }

}
