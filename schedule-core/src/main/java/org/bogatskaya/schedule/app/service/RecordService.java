package org.bogatskaya.schedule.app.service;

import org.bogatskaya.schedule.app.domain.schedule.Record;

import java.util.List;

public interface RecordService {

    List<Record> findAll();

    List<Record> findAllByUserId(Long id);

    Record findOne(Long id);

    void addRecord(Record record);

    void deleteRecord(Long id);
}
