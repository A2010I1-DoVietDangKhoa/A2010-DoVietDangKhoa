package repository;

import model.MailSetting;

public interface MailRepository {
    void add(MailSetting mailSetting);

    void update(MailSetting mailSetting);
}
