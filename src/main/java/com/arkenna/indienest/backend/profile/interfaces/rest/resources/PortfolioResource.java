package com.arkenna.indienest.backend.profile.interfaces.rest.resources;

import java.util.List;

public record PortfolioResource(
        Integer id,
        List<PortfolioGameResource> games,
        List<PortfolioAudioResource> audios,
        List<PortfolioArtResource> arts) {
}
