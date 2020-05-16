package org.bogatskaya.schedule.app.service;

import org.bogatskaya.schedule.app.domain.user.UserProfile;

import java.util.List;

public interface UserProfileService {

    List<UserProfile> findAll();

    UserProfile findOne(Long id);

    void save(UserProfile userProfile);

    void update(Long id, UserProfile userProfile);

    void delete(UserProfile userProfile);
}
