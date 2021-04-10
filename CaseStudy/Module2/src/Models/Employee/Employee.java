package Models.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Employee {
    private String employeeID;
    private String name;
    private int age;
    private String dateOfBirth;
    private String personalID;
    private String phoneNumber;
    private String address;
    private String email;
    private String degree;
    private String position;
    private long salary;
    //public static Stack<Employee> employeeStack = new Stack<Employee>();
    public static ArrayList<Employee> employeeArrayList = new ArrayList<Employee>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPersonalID() {
        return personalID;
    }

    public void setPersonalID(String personalID) {
        this.personalID = personalID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }


    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public static void readEmployee() {
        employeeArrayList.clear();
        List<String> list = new ArrayList<>();
        try {
            FileReader fileReader =
                    new FileReader("D:/A2010-DoVietDangKhoa/CaseStudy/Module2/src/Data/Employee.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        if (!list.isEmpty()) {
            String[] arrayEmployee = null;
            for (String i : list) {
                arrayEmployee = i.split(",");
                Employee employee = new Employee();
                employee.setEmployeeID(arrayEmployee[0]);
                employee.setName(arrayEmployee[1]);
                employee.setAge(Integer.parseInt(arrayEmployee[2]));
                employee.setDateOfBirth(arrayEmployee[3]);
                employee.setPersonalID(arrayEmployee[4]);
                employee.setPhoneNumber(arrayEmployee[5]);
                employee.setAddress(arrayEmployee[6]);
                employee.setEmail(arrayEmployee[7]);
                employee.setDegree(arrayEmployee[8]);
                employee.setPosition(arrayEmployee[9]);
                employee.setSalary(Long.parseLong(arrayEmployee[10]));
                employeeArrayList.add(employee);
            }
        } else {
            System.out.println("No employee data available.");
        }
    }

    public static void showEmployee(){
        Map <Employee, String> employeeStringMap = new HashMap<Employee, String>();
        Employee.readEmployee();
        for(Employee e : Employee.employeeArrayList){
            employeeStringMap.put(e, e.getEmployeeID());
        }

        Set<Employee> set = employeeStringMap.keySet();
        for(Employee e : set){
            System.out.println(e.toString());
            System.out.println("Employee's ID: " + employeeStringMap.get(e));
        }
    }


    @Override
    public String toString() {
        return "Name: " + this.getName() +
                "\nAge: " + this.getAge() +
                "\nDate of birth: " + this.getDateOfBirth() +
                "\nPersonal ID: " + this.getPersonalID() +
                "\nPhone number: " + this.getPhoneNumber() +
                "\nAddress: " + this.getAddress() +
                "\nEmail: " + this.getEmail() +
                "\nDegree: " + this.getDegree() +
                "\nPosition: " + this.getPosition() +
                "\nSalary: " + this.getSalary();
    }
}
