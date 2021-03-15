package bai11_Stack_va_Queue.bai_tap.ToChucDuLieuHopLy_DemergingSuDungQueue;

public class Employee {
    private String name;
    private String gender;
    private String birthDay;

    public Employee(String name, String gender, String birthDay) {
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "Ten nhan vien: " + this.getName() +
                "\nGioi tinh: " + this.getGender() +
                "\nNgay sinh: " + this.getBirthDay();
    }
}
