/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bt_qlbh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen Tuan Anh
 */
public class ChucNangKH {
    
    // Lấy danh sách customer
    public static List<KhachHang> getCustomerList(String s){
        // Tạo biến
        List<KhachHang> dataList = new ArrayList<>();
        Connection conn =  null;
        PreparedStatement statement = null;
        try {
            conn = DriverManager.getConnection(Config.URL_DB, Config.USENAME, Config.PASSWORD);
            
            // Truy vấn dữ liệu mySQL
            String sql = "select * from customer";
            
            // Kiểm tra chuỗi truyền vào
            if(s != null && !s.isEmpty()){
                sql += " where fullname like ?";
            }
            
            statement = conn.prepareStatement(sql);
            if(s!=null && !s.isEmpty()){
                statement.setString(1, s);
            }
            
            // Lưu các khách hàng vào biến reultset khi thực hiện statement
            ResultSet resultSet = statement.executeQuery();
            
            // Lấy từng bản ghi ra để lưu vào dataList
            while(resultSet.next()){
                KhachHang customer = new KhachHang(resultSet.getInt("ID"), resultSet.getString("FullName"),
                        resultSet.getString("Birthday"), resultSet.getString("Email"),
                        resultSet.getString("Phone_Number"), resultSet.getString("Address"),
                        resultSet.getString("PassWord"));
                dataList.add(customer);
            }
        } catch (SQLException e) {
             Logger.getLogger(ChucNangKH.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            // Bắt sự kiện statement
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    
                    Logger.getLogger(ChucNangKH.class.getName()).log(Level.SEVERE, null, e);
                }
            }

            // Bắt sự kiện connection
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    Logger.getLogger(ChucNangKH.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return dataList;
    }
    //==============================================================================================================
    
    // Thêm khách hàng
    public static void insertCustomer(KhachHang customer){
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection(Config.URL_DB, Config.USENAME, Config.PASSWORD);
            String sql = "insert into customer(FullName, Birthday, Email, Phone_Number, Address, PassWord) " + "value(?, ?, ?, ?, ?, ?)";
            
            statement = conn.prepareStatement(sql);
            
            // set dữ liệu cho 6 cột dữ liệu
            statement.setString(1, customer.getFullName());
            statement.setString(2, customer.getBirthday());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getPhoneNumber());
            statement.setString(5, customer.getAddress());
            statement.setString(6, customer.getPass());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ChucNangKH.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucNangKH.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucNangKH.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //==========================================================================
    
    // Chức năng cập nhật khách hàng
    public static void updateCustomer(KhachHang customer){
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection(Config.URL_DB, Config.USENAME, Config.PASSWORD);
            
            String sql = "update customer set FullName = ?, Birthday = ?, Email = ?, Phone_Number = ?, Address = ?, PassWord = ? where ID = ?";
            statement = conn.prepareStatement(sql);
            
            // Set dữ liệu cho 6 cột customer trong table ở giao diện
            statement.setString(1, customer.getFullName());
            statement.setString(2, customer.getBirthday());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getPhoneNumber());
            statement.setString(5, customer.getAddress());
            statement.setString(6, customer.getPass());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ChucNangKH.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucNangKH.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucNangKH.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
// Chức năng xóa khách hàng
    public static void deleteCustomer(int ID){
        Connection conn = null;
        PreparedStatement statement = null;
       
        try {
            conn = DriverManager.getConnection(Config.URL_DB, Config.USENAME, Config.PASSWORD);
            String sql = "delete from customer where id = ?";
            
            statement = conn.prepareStatement(sql);
            
            statement.setInt(1, ID);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ChucNangKH.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucNangKH.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucNangKH.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
}
