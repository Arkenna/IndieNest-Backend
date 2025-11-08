package com.arkenna.indienest.backend.project.interfaces.acl;

import java.math.BigDecimal;

/**
 * Project Context Facade
 */
public interface ProjectContextFacade {

    /**
     * Create a new Game
     * @param accountId The Author Account Id
     * @param name The Project Name
     * @param description  The Project Description
     * @param rating The Project Rating
     * @param image The Project Image
     * @param price The Game Price
     * @param category The Game Category
     * @return The Game Id
     */
    Integer createGame(Integer accountId,
                       String name,
                       String description,
                       Integer rating,
                       String image,
                       BigDecimal price,
                       String category);

    /**
     * Create a new Art
     * @param authorId The Author Account Id
     * @param name The Project Name
     * @param description The Project Description
     * @param rating The Project Rating
     * @param image The Project Image
     * @param category The Art Category
     * @return The Art id
     */
    Integer createArt(Integer authorId,
                      String name,
                      String description,
                      Integer rating,
                      String image,
                      String category);

    /**
     *  Create a new Audio
     * @param authorId The Author Account Id
     * @param name The Project Name
     * @param description The Project Description
     * @param rating The Project Rating
     * @param image The Project Image
     * @param audioUrl The Audio Url
     * @param audioFormat The Audio Format
     * @param category The Audio Category
     * @return The Audio Id
     */
    Integer createAudio(Integer authorId,
                        String name,
                        String description,
                        Integer rating,
                        String image,
                        String audioUrl,
                        String audioFormat,
                        String category);
}
