package org.bogatskaya.schedule.app.validation;

import org.bogatskaya.schedule.app.dto.UserDTO;
import org.springframework.stereotype.Component;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class UserValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors err) {

        ValidationUtils.rejectIfEmpty(err, "fullname", "user.name.empty");
        ValidationUtils.rejectIfEmpty(err, "email", "user.email.empty");

        UserDTO user = (UserDTO) obj;

        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
                Pattern.CASE_INSENSITIVE);
        if (!(pattern.matcher(user.getEmail()).matches())) {
            err.rejectValue("email", "user.email.invalid");
        }

    }
}
