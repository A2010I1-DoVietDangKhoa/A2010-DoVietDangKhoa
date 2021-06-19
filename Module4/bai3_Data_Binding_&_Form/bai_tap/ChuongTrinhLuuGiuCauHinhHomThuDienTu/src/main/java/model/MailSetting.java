package model;


public class MailSetting {
    private int id;
    private String language;
    private int size;
    private boolean filter;
    private String signature;

    public MailSetting(int id, String language, int size, boolean filter, String signature) {
        this.id = id;
        this.language = language;
        this.size = size;
        this.filter = filter;
        this.signature = signature;
    }

    public MailSetting() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean getFilter() {
        return filter;
    }

    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
