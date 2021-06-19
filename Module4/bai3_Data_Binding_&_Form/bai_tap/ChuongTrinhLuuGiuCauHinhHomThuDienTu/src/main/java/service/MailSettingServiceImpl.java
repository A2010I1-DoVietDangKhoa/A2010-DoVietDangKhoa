package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import model.MailSetting;
import repository.MailSettingRepository;

import java.util.List;

@Service
public class MailSettingServiceImpl implements MailSettingService{

    @Autowired
    private MailSettingRepository mailSettingRepository;

//    @Bean
//    public MailSettingService mailSettingService(){
//        return new MailSettingServiceImpl();
//    }

    @Override
    public void add(MailSetting mailSetting) {
        mailSettingRepository.add(mailSetting);
    }

    @Override
    public void update(MailSetting mailSetting) {

    }

    public List<MailSetting> getAll(){
        return mailSettingRepository.getAll();
    }

    public MailSetting getById(int id){
        return mailSettingRepository.getById(id);
    }

    public void updateMailSetting(int id, MailSetting mailSetting){
        mailSettingRepository.updateMailSetting(id, mailSetting);
    }
}
