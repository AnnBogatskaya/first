package org.bogatskaya.schedule.app.repository;

import org.bogatskaya.schedule.app.domain.schedule.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record,Long> {
}
