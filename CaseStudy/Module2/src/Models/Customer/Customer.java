package Models.Customer;

import Models.Services.House;
import Models.Services.Room;
import Models.Services.Service;
import Models.Services.Villa;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer{
    private String name;
    private String dateOfBirth;
    private String gender;
    private String personalID;
    private String phoneNumber;
    private String email;
    private String customerType;
    private String address;
    private Service serviceUse;
    public static ArrayList<Customer> customerArrayList = new ArrayList<Customer>();
    private Scanner scanner = new Scanner(System.in);
    private Pattern namePattern = Pattern.compile("([A-Z])[a-z ]+");
    private Pattern emailPattern = Pattern.compile("[\\w]*(@)[a-zA-z]+(.)[a-zA-Z]+");
    private Pattern idPattern = Pattern.compile("^[0-9]{3}(\\s)[0-9]{3}(\\s)[0-9]{3}$");
    private Pattern birthdayPattern =
            Pattern.compile("^(([0-2][0-9])|(30)|(31))(/)(([0][1-9])|([1][0-2]))(/)(([1][9][0-9)][0-9])|([2][0][0-2][0-1]))$");

    public Customer(String name, String dateOfBirth, String gender, String personalID, String phoneNumber,
                    String email, String customerType, String address, Service serviceUse) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.personalID = personalID;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.customerType = customerType;
        this.address = address;
        this.serviceUse = serviceUse;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        boolean check = false;
        Matcher matcher;
        while (!check) {
            try {
                String[] list = name.split(" ");
                for (int i = 0; i < list.length; i++) {
                    matcher = namePattern.matcher(list[i]);
                    if (matcher.matches()) {
                        this.name = name;
                        check = true;
                    } else {
                        throw new NameException();
                    }
                }
            } catch (NameException e) {
                System.out.println("Wrong name format, must capitalize the first letter" +
                        " of each word.");
                name = scanner.nextLine();
            }
        }
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        Matcher matcher;
        boolean check = false;
        while (!check) {
            try {
                matcher = birthdayPattern.matcher(dateOfBirth);
                if (matcher.matches()) {
                    int year = Integer.parseInt(dateOfBirth.substring(6));
                    if (year > 1900 && Calendar.getInstance().get(Calendar.YEAR) - year > 18) {
                        this.dateOfBirth = dateOfBirth;
                        check = true;
                    } else {
                        throw new DateOfBirthException();
                    }
                }
                else {
                    throw new DateOfBirthException();
                }
            } catch (DateOfBirthException e) {
                System.out.println("Birth year must be greater than 1900 and " +
                        "at least 18 years apart from the current year.");
                dateOfBirth = scanner.nextLine();
            }
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender){
        boolean check = false;
        String genderTest;
        while (!check){
            genderTest = gender.trim().toLowerCase();
            try {
                if(genderTest.equals("male")){
                    this.gender = "Male";
                    check = true;
                }
                else if(genderTest.equals("female")){
                    this.gender = "Female";
                    check = true;
                }
                else if(genderTest.equals("unknown")){
                    this.gender = "Unknown";
                    check = true;
                }
                else {
                    throw new GenderException();
                }
            } catch (GenderException e){
                System.out.println("Gender can only be either Male, Female or Unknown.");
                gender = scanner.nextLine();
            }
        }
    }

    public String getPersonalID() {
        return personalID;
    }

    public void setPersonalID(String personalID){
        Matcher matcher;
        boolean check = false;
        while (!check){
            try {
                matcher = idPattern.matcher(personalID);
                if (matcher.matches()) {
                    this.personalID = personalID;
                    check = true;
                } else{
                    throw new IdException();
                }
            } catch (IdException e){
                System.out.println("ID must follow XXX XXX XXX format," +
                        " with X being a number from 0 to 9.");
                personalID = scanner.nextLine();
            }
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        //Matcher matcher = emailPattern.matcher(email);
//        boolean check = false;
//        while (!check){
//            if(matcher.matches()){
//                this.email = email;
//                check = true;
//            }
//            else {
//                throw new EmailException("Email must follow abc@abc.abc format.");
//            }
//        }
        boolean check = false;
        while (!check) {
            try {
                Matcher matcher = emailPattern.matcher(email);
                if (matcher.matches()) {
                    this.email = email;
                    check = true;
                } else {
                    throw new EmailException("Email must follow abc@abc.abc format.");
                }
            } catch (EmailException e) {
                System.out.println("Please re-input.");
                email = scanner.nextLine();
            }
        }
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Service getServiceUse() {
        return serviceUse;
    }

    public void setServiceUse(Service serviceUse) {
        this.serviceUse = serviceUse;
    }

    public static void writeCustomer (Customer customer){
        try {
            FileWriter myWriter =
                    new FileWriter("D:/A2010-DoVietDangKhoa/CaseStudy/Module2/src/Data/Customer.csv", true);
            myWriter.write(customer.toString());
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public static void readCustomer(){
        customerArrayList.clear();
        List<String> list = new ArrayList<>();
        try {
            FileReader fileReader =
                    new FileReader("D:/A2010-DoVietDangKhoa/CaseStudy/Module2/src/Data/Customer.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        if(!list.isEmpty()) {
            String[] arrayCustomer = null;
            for (String i : list) {
                arrayCustomer = i.split(",");
                Customer customer = new Customer();
                customer.setName(arrayCustomer[0]);
                customer.setDateOfBirth(arrayCustomer[1]);
                customer.setGender(arrayCustomer[2]);
                customer.setPersonalID(arrayCustomer[3]);
                customer.setPhoneNumber(arrayCustomer[4]);
                customer.setEmail(arrayCustomer[5]);
                customer.setCustomerType(arrayCustomer[6]);
                customer.setAddress(arrayCustomer[7]);
                if(arrayCustomer[9].equals("Villa")){
                    //Villa.readVilla();
                    customer.setServiceUse(Villa.villaArrayList.get(Integer.parseInt(arrayCustomer[8])));
                }
                else if(arrayCustomer[9].equals("House")){
                    //House.readHouse();
                    customer.setServiceUse(House.houseArrayList.get(Integer.parseInt(arrayCustomer[8])));
                }
                else if(arrayCustomer[9].equals("Room")){
                    //Room.readRoom();
                    customer.setServiceUse(Room.roomArrayList.get(Integer.parseInt(arrayCustomer[8])));
                }
                else {
                    customer.setServiceUse(null);
                }
                customerArrayList.add(customer);
            }
        }
        else {
            System.out.println();
        }
    }
    public static void showCustomerInfo(){
        Collections.sort(customerArrayList, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                if (o1.getName().compareTo(o2.getName()) != 0) {
                    return o1.getName().compareTo(o2.getName());
                } else {
                    int yearO1 = Integer.parseInt(o1.getDateOfBirth().substring(6));
                    int yearO2 = Integer.parseInt(o2.getDateOfBirth().substring(6));
                    return yearO2 - yearO1;
                }
            }
        });
        for (Customer customer : customerArrayList) {
            customer.showCustomerDetail();
            System.out.println("-------------------------------------------------");
        }
    }

    public void showCustomerDetail(){
        System.out.println("Name: " + this.name +
                "\nDate of birth: " + this.dateOfBirth +
                "\nGender: " + this.gender +
                "\nID: " + this.personalID +
                "\nPhone number: " + this.phoneNumber +
                "\nEmail: " + this.email +
                "\nCustomer type: " + this.customerType +
                "\nAddress: " + this.address +
                "\n--Booked service-- \n");
        if(this.serviceUse instanceof Villa){
            Villa villaInfo = (Villa) this.serviceUse;
            System.out.println(villaInfo.showInfo());
        }
        else if(this.serviceUse instanceof House){
            House houseInfo = (House) this.serviceUse;
            System.out.println(houseInfo.showInfo());
        }
        else if(this.serviceUse instanceof Room){
            Room roomInfo = (Room) this.serviceUse;
            System.out.println(roomInfo.showInfo());
        }
        else{
            System.out.println("This customer haven't booked any service.");
        }
    }

    @Override
    public String toString() {
//        StringBuilder info = new StringBuilder(this.getName() + "," +
//                this.getDateOfBirth() + "," +
//                this.getGender() + "," +
//                this.getPersonalID() + "," +
//                this.getPhoneNumber() + "," +
//                this.getEmail() + "," +
//                this.getCustomerType() + "," +
//                this.getAddress() + ",");
        String info = this.name + "," +
                this.dateOfBirth + "," +
                this.gender + "," +
                this.personalID + "," +
                this.phoneNumber + "," +
                this.email + "," +
                this.customerType + "," +
                "\"" + this.address + "\"" + ",";
        if(this.serviceUse instanceof Villa){
            info = info.concat(Villa.villaArrayList.indexOf(this.serviceUse) + ",");
            info = info.concat("Villa");
            info = info.concat("\n");
        }
        else if(this.serviceUse instanceof House){
            info = info.concat(House.houseArrayList.indexOf(this.serviceUse) + ",");
            info = info.concat("House");
            info = info.concat("\n");
        }
        else if(this.serviceUse instanceof Room){
            info = info.concat(Room.roomArrayList.indexOf(this.serviceUse) + ",");
            info = info.concat("Room");
            info = info.concat("\n");
        }
        else {
            info = info.concat("0,");
            info = info.concat("null");
            info = info.concat("\n");
        }
        return info;
    }
}
