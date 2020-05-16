package org.bogatskaya.schedule.app.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "confirmation")
public class Confirmation extends SuperEntity{

    @Column(name = "login")
    private String user_name;

    @Column(name = "token")
    private String token;

    public Confirmation (String user_name, String token) {
        this.user_name = user_name;
        this.token = token;
    }
}
