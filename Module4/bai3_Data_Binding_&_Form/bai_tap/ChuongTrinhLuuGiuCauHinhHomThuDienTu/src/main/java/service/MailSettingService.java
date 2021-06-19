package service;

import model.MailSetting;

import java.util.List;

public interface MailSettingService {
    void add(MailSetting mailSetting);

    void update(MailSetting mailSetting);

    List<MailSetting> getAll();

    MailSetting getById(int id);

    void updateMailSetting(int id, MailSetting mailSetting);
}
