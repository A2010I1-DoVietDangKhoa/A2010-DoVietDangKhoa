package Final_Exam.Model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PatientVIP extends Final_Exam.Model.Patient {
    private String vipPackage;
    private String vipDuration;

    public PatientVIP(int caseNum, String caseID, String patientName, String patientID, String dateIn,
                      String dateOut, String reason, String vipPackage, String vipDuration) {
        super(caseNum, caseID, patientName, patientID, dateIn, dateOut, reason);
        this.vipPackage = vipPackage;
        this.vipDuration = vipDuration;
    }


    public PatientVIP() {
    }

    public String getVipPackage() {
        return vipPackage;
    }

    public void setVipPackage(String vipPackage) {
        this.vipPackage = vipPackage;
    }

    public String getVipDuration() {
        return vipDuration;
    }

    public void setVipDuration(String vipDuration) {
        this.vipDuration = vipDuration;
    }

    public static void writePatientVIP(PatientVIP patientVIP){
        try {
            FileWriter myWriter =
                    new FileWriter("D:/A2010-DoVietDangKhoa/Module2/src/Final_Exam/Data/medical_records.csv", true);
            myWriter.write(patientVIP.toString());
            myWriter.close();
            System.out.println("Added.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public String showInfo() {
        return "Patient info:" +
                "\nType: VIP" +
                "\nCase No: " + this.getCaseNum() +
                "\nCase ID: " + this.getCaseID() +
                "\nID: " + this.getPatientID() +
                "\nName: " + this.getPatientName() +
                "\nDate in: " + this.getDateIn() +
                "\nDate out: " + this.getDateOut() +
                "\nReason: " + this.getReason() +
                "\nVip package: " + this.getVipPackage() +
                "\nVip duration: " + this.getVipDuration();
    }

    @Override
    public String toString() {
        return  "VIP," +
                this.getCaseNum() +
                "," + this.getCaseID() +
                "," + this.getPatientID() +
                "," + this.getPatientName() +
                "," + this.getDateIn() +
                "," + this.getDateOut() +
                "," + this.getReason() +
                "," + this.getVipPackage() +
                "," + this.getVipDuration() + "\n";
    }
}
