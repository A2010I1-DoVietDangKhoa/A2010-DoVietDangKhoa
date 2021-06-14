package repository;

import model.MailSetting;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class MailSettingRepository implements MailRepository{
    private static ArrayList<MailSetting> mailSettings;
    private MailRepository mailRepository;

    @Bean
    public MailRepository mailRepository(){
        return new MailSettingRepository();
    }

    @Override
    public void add(MailSetting mailSetting){
        mailSettings.add(mailSetting);
    }

    public void update(MailSetting mailSetting){

    }
}
