package org.bogatskaya.schedule.app.util;

import org.bogatskaya.schedule.app.dto.UserDTO;

public class ValidationUtil {

    public static boolean validateUser (UserDTO userDTO) {

        return !userDTO.getFullname().isEmpty()
                && !userDTO.getLogin().isEmpty()
                && !userDTO.getPassword().isEmpty()
                && !userDTO.getEmail().isEmpty()
                && !userDTO.getConfirmedPassword().isEmpty();
    }
}
