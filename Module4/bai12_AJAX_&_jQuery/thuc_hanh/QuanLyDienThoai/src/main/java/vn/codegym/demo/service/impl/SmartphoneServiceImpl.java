package vn.codegym.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.demo.model.Smartphone;
import vn.codegym.demo.repository.SmartphoneRepository;
import vn.codegym.demo.service.SmartphoneService;

@Service
public class SmartphoneServiceImpl implements SmartphoneService {

    @Autowired
    private SmartphoneRepository smartphoneRepository;

    @Override
    public Iterable<Smartphone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public Smartphone findById(Integer id) {
        Smartphone smartphone = smartphoneRepository.findById(id).get();
        if(smartphone == null){
            return null;
        }
        return smartphone;
    }

    @Override
    public Smartphone save(Smartphone phone) {
        return smartphoneRepository.save(phone);
    }

    @Override
    public Smartphone remove(Integer id) {
        Smartphone smartphone = findById(id);
        smartphoneRepository.deleteById(id);
        return smartphone;
    }
}
