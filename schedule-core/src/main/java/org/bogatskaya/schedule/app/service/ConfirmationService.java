package org.bogatskaya.schedule.app.service;

import org.bogatskaya.schedule.app.domain.Confirmation;

import java.util.List;
import java.util.Optional;

public interface ConfirmationService {

    List<Confirmation> findAll();

    Confirmation findOne(String token);

    Optional<Confirmation> findById(Long id);

    void save(Confirmation confirmation);

    void delete(Long id);
}
