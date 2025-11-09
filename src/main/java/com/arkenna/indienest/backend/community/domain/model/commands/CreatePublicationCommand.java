package com.arkenna.indienest.backend.community.domain.model.commands;

/**
 * Create Publication Command
 * @param userId User Id
 * @param title Publication Title
 * @param comment Publication Comment
 * @param image Publication Image
 */
public record CreatePublicationCommand(Integer userId, String title, String comment, String image) {
}
