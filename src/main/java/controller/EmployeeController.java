package controller;

import entity.Employee;
import model.EmployeeModel;
import model.EmployeeModelInterface;

import java.util.List;
import java.util.Scanner;

public class EmployeeController implements EmployeeControllerInterface {
    private EmployeeModelInterface employeeModel;
    private Scanner scanner;

    public EmployeeController() {
        this.employeeModel = new EmployeeModel();
        this.scanner = new Scanner(System.in);
    }

// Validate Start
    // check Acount Start
    private boolean checkInputacount(String account){
        if (account.equals("")){
            System.out.println("Please Enter account");
            return false;
        } else if (account.length() > 10){
            System.out.println("account <= 10, Please Enter Again");
            return false;
        } else if (employeeModel.checkExistAccount(account)){
            System.out.println("This id existed, Please Enter Again");
            return false;
        }
        return true;
    }
    // check Acount End

    // check Password Start
    private boolean checkInputpassword(String password){
        if (password.equals("")){
            System.out.println("Please Enter password");
            return false;
        }
        return true;
    }
    // check Password End

    // check Name Start
    private boolean checkInputname(String name){
        if (name.equals("")){
            System.out.println("Please Enter name");
            return false;
        }
        return true;
    }
    // check Name End

    // check Email Start
    private boolean checkInputemail(String email){
        if (email.equals("")){
            System.out.println("Please Enter email");
            return false;
        }
        return true;
    }
    // check Email End

    // check Address Start
    private boolean checkInputaddress(String address){
        if (address.equals("")){
            System.out.println("Please Enter address");
            return false;
        }
        return true;
    }
    // check Address End

    // check int Start
    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false; // Nhập chữ trả về false
        }
        return true;
    }
    // check int End

    //  check Input Status Start
    private boolean checkInputStatus(int status){
        if (status >1 || status < 0){
            return false;
        }
        return true;
    }

    private boolean checkInputStatusInt(String statusInt){
        if (statusInt.equals("")){
            System.out.println("Please Enter 0. UnChecked, 1. Checked");
            return false;
        }
        return true;
    }
    //  check Input Status End
// Validate End

    @Override
    public void create() {
        System.out.println("Create Employee  Shop");

        System.out.println("Enter acount, acount lenght <= 10: ");
        String account;
        while (true){
            account = scanner.nextLine();
            if (checkInputacount(account)){
                break;
            }
        }

        System.out.println("Enter password");
        String password;
        while (true){
            password = scanner.nextLine();
            if (checkInputpassword(password)){
                break;
            }
        }

        System.out.println("Enter name");
        String name;
        while (true){
            name = scanner.nextLine();
            if (checkInputname(name)){
                break;
            }
        }

        System.out.println("Enter email");
        String email;
        while (true){
            email = scanner.nextLine();
            if (checkInputemail(email)){
                break;
            }
        }

        System.out.println("Enter adress");
        String address;
        while (true){
            address = scanner.nextLine();
            if (checkInputaddress(address)){
                break;
            }
        }

        System.out.println("Status Date Order: ");
        int statusInt ;
        System.out.println("Please Enter 0. UnChecked, 1. Checked");
        while (true){
            String status = scanner.nextLine();
            if (checkInputStatusInt(status)){
                if (isInteger(status) && checkInputStatus(Integer.valueOf(status))){
                    statusInt = Integer.valueOf(status);
                    System.out.println("OK\n");
                    break;
                }
                else if (isInteger(status) && !checkInputStatus(Integer.valueOf(status)) ) {
                    System.out.println("Enter Wrong, 0. UnChecked, 1. Checked");
                } else {
                    System.out.println("This is not a number");
                }
            }
        }

        Employee employee = new Employee(account, password, name, email, address, statusInt);
        if (employeeModel.register(employee)){
            System.out.println("Action success");
        }else {
            System.out.println("Action failse");
        }
    }

//    @Override
//    public void search() {
//        System.out.println("Search Employee by Account");
//        System.out.println("Enter Account");
//        String account = scanner.nextLine();
//        if (!employeeModel.checkExistAccount(account)){
//            System.out.println("Not found");
//        } else {
//            Employee employee = employeeModel.findByAccount(account);
//            System.out.println("Found");
//            System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------");
//            System.out.printf("%5s%8s%5s | %1s%21s%14s | %5s%30s%15s | %8s%10s%7s | %5s%15s%5s | %5s%15s%5s | %5s%10s%5s | %5s%10s%5s\n",
//                    "","Account", "",
//                    "","Password", "",
//                    "","Name", "",
//                    "","Email", "",
//                    "","Address", "",
//                    "","Create At", "",
//                    "","Update At", "",
//                    "","Status", "");
//            System.out.println(employee.toString());
//            System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------");
//        }
//    }

    @Override
    public void login() {
        System.out.println("Login Employee");
        System.out.println("Enter Account");
        String account = scanner.nextLine();
        if (!employeeModel.checkExistAccount(account)){
            System.out.println("Account is not Exist ");
        } else {
            System.out.println("Enter Password");
            String password = scanner.nextLine();
            if (employeeModel.login(account,password)==null){
                System.out.println("Login fail, Please check your info account and password");
            } else {
                Employee employee = employeeModel.findByAccount(account);
                System.out.println("Found");
                System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("%5s%8s%5s | %1s%21s%14s | %5s%30s%15s | %8s%10s%7s | %5s%15s%5s | %5s%15s%5s | %5s%10s%5s | %5s%10s%5s\n",
                        "","Account", "",
                        "","Password", "",
                        "","Name", "",
                        "","Email", "",
                        "","Address", "",
                        "","Create At", "",
                        "","Update At", "",
                        "","Status", "");
                System.out.println(employee.toString());
                System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------");

            }
        }
    }
}
