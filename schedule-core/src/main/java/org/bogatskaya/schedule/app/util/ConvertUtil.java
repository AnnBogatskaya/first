package org.bogatskaya.schedule.app.util;

import org.bogatskaya.schedule.app.domain.schedule.Record;
import org.bogatskaya.schedule.app.domain.schedule.Schedule;
import org.bogatskaya.schedule.app.domain.user.User;
import org.bogatskaya.schedule.app.dto.RecordDTO;
import org.bogatskaya.schedule.app.dto.ScheduleDTO;
import org.bogatskaya.schedule.app.dto.UserDTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class ConvertUtil {

    public static Record convertRecord(RecordDTO recordDTO){
        Record record = new Record();

        record.setDate(LocalDate.parse(recordDTO.getDate()));
        record.setTime(LocalTime.parse(recordDTO.getTime()));
        record.setComplaint(recordDTO.getComplaint());

        return record;
    }

    public static Schedule convertSchedule(ScheduleDTO scheduleDTO){
        Schedule schedule = new Schedule();

        schedule.setDate(LocalDate.parse(scheduleDTO.getDate()));
        schedule.setTimeFrom(LocalTime.parse(scheduleDTO.getTimeFrom()));
        schedule.setTimeTo(LocalTime.parse(scheduleDTO.getTimeTo()));
        schedule.setComplaint(scheduleDTO.getComplaint());
        return schedule;
    }

    public static UserDTO convertUserDTO (User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setEmail(user.getEmail());
        userDTO.setIsConfirmed(user.getIsConfirmed());
        userDTO.setFullname(user.getFullname());
        userDTO.setLogin(user.getLogin());
        userDTO.setPassword(user.getPassword());
        userDTO.setId(user.getId());

        return userDTO;
    }

    public static ScheduleDTO convertScheduleDTO (Schedule schedule) {
        ScheduleDTO scheduleDTO = new ScheduleDTO();

        scheduleDTO.setAvailable(schedule.isAvailable());
        scheduleDTO.setDate(schedule.getDate().toString());
        scheduleDTO.setTimeFrom(schedule.getTimeFrom().toString());
        scheduleDTO.setTimeTo(schedule.getTimeTo().toString());
        scheduleDTO.setComplaint(schedule.getComplaint());
        return scheduleDTO;
    }
}
