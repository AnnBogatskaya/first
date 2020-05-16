package org.bogatskaya.schedule.app.service.impl;

import org.bogatskaya.schedule.app.domain.Role;
import org.bogatskaya.schedule.app.repository.RoleRepository;
import org.bogatskaya.schedule.app.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findOne(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }
}
