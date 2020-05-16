package org.bogatskaya.schedule.app.service.impl;

import org.bogatskaya.schedule.app.domain.Confirmation;
import org.bogatskaya.schedule.app.exception.NotFoundException;
import org.bogatskaya.schedule.app.repository.ConfirmationRepository;
import org.bogatskaya.schedule.app.service.ConfirmationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConfirmationServiceImpl implements ConfirmationService{

    private ConfirmationRepository confirmationRepository;

    @Autowired
    public ConfirmationServiceImpl(ConfirmationRepository confirmationRepository) {
        this.confirmationRepository = confirmationRepository;
    }

    @Override
    public List<Confirmation> findAll() {
        return confirmationRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        confirmationRepository.deleteById(id);
    }

    @Override
    public Optional<Confirmation> findById(Long id) {
        return confirmationRepository.findById(id);
    }

    @Override
    public Confirmation findOne(String token) {
        return findAll()
                .stream()
                .filter(c -> token.equals(c.getToken()))
                .findAny()
                .orElseThrow(() -> new NotFoundException("No confirmation instance with token:", token));
    }

    @Override
    public void save(Confirmation confirmation) {
        if(confirmation != null) {
            confirmationRepository.save(confirmation);
        }
    }
}
