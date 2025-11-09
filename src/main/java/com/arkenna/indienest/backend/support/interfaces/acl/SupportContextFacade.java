package com.arkenna.indienest.backend.support.interfaces.acl;

public interface SupportContextFacade {

    Integer createReview(Integer userId, Integer projectId, String comment, Integer rating);
}
