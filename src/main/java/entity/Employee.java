package entity;

import util.DateTimeUtil;

import java.util.Calendar;
import java.util.Date;

public class Employee {
    private String account;
    private String password;
    private String name;
    private String email;
    private String address;
    private Date createAt;
    private Date updateAt;
    private int status;

    public Employee() {
    }

    public Employee(String account, String password, String name, String email, String address, int status) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.email = email;
        this.address = address;
        this.createAt = getDateNowFormat();
        this.updateAt = getDateNowFormat();
        this.status = status;
    }

    public Employee(String account, String password, String name, String email, String address, String updateAt, int status) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.email = email;
        this.address = address;
        this.createAt = getCreateAt();
        this.updateAt = DateTimeUtil.parseDateString(updateAt);
        this.status = status;
    }

    public Employee(String account, String password, String name, String email, String address, Date createAt, Date updateAt, int status) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.email = email;
        this.address = address;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.status = status;
    }

    private Date getDateNowFormat(){
        Date dateUnFormat = Calendar.getInstance().getTime();
        String dateFormat = DateTimeUtil.formatDateToString(dateUnFormat); // chuyển thành String để lấy format
        return  DateTimeUtil.parseDateString(dateFormat); // Sau đó chuyển lại về Date
    }

    public String getCreateAtString(){
        return DateTimeUtil.formatDateToString(this.createAt);
    }
    public String getUpdateAtString(){
        return DateTimeUtil.formatDateToString(this.updateAt);
    }

    @Override
    public String toString() {
        return String.format("%5s%8s%5s | %1s%21s%14s | %5s%30s%15s | %8s%10s%7s | %5s%15s%5s | %5s%15s%5s | %5s%10s%5s | %5s%10s%5s\n",
                "",account, "",
                "",password, "",
                "",name, "",
                "",email, "",
                "",address, "",
                "",getCreateAtString(), "",
                "",getUpdateAtString(), "",
                "",status, "");
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
