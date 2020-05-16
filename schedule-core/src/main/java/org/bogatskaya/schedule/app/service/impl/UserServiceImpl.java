package org.bogatskaya.schedule.app.service.impl;

import org.bogatskaya.schedule.app.domain.user.User;
import org.bogatskaya.schedule.app.dto.LoginDTO;
import org.bogatskaya.schedule.app.repository.UserRepository;
import org.bogatskaya.schedule.app.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(Long id) {
        return findAll().stream()
                .filter(user -> user.getId().equals(id))
                .findAny()
                .orElseThrow(null);
    }

    @Override
    public User findByLogin(final String login) {
        return findAll().stream().filter(u -> u.getLogin().equals(login))
                .findAny()
                .orElse(null);
    }

    @Override
    public User findCurrent(HttpServletRequest request) {
        return findByLogin((String)request.getSession().getAttribute("login"));
    }

    @Override
    public void saveUser(User user) {
        List<User> users = findAll();

        if(!isExist(user, users)) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            LOGGER.info("Save user to db!");
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean isExist(User user, List<User> userList) {
        return userList.stream().anyMatch(u -> u.getLogin()
                .equalsIgnoreCase(user.getLogin()) && u.getEmail()
                .equals(user.getEmail()));
    }

    @Override
    public User validateUser(LoginDTO loginDTO) {
        return findAll().stream().filter(dto -> dto.getLogin()
                .equals(loginDTO.getUserName()) && dto.getPassword()
                .equals(loginDTO.getPassword())).findAny().orElse(null);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

}
