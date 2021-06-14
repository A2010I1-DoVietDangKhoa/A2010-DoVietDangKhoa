package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import model.MailSetting;
import repository.MailSettingRepository;

@Service
public class MailSettingServiceImpl implements MailSettingService{
    private MailSettingService mailSettingService;

    @Autowired
    private MailSettingRepository mailSettingRepository;

    @Bean
    public MailSettingService mailSettingService(){
        return new MailSettingServiceImpl();
    }

    @Override
    public void add(MailSetting mailSetting) {
        mailSettingRepository.add(mailSetting);
    }

    @Override
    public void update(MailSetting mailSetting) {

    }
}
