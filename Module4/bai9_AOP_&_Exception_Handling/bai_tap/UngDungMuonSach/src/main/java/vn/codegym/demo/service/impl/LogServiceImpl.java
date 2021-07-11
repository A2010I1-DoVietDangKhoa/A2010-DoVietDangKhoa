package vn.codegym.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.demo.model.Log;
import vn.codegym.demo.repository.LogRepository;
import vn.codegym.demo.service.LogService;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogRepository logRepository;

    @Override
    public long getSize() {
        return logRepository.findAll().size();
    }

    @Override
    public void initialize() {
        if (getSize() == 0) {
            logRepository.save(new Log());
        }
    }

    @Override
    public int getVisitorNumber(Integer id) {
        Log log = logRepository.getOne(id);
        return log.getVisitors();
    }

    @Override
    public void addVisitor(Integer id) {
        Log log = logRepository.getOne(id);
        log.setVisitors(log.getVisitors() + 1);
        logRepository.save(log);
    }
}
