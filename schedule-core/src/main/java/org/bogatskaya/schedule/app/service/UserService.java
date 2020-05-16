package org.bogatskaya.schedule.app.service;

import org.bogatskaya.schedule.app.domain.user.User;
import org.bogatskaya.schedule.app.dto.LoginDTO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public interface UserService {

    List<User> findAll();

    User findOne(Long id);

    User findCurrent(HttpServletRequest request);

    User findByLogin(String login);

    void saveUser(User user);

    void deleteUser(Long id);

    boolean isExist(User user, List<User> userList);

    User validateUser(LoginDTO loginDTO);

    void update (User user);

}
