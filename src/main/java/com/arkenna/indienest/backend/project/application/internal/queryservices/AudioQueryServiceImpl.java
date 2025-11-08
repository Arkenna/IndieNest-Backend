package com.arkenna.indienest.backend.project.application.internal.queryservices;

import com.arkenna.indienest.backend.project.domain.model.aggregates.Audio;
import com.arkenna.indienest.backend.project.domain.model.queries.GetAllAudiosQuery;
import com.arkenna.indienest.backend.project.domain.model.queries.GetAudioByIdQuery;
import com.arkenna.indienest.backend.project.domain.services.AudioQueryService;
import com.arkenna.indienest.backend.project.infrastructure.persistence.jpa.respositories.AudioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Audio Query Service Implementation
 */
@Service
public class AudioQueryServiceImpl implements AudioQueryService {

    private final AudioRepository audioRepository;

    /**
     * Constructor
     * @param audioRepository The {@link AudioRepository} instance
     */
    public AudioQueryServiceImpl(AudioRepository audioRepository) {
        this.audioRepository = audioRepository;
    }

    //inherited javadoc
    @Override
    public List<Audio> handle(GetAllAudiosQuery query){
        return audioRepository.findAll();
    }

    //inherited javadoc
    @Override
    public Optional<Audio> handle(GetAudioByIdQuery query){
        return audioRepository.findById(query.id());
    }

}
