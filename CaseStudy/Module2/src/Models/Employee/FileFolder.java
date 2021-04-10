package Models.Employee;

import java.util.Scanner;
import java.util.Stack;

public class FileFolder {
    private static Stack<Employee> employeeStack = new Stack<Employee>();
    public static void searchEmployee(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input name of the employee you want to check: ");
        String name = scanner.nextLine();
        Employee.readEmployee();
        for(Employee e : Employee.employeeArrayList){
            employeeStack.push(e);
        }
        int check = 0;
        while(!employeeStack.isEmpty()){
            Employee e = employeeStack.pop();
            if(e.getName().equals(name)){
                check++;
                System.out.println(e.toString() + "\n");
            }
        }
        if(check == 0){
            System.out.println("No employee with the name \"" + name + "\" found." );
        }
    }
}
