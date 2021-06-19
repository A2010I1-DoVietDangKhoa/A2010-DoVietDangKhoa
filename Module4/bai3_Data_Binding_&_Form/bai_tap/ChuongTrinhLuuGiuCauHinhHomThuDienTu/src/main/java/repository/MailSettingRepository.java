package repository;

import model.MailSetting;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MailSettingRepository implements MailRepository{
    private static ArrayList<MailSetting> mailSettings;

//    @Bean
//    public MailRepository mailRepository(){
//        return new MailSettingRepository();
//    }

    static {
        mailSettings = new ArrayList<>();
    }

    @Override
    public void add(MailSetting mailSetting){
        mailSettings.add(mailSetting);
    }

    public void update(MailSetting mailSetting){

    }

    public List<MailSetting> getAll(){
        return mailSettings;
    }

    public MailSetting getById(int id){
        for(MailSetting m : mailSettings){
            if (m.getId() == id){
                return m;
            }
        }
        return null;
    }

    public void updateMailSetting(int id, MailSetting mailSetting){
        for (int i = 0; i < mailSettings.size(); i++){
            if(mailSettings.get(i).getId() == id){
                mailSettings.get(i).setLanguage(mailSetting.getLanguage());
                mailSettings.get(i).setFilter(mailSetting.getFilter());
                mailSettings.get(i).setSignature(mailSetting.getSignature());
                mailSettings.get(i).setSize(mailSetting.getSize());
            }
        }
    }
}
