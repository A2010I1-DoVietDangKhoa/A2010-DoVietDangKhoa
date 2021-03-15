package bai11_Stack_va_Queue.bai_tap.ToChucDuLieuHopLy_DemergingSuDungQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employeeList = new ArrayList<>();
        Employee employee1 = new Employee("Nguyen Van A", "Nam", "31/1/1998");
        Employee employee2 = new Employee("Nguyen Thi B", "Nu", "30/1/1998");
        Employee employee3 = new Employee("Nguyen Van C", "Nam", "29/1/1998");
        Employee employee4 = new Employee("Nguyen Van D", "Nam", "28/1/1998");
        Employee employee5 = new Employee("Nguyen Thi E", "Nu", "27/1/1998");
        Employee employee6 = new Employee("Nguyen Thi F", "Nu", "26/1/1998");
        Employee employee7 = new Employee("Nguyen Thi G", "Nu", "25/1/1998");
        Employee employee8 = new Employee("Nguyen Van H", "Nam", "24/1/1998");
        employeeList.add(employee8);
        employeeList.add(employee7);
        employeeList.add(employee6);
        employeeList.add(employee5);
        employeeList.add(employee4);
        employeeList.add(employee3);
        employeeList.add(employee2);
        employeeList.add(employee1);
        Queue<Employee> maleEmployee = new LinkedList<>();
        Queue<Employee> femaleEmployee = new LinkedList<>();

        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getGender().equals("Nam")) {
                maleEmployee.offer(employeeList.get(i));
            } else {
                femaleEmployee.offer(employeeList.get(i));
            }
        }

        for (Employee i : maleEmployee){
            System.out.println(i.toString());
        }

        for (Employee i : femaleEmployee){
            System.out.println(i.toString());
        }
    }
}
