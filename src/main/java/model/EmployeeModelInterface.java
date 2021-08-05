package model;

import entity.Employee;

public interface EmployeeModelInterface {
    boolean register(Employee emp);
    boolean checkExistAccount(String account);
    Employee login(String account, String password);
    Employee findByAccount(String account);
}
