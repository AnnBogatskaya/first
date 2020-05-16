package org.bogatskaya.schedule.app.repository;

import org.bogatskaya.schedule.app.domain.Confirmation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConfirmationRepository extends JpaRepository<Confirmation, Long>{

    @Override
    Optional<Confirmation> findById(Long id);
}
