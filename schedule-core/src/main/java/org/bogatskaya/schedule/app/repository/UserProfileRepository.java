package org.bogatskaya.schedule.app.repository;

import org.bogatskaya.schedule.app.domain.user.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile,Long>{
}
