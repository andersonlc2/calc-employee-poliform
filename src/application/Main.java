package application;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Employee> employeeList = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();
        for (int i=1; i<=n; i++) {
            System.out.printf("Employee #%d data: %n", i);
            System.out.print("Outsourced (y/n)? ");
            char isOutsourced = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Hours: ");
            int hours = sc.nextInt();
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            double additional = 0.0;
            if (isOutsourced == 'y') {
                System.out.print("Additional charge: ");
                additional = sc.nextDouble();
            }
            Employee employee = isOutsourced == 'y'?
                    new OutsourcedEmployee(name, hours, valuePerHour, additional):
                    new Employee(name, hours,valuePerHour);
            employeeList.add(employee);
        }
        System.out.println();
        System.out.println("PAYMENTS");
        for (Employee e : employeeList) {
            System.out.println(e);
        }
    }
}
