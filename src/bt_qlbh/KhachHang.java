/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bt_qlbh;

/**
 *
 * @author Nguyen Tuan Anh
 */
public class KhachHang {
    int ID;
    String fullName, birthday, email, phoneNumber, address, pass;

    // Các hàm khởi tạo
    public KhachHang() {
    }

    public KhachHang(int ID, String fullName, String birthday, String email, String phoneNumber, String address, String pass) {
        this.ID = ID;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.birthday = birthday;
        this.pass = pass;
    }

    public KhachHang(String fullName, String birthday, String email, String phoneNumber, String address, String pass) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.birthday = birthday;
        this.pass = pass;
    }
// =====================================================================================
    // Hàm get và set ID
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
   //============================================
    
    // Hàm get và set fullName
    
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    //=============================================
    
    // Hàm get và set email
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //=============================================
    
    // Hàm get và set phoneNumber

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    //==============================================
    
    // Hàm get và set address

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    //===============================================
    
    // Hàm get và set birthday

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    //================================================
    
    // Hàm get và set pass

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    //================================================
}
