package org.bogatskaya.schedule.app.service.impl;

import org.bogatskaya.schedule.app.domain.schedule.Record;
import org.bogatskaya.schedule.app.exception.NotFoundException;
import org.bogatskaya.schedule.app.repository.RecordRepository;
import org.bogatskaya.schedule.app.service.RecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecordServiceImpl implements RecordService{

    private static final Logger LOGGER = LoggerFactory.getLogger(RecordServiceImpl.class);

    @Autowired
    private RecordRepository recordRepository;

    @Override
    public List<Record> findAll() {
        return recordRepository.findAll();
    }

    @Override
    public List<Record> findAllByUserId(Long id) {
        return findAll()
                .stream()
                .filter(r -> r.getUser().getId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public Record findOne(Long id) {
        return findAll()
                .stream()
                .filter(r -> r.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new NotFoundException("No record with id: ", id));
    }

    @Override
    public void addRecord(Record record) {
        recordRepository.save(record);
    }

    @Override
    public void deleteRecord(Long id) {
        recordRepository.deleteById(id);
    }
}
