package model;

import entity.Employee;
import util.ConnectionHelper;
import util.DateTimeUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeModel implements EmployeeModelInterface {
    List<Employee> list = new ArrayList<>();
    @Override
    public boolean register(Employee emp) {
        try {
            Connection cnn = ConnectionHelper.getConnection();
            if (cnn == null){
                return false;
            }
            PreparedStatement preparedStatement = cnn.prepareStatement("insert into employees (account, password, name, email, address, createAt, updateAt, status) values (?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1,emp.getAccount());
            preparedStatement.setString(2,emp.getPassword());
            preparedStatement.setString(3,emp.getName());
            preparedStatement.setString(4,emp.getEmail());
            preparedStatement.setString(5,emp.getAddress());
            preparedStatement.setString(6,emp.getCreateAtString());
            preparedStatement.setString(7,emp.getUpdateAtString());
            preparedStatement.setInt(8,emp.getStatus());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Employee findByAccount(String account){
        Employee employee = null;
        try {
            Connection cnn = ConnectionHelper.getConnection();
            if (cnn == null){
                throw new SQLException("Can't open connection!");
            }
            PreparedStatement preparedStatement = cnn.prepareStatement(String.format("select * from employees where account = '%s'",account));
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                String accountFind = rs.getString("account");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                Date createdAt =  DateTimeUtil.parseDateString(rs.getString("createAt"));
                Date updateAt = DateTimeUtil.parseDateString(rs.getString("updateAt"));
                int status = rs.getInt("status");
                employee = new Employee(accountFind, password, name, email, address, createdAt, updateAt, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public boolean checkExistAccount(String account) {
        Employee employee = findByAccount(account);
        if (employee==null){
            return false;
        }
        return true;
    }

    @Override
    public Employee login(String account, String password) {
        Employee employee = null;
        try {
            Connection cnn = ConnectionHelper.getConnection();
            if (cnn == null){
                throw new SQLException("Can't open connection!");
            }
            PreparedStatement preparedStatement = cnn.prepareStatement(String.format("select * from employees where account = '%s' and password = '%s'", account, password));
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                String accountCheck = rs.getString("account");
                String passwordCheck = rs.getString("password");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                Date createdAt =  DateTimeUtil.parseDateString(rs.getString("createAt"));
                Date updateAt = DateTimeUtil.parseDateString(rs.getString("updateAt"));
                int status = rs.getInt("status");
                employee = new Employee(accountCheck, passwordCheck, name, email, address, createdAt, updateAt, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }
}
