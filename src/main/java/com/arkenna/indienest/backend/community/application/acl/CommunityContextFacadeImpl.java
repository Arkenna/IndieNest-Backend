package com.arkenna.indienest.backend.community.application.acl;

import com.arkenna.indienest.backend.community.domain.model.commands.CreateAnswerCommand;
import com.arkenna.indienest.backend.community.domain.model.commands.CreatePublicationCommand;
import com.arkenna.indienest.backend.community.domain.services.AnswerCommandService;
import com.arkenna.indienest.backend.community.domain.services.PublicationCommandService;
import com.arkenna.indienest.backend.community.interfaces.acl.CommunityContextFacade;
import org.springframework.stereotype.Service;

@Service
public class CommunityContextFacadeImpl implements CommunityContextFacade {

    private final AnswerCommandService answerCommandService;
    private final PublicationCommandService publicationCommandService;

    public CommunityContextFacadeImpl(AnswerCommandService answerCommandService, PublicationCommandService publicationCommandService) {
        this.answerCommandService = answerCommandService;
        this.publicationCommandService = publicationCommandService;
    }

    public Integer createPublication(Integer userId, String title, String comment, String image){

        var createPublicationCommand = new CreatePublicationCommand(userId, title, comment, image);
        var publication = publicationCommandService.handle(createPublicationCommand);
        return publication.isEmpty() ? 0 : publication.get().getId();
    }

    public Integer createAnswer(Integer userId, Integer publicationId, String comment){

        var createAnswerCommand = new CreateAnswerCommand(userId, publicationId, comment);
        var answer = answerCommandService.handle(createAnswerCommand);
        return answer.isEmpty() ? 0 : answer.get().getId();
    }

}
