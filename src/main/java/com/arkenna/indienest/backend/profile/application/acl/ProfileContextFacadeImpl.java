package com.arkenna.indienest.backend.profile.application.acl;

import com.arkenna.indienest.backend.profile.domain.model.commands.CreatePortfolioCommand;
import com.arkenna.indienest.backend.profile.domain.model.commands.CreateProfileCommand;
import com.arkenna.indienest.backend.profile.domain.services.PortfolioCommandService;
import com.arkenna.indienest.backend.profile.domain.services.ProfileCommandService;
import com.arkenna.indienest.backend.profile.interfaces.acl.ProfileContextFacade;

public class ProfileContextFacadeImpl implements ProfileContextFacade {

    private final PortfolioCommandService portfolioCommandService;
    private final ProfileCommandService profileCommandService;

    public ProfileContextFacadeImpl(PortfolioCommandService portfolioCommandService, ProfileCommandService profileCommandService) {
        this.portfolioCommandService = portfolioCommandService;
        this.profileCommandService = profileCommandService;
    }

    public Integer createPortfolio(){
        var createPortfolioCommand = new CreatePortfolioCommand();
        var portfolio = portfolioCommandService.handle(createPortfolioCommand);
        return portfolio.isEmpty() ? 0 : portfolio.get().getId();
    }

    public Integer createProfile(String description, String image, Integer accountId, Integer PortfolioId){
        var createProfileCommand = new CreateProfileCommand(description, image, accountId, PortfolioId);
        var profile = profileCommandService.handle(createProfileCommand);
        return profile.isEmpty() ? 0 : profile.get().getId();
    }



}
