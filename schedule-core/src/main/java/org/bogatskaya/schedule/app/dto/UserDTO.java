package org.bogatskaya.schedule.app.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    @NotNull
    @Size(min = 3)
    private String fullname;

    @NotNull
    @Size(min = 4, max = 16)
    private String login;

    @NotNull
    @Size(min = 6, max = 16)
    private String password;

    @NotNull
    @Size(min = 6, max = 16)
    private String confirmedPassword;

    @NotNull
    private String email;

    private Boolean isConfirmed = false;

}
