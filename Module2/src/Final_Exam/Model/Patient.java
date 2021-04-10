package Final_Exam.Model;

import java.util.ArrayList;
import java.util.regex.Pattern;

public abstract class Patient {
    protected int caseNum;
    protected String caseID;
    protected String patientName;
    protected String patientID;
    protected String dateIn;
    protected String dateOut;
    protected String reason;
    public static ArrayList<Patient> patienArrayList = new ArrayList<Patient>();

    public Patient(int caseNum, String caseID, String patientName,
                   String patientID, String dateIn, String dateOut, String reason) {
        this.caseNum = caseNum;
        this.caseID = caseID;
        this.patientName = patientName;
        this.patientID = patientID;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.reason = reason;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public Patient(){

    }

    public int getCaseNum() {
        return caseNum;
    }

    public void setCaseNum(int caseNum) {
        this.caseNum = caseNum;
    }

    public String getCaseID() {
        return caseID;
    }

    public void setCaseID(String caseID) {
        this.caseID = caseID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String showInfo(){
        return "";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
