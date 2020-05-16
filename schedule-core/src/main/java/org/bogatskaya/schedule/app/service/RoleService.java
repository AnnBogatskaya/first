package org.bogatskaya.schedule.app.service;

import org.bogatskaya.schedule.app.domain.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    List<Role> findAll();

    Optional<Role> findOne(Long id);

    void save(Role role);
}
