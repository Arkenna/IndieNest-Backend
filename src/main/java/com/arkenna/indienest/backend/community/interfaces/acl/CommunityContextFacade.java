package com.arkenna.indienest.backend.community.interfaces.acl;

/**
 * Community Context Facade
 */
public interface CommunityContextFacade {

    /**
     * Create a new Publication
     * @param userId The Publication User Id
     * @param title The Publication Title
     * @param comment The Publication Comment
     * @param image The Publication Image
     * @return The Publication Id
     */
    Integer createPublication(Integer userId, String title, String comment, String image);

    /**
     * Create a new Answer
     * @param userId The Answer User Id
     * @param publicationId The Answer Publication Id
     * @param comment The Answer Comment
     * @return The Answer Id
     */
    Integer createAnswer(Integer userId, Integer publicationId, String comment);
}
