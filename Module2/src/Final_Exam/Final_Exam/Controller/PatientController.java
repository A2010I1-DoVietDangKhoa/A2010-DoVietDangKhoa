package Final_Exam.Controller;

import Final_Exam.Model.Patient;
import Final_Exam.Model.PatientRegular;
import Final_Exam.Model.PatientVIP;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatientController {
    private static Pattern patientIdPattern = Pattern.compile("^(BN)(-)[\\d]{3}$");
    private static Pattern caseIDPattern = Pattern.compile("^(BA)(-)[\\d]{3}$");
    private static Pattern namePattern = Pattern.compile("^[A-Z].*");
    private static Pattern datePattern =
            Pattern.compile("^(([0-2][0-9])|(30)|(31))(/)(([0][1-9])|([1][0-2]))(/)(([1][9][0-9)][0-9])|([2][0][0-2][0-1]))$");

    public static void addPatient(){
        Matcher matcher;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select patient type: \n" +
                "1. Regular.\n" +
                "2. VIP.\n" +
                "3. Go back.\n" +
                "Please choose: ");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                PatientRegular patientRegular = new PatientRegular();
                patientRegular.setCaseNum(Patient.patienArrayList.size() + 1);
                System.out.println("Input case ID (BA-XXX with X being a number from 0-9): ");
                scanner.nextLine();
                String caseIDInputReg = scanner.nextLine();
                while (!checkCaseID(caseIDInputReg)){
                    System.out.println("Input case ID (BA-XXX with X being a number from 0-9): ");
                    caseIDInputReg = scanner.nextLine();
                }
                patientRegular.setCaseID(caseIDInputReg);
                System.out.println("Input patient ID (BN-XXX with X being a number from 0-9): ");
                String patientIDInputReg = scanner.nextLine();
                while (!checkPatientID(patientIDInputReg)){
                    System.out.println("Input patient ID (BN-XXX with X being a number from 0-9): ");
                    patientIDInputReg = scanner.nextLine();
                }
                patientRegular.setPatientID(patientIDInputReg);
                System.out.println("Input patient's name (Capitalize the 1st letter of each word): ");
                String patientNameReg = scanner.nextLine();
                while (!checkName(patientNameReg)){
                    System.out.println("Input patient's name (Capitalize the 1st letter of each word): ");
                    patientNameReg = scanner.nextLine();
                }
                patientRegular.setPatientName(patientNameReg);
                System.out.println("Input in date (dd/mm/yyyy format): ");
                String inDateReg = scanner.nextLine();
                System.out.println("Input out date (dd/mm/yyyy format): ");
                String outDateReg = scanner.nextLine();
                while (!checkInAndOutDate(inDateReg, outDateReg)){
                    System.out.println("Out date must be >= in date.");
                    System.out.println("Input in date (dd/mm/yyyy format): ");
                    inDateReg = scanner.nextLine();
                    System.out.println("Input out date (dd/mm/yyyy format): ");
                    outDateReg = scanner.nextLine();
                }
                patientRegular.setDateIn(inDateReg);
                patientRegular.setDateOut(outDateReg);
                System.out.println("Input hospitalize reason: ");
                patientRegular.setReason(scanner.nextLine());
                System.out.println("Input fee (must be a number): ");
                String feeReg = scanner.nextLine();
                while (!isLong(feeReg)){
                    System.out.println("Input fee (must be a number): ");
                    feeReg = scanner.nextLine();
                }
                patientRegular.setFee(Long.parseLong(feeReg));
                PatientRegular.writePatientReg(patientRegular);
                break;

            case 2:
                PatientVIP patientVIP = new PatientVIP();
                patientVIP.setCaseNum(Patient.patienArrayList.size() + 1);
                System.out.println("Input case ID (BA-XXX with X being a number from 0-9): ");
                scanner.nextLine();
                String caseIDInputVIP = scanner.nextLine();
                while (!checkCaseID(caseIDInputVIP)){
                    System.out.println("Input case ID (BA-XXX with X being a number from 0-9): ");
                    caseIDInputVIP = scanner.nextLine();
                }
                patientVIP.setCaseID(caseIDInputVIP);
                System.out.println("Input patient ID (BN-XXX with X being a number from 0-9): ");
                String patientIDInputVIP = scanner.nextLine();
                while (!checkPatientID(patientIDInputVIP)){
                    System.out.println("Input patient ID (BN-XXX with X being a number from 0-9): ");
                    patientIDInputVIP = scanner.nextLine();
                }
                patientVIP.setPatientID(patientIDInputVIP);
                System.out.println("Input patient's name (Capitalize the 1st letter of each word): ");
                String patientNameVIP = scanner.nextLine();
                while (!checkName(patientNameVIP)){
                    System.out.println("Input patient's name (Capitalize the 1st letter of each word): ");
                    patientNameVIP = scanner.nextLine();
                }
                patientVIP.setPatientName(patientNameVIP);
                System.out.println("Input in date (dd/mm/yyyy format): ");
                String inDateVIP = scanner.nextLine();
                System.out.println("Input out date (dd/mm/yyyy format): ");
                String outDateVIP = scanner.nextLine();
                while (!checkInAndOutDate(inDateVIP, outDateVIP)){
                    System.out.println("Out date must be >= in date.");
                    System.out.println("Input in date (dd/mm/yyyy format): ");
                    inDateVIP = scanner.nextLine();
                    System.out.println("Input out date (dd/mm/yyyy format): ");
                    outDateVIP = scanner.nextLine();
                }
                patientVIP.setDateIn(inDateVIP);
                patientVIP.setDateOut(outDateVIP);
                System.out.println("Input hospitalize reason: ");
                patientVIP.setReason(scanner.nextLine());
                System.out.println("Select VIP package: ");
                System.out.println("1. VIP I.");
                System.out.println("2. VIP II.");
                System.out.println("3. VIP III.");
                String choicePackage = scanner.nextLine();
                while (!isInteger(choicePackage)){
                    System.out.println("Please input a valid choice: ");
                    choicePackage = scanner.nextLine();
                }
                boolean check = false;
                while (!check){
                    switch (Integer.parseInt(choicePackage)){
                        case 1:
                            patientVIP.setVipPackage("VIP I");
                            check = true;
                            break;
                        case 2:
                            patientVIP.setVipPackage("VIP II");
                            check = true;
                            break;
                        case 3:
                            patientVIP.setVipPackage("VIP III");
                            check = true;
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                }
                System.out.println("Input VIP duration (dd/mm/yyyy format)");
                String vipDuration = scanner.nextLine();
                while (!checkDate(vipDuration)){
                    System.out.println("Input in date (dd/mm/yyyy format): ");
                    vipDuration = scanner.nextLine();
                }
                patientVIP.setVipDuration(vipDuration);
                PatientVIP.writePatientVIP(patientVIP);
                break;
            case 3:
                Menu.displayMainMenu();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void showList() {
        //readPatient();
        if (Patient.patienArrayList.size() > 0){
            int num = 1;
            for (Patient p : Patient.patienArrayList) {
                if (p instanceof PatientRegular) {
                    PatientRegular pReg = (PatientRegular) p;
                    System.out.println("Patient no." + num + "\n" + pReg.showInfo());
                } else if (p instanceof PatientVIP) {
                    PatientVIP pVIP = (PatientVIP) p;
                    System.out.println("Patient no." + num + "\n" + pVIP.showInfo());
                }
                num++;
            }
        }
        else {
            System.out.println("No patient medical_records.");
        }
    }

    public static void readPatient() {
        List<String> list = new ArrayList<>();
        try {
            FileReader fileReader =
                    new FileReader("D:/A2010-DoVietDangKhoa/Module2/src/Final_Exam/Data/medical_records.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        if (!list.isEmpty()) {
            String[] arrayPatient = null;
            for (String i : list) {
                arrayPatient = i.split(",");
                if (arrayPatient[0].equals("REG")) {
                    PatientRegular patientRegular = new PatientRegular();
                    patientRegular.setCaseNum(Integer.parseInt(arrayPatient[1]));
                    patientRegular.setCaseID(arrayPatient[2]);
                    patientRegular.setPatientID(arrayPatient[3]);
                    patientRegular.setPatientName(arrayPatient[4]);
                    patientRegular.setDateIn(arrayPatient[5]);
                    patientRegular.setDateOut(arrayPatient[6]);
                    patientRegular.setReason(arrayPatient[7]);
                    patientRegular.setFee(Long.parseLong(arrayPatient[8]));
                    Patient.patienArrayList.add(patientRegular);
                } else if (arrayPatient[0].equals("VIP")) {
                    PatientVIP patientVIP = new PatientVIP();
                    patientVIP.setCaseNum(Integer.parseInt(arrayPatient[1]));
                    patientVIP.setCaseID(arrayPatient[2]);
                    patientVIP.setPatientID(arrayPatient[3]);
                    patientVIP.setPatientName(arrayPatient[4]);
                    patientVIP.setDateIn(arrayPatient[5]);
                    patientVIP.setDateOut(arrayPatient[6]);
                    patientVIP.setReason(arrayPatient[7]);
                    patientVIP.setVipPackage(arrayPatient[8]);
                    patientVIP.setVipDuration(arrayPatient[9]);
                    Patient.patienArrayList.add(patientVIP);
                }
            }
        } else {
            System.out.println();
        }
    }

    public static void deletePatient(){
        showList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose the ID of the case you want to delete: ");
        String choice = scanner.nextLine();
        boolean check = false;
        try {
            for (int i = 0; i < Patient.patienArrayList.size(); i++) {
                if (Patient.patienArrayList.get(i).getCaseID().equals(choice)) {
                    System.out.println("Delete? Y/N");
                    if(scanner.nextLine().equals("Y")) {
                        Patient.patienArrayList.remove(i);
                        clearCSV();
                        updateCSV();
                        showList();
                        check = true;
                        break;
                    }
                    else {
                        Menu.displayMainMenu();
                    }
                }
            }
            if (!check) {
                throw new MedicalRecordNotFound();
            }
        }catch (MedicalRecordNotFound m){
            System.out.println("No case with the input ID found.");
            Menu.displayMainMenu();
        }
    }

    public static void updateCSV(){
        try {
            FileWriter fileWriter = new FileWriter(
                    "D:/A2010-DoVietDangKhoa/Module2/src/Final_Exam/Data/medical_records.csv", true);
            for(Patient c : Patient.patienArrayList){
                fileWriter.write(c.toString());
            }
            //fileWriter.write("\n");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void clearCSV(){
        try {
            FileWriter fileWriter = new FileWriter(
                    "D:/A2010-DoVietDangKhoa/Module2/src/Final_Exam/Data/medical_records.csv");
            fileWriter.write("");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static boolean checkDate(String date){
        Matcher matcher = datePattern.matcher(date);
        if (!matcher.matches()){
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean checkName(String name){
        String[] list = name.split(" ");
        Matcher matcher;
        boolean check = false;
        for (int i = 0; i < list.length; i++) {
            matcher = namePattern.matcher(list[i]);
            if (matcher.matches()) {
                check = true;
            } else {
                check = false;
            }
        }
        return check;
    }

    public static boolean isLong(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            long d = Long.parseLong(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isInteger(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private static boolean checkPatientID(String id){
        Matcher matcher = patientIdPattern.matcher(id);
        if(!matcher.matches()){
            return false;
        }
        else {
            return true;
        }
    }

    private static boolean checkCaseID(String id){
        Matcher matcher = caseIDPattern.matcher(id);
        if(!matcher.matches()){
            return false;
        }
        else {
            return true;
        }
    }

    private static boolean checkInAndOutDate(String dateIn, String dateOut){
        boolean check = false;
        Matcher matcherIn = datePattern.matcher(dateIn);
        Matcher matcherOut = datePattern.matcher(dateOut);
            if (!matcherIn.matches() || !matcherOut.matches()){
                check = false;
            }
            else {
                int yearIn = Integer.parseInt(dateIn.substring(6));
                int yearOut = Integer.parseInt(dateOut.substring(6));
                if (yearOut > yearIn){
                    check = true;
                }
                else if ( yearOut == yearIn){
                    int monthIn = Integer.parseInt(dateIn.substring(3, 4));
                    int monthOut = Integer.parseInt(dateOut.substring(3, 4));
                    if (monthOut > monthIn){
                        check = true;
                    }
                    else if (monthOut == monthIn){
                        int dayIn = Integer.parseInt(dateIn.substring(0, 1));
                        int dayOut = Integer.parseInt(dateOut.substring(0, 1));
                        if (dayOut > dayIn || dayOut == dayIn){
                            check = true;
                        }
                        else {
                            check = false;
                        }
                    }
                }
                else {
                    check = false;
                }
            }
            return check;
    }
}
