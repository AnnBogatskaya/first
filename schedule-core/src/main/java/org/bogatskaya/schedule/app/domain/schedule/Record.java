package org.bogatskaya.schedule.app.domain.schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bogatskaya.schedule.app.domain.SuperEntity;
import org.bogatskaya.schedule.app.domain.user.User;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Transactional
@Table(name="records")
public class Record extends SuperEntity{

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "complaint")
    private String complaint;

//    @Column(name = "fullname")
//    private String fullname;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
