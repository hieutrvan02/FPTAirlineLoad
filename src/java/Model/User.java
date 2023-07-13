package Model;

import java.util.Date;

public class User {

    private String userID, email, password, name, gender;
    private Date birthday;
    private String phone, address, nationality, cccd, role;

    public User() {
    }

    public User(String userID, String email, String password, String name, String gender, Date birthday, String phone, String address, String nationality, String cccd, String role) {
        this.userID = userID;
        this.email = email;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.address = address;
        this.nationality = nationality;
        this.cccd = cccd;
        this.role = role;
    }

    public User(String cusName, String gender, String phone, String email, String address, String nation, String cccd) {
        this.name = cusName;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.nationality = nation;
        this.cccd = cccd;
    }

    public User(String cusName, String phone, String email, String cccd) {
        this.name = cusName;
        this.phone = phone;
        this.email = email;
        this.cccd = cccd;
    }

    public User(String userID, String email, String name, String gender, Date birthday, String phone, String address, String nationality, String cccd) {
        this.userID = userID;
        this.email = email;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.address = address;
        this.nationality = nationality;
        this.cccd = cccd;
    }
    
    

//    public User(String userID, String email, String password, String role) {
//        this.userID = userID;
//        this.email = email;
//        this.password = password;
//        this.role = role;
//    }
    public String getUserID() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getNationality() {
        return nationality;
    }

    public String getCccd() {
        return cccd;
    }

    public String getRole() {
        return role;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
