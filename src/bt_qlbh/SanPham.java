/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bt_qlbh;

/**
 *
 * @author tuana
 */
public class SanPham {
    int soluong;
    float giaban, giamua;
    String nameproduct, ngaynhap, mau,id;

    // Các hàm khởi tạo
    public SanPham() {
    }

    public SanPham(String id, String nameproduct, String mau, String ngaynhap, int soluong, float giaban, float giamua) {
        this.id = id;
        this.soluong = soluong;
        this.giaban = giaban;
        this.giamua = giamua;
        this.nameproduct = nameproduct;
        this.ngaynhap = ngaynhap;
        this.mau = mau;
    }

    public SanPham(String nameproduct, String mau, String ngaynhap, int soluong, float giaban, float giamua) {
        this.soluong = soluong;
        this.giaban = giaban;
        this.giamua = giamua;
        this.nameproduct = nameproduct;
        this.ngaynhap = ngaynhap;
        this.mau = mau;
    }
    
    //==================================================
    // Set và get ID
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    
    //==================================================
    // set và get nameproduct
    public void setNameproduct(String nameproduct) {
        this.nameproduct = nameproduct;
    }

    public String getNameproduct() {
        return nameproduct;
    }
    
    //==================================================
    // set và get mau
    public void setMau(String mau) {
        this.mau = mau;
    }

    public String getMau() {
        return mau;
    }
    
    //==================================================
    
    // set và get ngaynhap
    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }
    //=====================================================
    
    // set và get giaban
    public void setGiaban(float giaban) {
        this.giaban = giaban;
    }

    public float getGiaban() {
        return giaban;
    }
    
    // ==================================================
    
    // set và get giamua
    public void setGiamua(float giamua) {
        this.giamua = giamua;
    }

    public float getGiamua() {
        return giamua;
    }
    
    //=============================================
    
    // set và get soluong
    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getSoluong() {
        return soluong;
    }
    
}
