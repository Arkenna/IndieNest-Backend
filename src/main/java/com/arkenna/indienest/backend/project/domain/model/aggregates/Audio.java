package com.arkenna.indienest.backend.project.domain.model.aggregates;

import com.arkenna.indienest.backend.project.domain.model.commands.CreateAudioCommand;
import com.arkenna.indienest.backend.project.domain.model.valueobjects.AudioCategory;
import com.arkenna.indienest.backend.project.domain.model.valueobjects.AudioFormat;
import com.arkenna.indienest.backend.project.domain.model.valueobjects.AudioUrl;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

/**
 * Audio Aggregate Root
 */
@Entity
@Getter
public class Audio extends Project {

    @Embedded
    private AudioUrl audioUrl;

    @Embedded
    private AudioFormat audioFormat;

    @Enumerated(EnumType.STRING)
    private AudioCategory category;

    /**
     * Default constructor
     */
    public Audio() {}

    /**
     * Constructor with a CreateAudioCommand
     * @param command The {@link CreateAudioCommand} instance
     */
    public Audio(CreateAudioCommand command){
        super(command.authorId(), command.name(), command.description(), command.rating(), command.image());
        this.audioUrl = new AudioUrl(command.audioUrl());
        this.audioFormat = new AudioFormat(command.audioFormat());
        this.category = AudioCategory.valueOf(command.category());
    }
}
