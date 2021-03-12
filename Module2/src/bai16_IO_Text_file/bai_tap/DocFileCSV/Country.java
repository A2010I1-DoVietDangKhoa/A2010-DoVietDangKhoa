package bai16_IO_Text_file.bai_tap.DocFileCSV;

import java.util.ArrayList;

public class Country {
    private String beginIP;
    private String endIP;
    private String ip2;
    private String ip2location;
    private String abbreviation;
    private String countryName;
    public static ArrayList<Country> countryArrayList = new ArrayList<Country>();

    public Country() {
    }

    public Country(String beginIP, String endIP, String ip2,
                   String ip2location, String abbreviation, String countryName) {
        this.beginIP = beginIP;
        this.endIP = endIP;
        this.ip2 = ip2;
        this.ip2location = ip2location;
        this.abbreviation = abbreviation;
        this.countryName = countryName;
    }

    public String getBeginIP() {
        return beginIP;
    }

    public void setBeginIP(String beginIP) {
        this.beginIP = beginIP;
    }

    public String getEndIP() {
        return endIP;
    }

    public void setEndIP(String endIP) {
        this.endIP = endIP;
    }

    public String getIp2() {
        return ip2;
    }

    public void setIp2(String ip2) {
        this.ip2 = ip2;
    }

    public String getIp2location() {
        return ip2location;
    }

    public void setIp2location(String ip2location) {
        this.ip2location = ip2location;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "Country name: " + this.getCountryName() +
                "\nAbbreviation: " + this.getAbbreviation() +
                "\nBegin IP: " + this.getBeginIP() +
                "\nEnd IP: " + this.getEndIP() +
                "\nIP2 location: " + getIp2() + ", " + getIp2location();
    }
}
