package org.bogatskaya.schedule.app.service.impl;

import org.bogatskaya.schedule.app.domain.schedule.Schedule;
import org.bogatskaya.schedule.app.exception.AlreadyExistException;
import org.bogatskaya.schedule.app.exception.NotFoundException;
import org.bogatskaya.schedule.app.repository.ScheduleRepository;
import org.bogatskaya.schedule.app.service.ScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleServiceImpl.class);


    private ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleServiceImpl(ScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public List<Schedule> findAllAvailable() {
        return findAll().stream().filter(Schedule::isAvailable).collect(Collectors.toList());
    }

    @Override
    public Schedule findOne(Long id) {
        return findAll().stream().filter(s -> s.getId().equals(id)).findAny().get();
    }

    @Override
    public Schedule findByDateAndTime(LocalDate date, LocalTime timeFrom) {
        return findAll().stream().filter(s -> s.getTimeFrom().equals(timeFrom) && s.getDate().equals(date)).findAny().get();
    }

    @Override
    public Schedule findByDate(LocalDate date) {
        return findAll().stream().filter(s -> s.getDate().equals(date)).findAny().get();
    }

    @Override
    public Schedule findByDate(String date) {
        return findAll().stream().filter(s -> s.getDate().equals(LocalDate.parse(date))).findAny().get();
    }

    @Override
    public void save(Schedule schedule) {
        if(!isExist(schedule)){
            scheduleRepository.save(schedule);
        }
    }

    @Override
    public void update(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    @Override
    public void removeSchedule(Long id) {
        if(findOne(id) != null){
            scheduleRepository.deleteById(id);
        }
        LOGGER.error("No schedule with id: {}",id);
        throw new NotFoundException("Schedule does not exist");
    }

    @Override
    public boolean isExist(Schedule schedule) {
        for(Schedule s : scheduleRepository.findAll()){
            if(s.getDate().equals(schedule.getDate()) &&
                    s.getTimeFrom().equals(schedule.getTimeFrom())){
                LOGGER.error("Schedule already exist for this date");
                throw new AlreadyExistException("Schedule already exist");
            }
        }

        return false;
    }


}
