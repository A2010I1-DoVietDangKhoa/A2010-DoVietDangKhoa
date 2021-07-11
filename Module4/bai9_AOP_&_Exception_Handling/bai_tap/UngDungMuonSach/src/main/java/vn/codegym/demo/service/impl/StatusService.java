package vn.codegym.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.demo.model.Status;
import vn.codegym.demo.repository.IStatusRepository;
import vn.codegym.demo.service.IStatusService;

@Service
public class StatusService implements IStatusService {

    @Autowired
    IStatusRepository statusRepository;


    @Override
    public void createStatus() {
        statusRepository.save(new Status(1, "available"));
        statusRepository.save(new Status(2, "used"));
    }
}
