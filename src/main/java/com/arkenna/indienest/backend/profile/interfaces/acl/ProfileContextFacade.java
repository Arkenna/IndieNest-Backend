package com.arkenna.indienest.backend.profile.interfaces.acl;

public interface ProfileContextFacade {

    Integer createPortfolio();

    Integer createProfile(String description, String image, Integer accountId, Integer PortfolioId);
}
