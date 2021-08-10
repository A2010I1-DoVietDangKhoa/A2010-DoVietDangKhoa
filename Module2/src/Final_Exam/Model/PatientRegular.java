package Final_Exam.Model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PatientRegular extends Final_Exam.Model.Patient {
    private long fee;

    public PatientRegular(int caseNum, String caseID, String patientName, String patientID,
                          String dateIn, String dateOut, String reason, long fee) {
        super(caseNum, caseID, patientName, patientID, dateIn, dateOut, reason);
        this.fee = fee;
    }

    public PatientRegular() {
    }

    public long getFee() {
        return fee;
    }

    public void setFee(long fee) {
        this.fee = fee;
    }

    public static void writePatientReg(PatientRegular patientRegular){
        try {
            FileWriter myWriter =
                    new FileWriter("D:/A2010-DoVietDangKhoa/Module2/src/Final_Exam/Data/medical_records.csv", true);
            myWriter.write(patientRegular.toString());
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
                "\nType: Regular" +
                "\nCase No: " + this.getCaseNum() +
                "\nCase ID: " + this.getCaseID() +
                "\nID: " + this.getPatientID() +
                "\nName: " + this.getPatientName() +
                "\nDate in: " + this.getDateIn() +
                "\nDate out: " + this.getDateOut() +
                "\nReason: " + this.getReason() +
                "\nFee: " + this.getFee();
    }

    @Override
    public String toString() {
        return  "REG," +
                this.getCaseNum() +
                "," + this.getCaseID() +
                "," + this.getPatientID() +
                "," + this.getPatientName() +
                "," + this.getDateIn() +
                "," + this.getDateOut() +
                "," + this.getReason() +
                "," + this.getFee() + "\n";
    }
}
