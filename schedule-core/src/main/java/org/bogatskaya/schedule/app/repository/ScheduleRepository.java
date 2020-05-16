package org.bogatskaya.schedule.app.repository;

import org.bogatskaya.schedule.app.domain.schedule.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Long>{
}
