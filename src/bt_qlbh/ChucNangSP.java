/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bt_qlbh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tuana
 */
public class ChucNangSP {
    // Lấy danh sách sản phẩm quần áo
    public static List<SanPham> getProductsList(String s){
        List<SanPham> productList = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection(Config.URL_DB, Config.USENAME, Config.PASSWORD);
            String sql = "select * from products";
            
            // kiểm tra chuỗi truyền vào
            if(s!=null && !s.isEmpty()){
                sql += " where nameproduct like ?";
            }
            
            statement = conn.prepareStatement(sql);
            if(s!=null && !s.isEmpty()){
                statement.setString(1, s);
            }
            
            // Lưu các sản phẩm vào biến reultset khi thực hiện statement
            ResultSet resultset = statement.executeQuery();
            
            // Lấy các sản phẩm đã lưu trong resultset
            while(resultset.next()){
                SanPham product = new SanPham(resultset.getString("ID"), resultset.getString("NameProduct"),
                   resultset.getString("Mau"), resultset.getString("NgayNhap"), resultset.getInt("Soluong"),
                   resultset.getFloat("GiaBan"), resultset.getFloat("GiaMua")
                );
                
                productList.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChucNangSP.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucNangSP.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucNangSP.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return productList;
    }
//=======================================================================================================    
    
    // Thêm sản phẩm vào danh sách
    public static void insertProduct(SanPham product){
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection(Config.URL_DB, Config.USENAME, Config.PASSWORD);
            String sql = "insert into products(ID, NameProduct, Mau, NgayNhap, Soluong, GiaBan, GiaMua) " + "value(?,?,?,?,?,?,?)";
            
            statement = conn.prepareStatement(sql);
            
            // Set 6 cột dữ liệu
            statement.setString(1, product.getId());
            statement.setString(2, product.getNameproduct());
            statement.setString(3, product.getMau());
            statement.setString(4, product.getNgaynhap());
            statement.setInt(5, product.getSoluong());
            statement.setFloat(6, product.getGiaban());
            statement.setFloat(7,product.getGiamua());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ChucNangSP.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucNangSP.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucNangSP.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
//=============================================================================================    
    
    // Xóa sản phẩm khỏi danh sách
    public static void delProducts(int ID){
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection(Config.URL_DB, Config.USENAME, Config.PASSWORD);
            String sql = "delete from customer where id = ?";
            
            statement = conn.prepareStatement(sql);
            
            statement.setInt(1, ID);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ChucNangSP.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucNangSP.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucNangSP.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
//======================================================================================================
    
    // Cập nhật sản phẩm trong danh sách
    public static void updateProducts(SanPham product){
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection(Config.URL_DB, Config.USENAME, Config.PASSWORD);
            String sql = "update products set ID = ?, NameProduct = ?, Mau = ?, NgayNhap = ?, SoLuong = ?, GiaBan = ?, GiaMua = ?";
            statement = conn.prepareStatement(sql);
            
            // Set các cột trong bảng product
            statement.setString(1, product.getId());
            statement.setString(2, product.getNameproduct());
            statement.setString(3, product.getMau());
            statement.setString(4, product.getNgaynhap());
            statement.setInt(5, product.getSoluong());
            statement.setFloat(6, product.getGiaban());
            statement.setFloat(7, product.getGiamua());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ChucNangSP.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucNangSP.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucNangSP.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
