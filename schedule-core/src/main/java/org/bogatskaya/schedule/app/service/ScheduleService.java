package org.bogatskaya.schedule.app.service;

import org.bogatskaya.schedule.app.domain.schedule.Schedule;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ScheduleService {

    List<Schedule> findAll();

    List<Schedule> findAllAvailable ();

    Schedule findOne(Long id);

    Schedule findByDateAndTime(LocalDate date, LocalTime timeFrom);

    Schedule findByDate(final String date);

    Schedule findByDate(LocalDate date);

    void save(Schedule schedule);

    void update(Schedule schedule);

    void removeSchedule(Long id);

    boolean isExist(Schedule schedule);


}
