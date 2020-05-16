package org.bogatskaya.schedule.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConfirmationDTO {

    private String user_name;

    private String token;

}
