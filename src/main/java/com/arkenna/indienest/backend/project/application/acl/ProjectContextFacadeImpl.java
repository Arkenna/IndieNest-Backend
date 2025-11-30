package com.arkenna.indienest.backend.project.application.acl;

import com.arkenna.indienest.backend.project.domain.model.commands.CreateArtCommand;
import com.arkenna.indienest.backend.project.domain.model.commands.CreateAudioCommand;
import com.arkenna.indienest.backend.project.domain.model.commands.CreateGameCommand;
import com.arkenna.indienest.backend.project.domain.services.ArtCommandService;
import com.arkenna.indienest.backend.project.domain.services.AudioCommandService;
import com.arkenna.indienest.backend.project.domain.services.GameCommandService;
import com.arkenna.indienest.backend.project.interfaces.acl.ProjectContextFacade;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProjectContextFacadeImpl implements ProjectContextFacade {

    private final GameCommandService gameCommandService;
    private final AudioCommandService audioCommandService;
    private final ArtCommandService artCommandService;

    public ProjectContextFacadeImpl(GameCommandService gameCommandService,
                                    AudioCommandService audioCommandService,
                                    ArtCommandService artCommandService) {
        this.gameCommandService = gameCommandService;
        this.audioCommandService = audioCommandService;
        this.artCommandService = artCommandService;
    }

    public Integer createGame(Integer accountId,
                                  String name,
                                  String description,
                                  Integer rating,
                                  String image,
                                  BigDecimal price,
                                  String category){

        var createGameCommand = new CreateGameCommand(
                accountId,
                name,
                description,
                rating,
                image,
                category,
                price);

        var game = gameCommandService.handle(createGameCommand);
        return game.isEmpty() ? 0 : game.get().getId();
    }

    public Integer createArt(Integer accountId,
                             String name,
                             String description,
                             Integer rating,
                             String image,
                             String category){
        var createArtCommand = new CreateArtCommand(accountId,
                name,
                description,
                rating,
                image,
                category);

        var art = artCommandService.handle(createArtCommand);
        return art.isEmpty() ? 0 : art.get().getId();
    }

    public Integer createAudio(Integer accountId,
                               String name,
                               String description,
                               Integer rating,
                               String image,
                               String audioUrl,
                               String audioFormat,
                               String category){
        var createAudioCommand = new CreateAudioCommand(accountId,
                name,
                description,
                rating,
                image,
                category,
                audioUrl,
                audioFormat);

        var audio = audioCommandService.handle(createAudioCommand);
        return audio.isEmpty() ? 0 : audio.get().getId();
    }

}
