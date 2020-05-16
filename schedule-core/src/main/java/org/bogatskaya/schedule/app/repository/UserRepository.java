package org.bogatskaya.schedule.app.repository;

import org.bogatskaya.schedule.app.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long>{

    Optional<User> findByLogin(final String login);
}
