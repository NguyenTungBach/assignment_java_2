package view;

import controller.EmployeeController;
import controller.EmployeeControllerInterface;

import java.util.Scanner;

public class EmployeeViewImplement implements EmployeeView{
    private EmployeeControllerInterface employeeController;
    private Scanner scanner;

    public EmployeeViewImplement(){
        this.employeeController = new EmployeeController();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void generateMenu() {
        while (true) {
            System.out.println("Employee Manager");
            System.out.println("==========================");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("0. Exit");
            System.out.println("==========================");
            System.out.println("Please enter your choice (0-3)");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    employeeController.create();
                    break;
                case 2:
                    employeeController.login();
                    break;
            }
            if (choice == 0){
                System.out.println("Program Manage Employee Finnish\n");
                break;
            }
        }
    }
}
