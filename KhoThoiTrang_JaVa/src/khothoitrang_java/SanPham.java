/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khothoitrang_java;

/**
 *
 * @author Admin
 */
public class SanPham {
    private int id;
    private String maSP,tenSP,kichCo,chiTietSP,ngaySX;
    
     public SanPham(String maSP, String tenSP,String kichCo, String chiTietSP, String ngaySX) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.kichCo = kichCo;
        this.chiTietSP = chiTietSP;
        this.ngaySX =  ngaySX;
    }

    public SanPham() {
    }

    public SanPham(int id, String maSP, String tenSP,String kichCo, String chiTietSP, String ngaySX) {
        this.id = id;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.kichCo = kichCo;
        this.chiTietSP = chiTietSP;
        this.ngaySX =  ngaySX;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getKichCo() {
        return kichCo;
    }

    public void setKichCo(String kichCo) {
        this.kichCo = kichCo;
    }

    public String getChiTietSP() {
        return chiTietSP;
    }

    public void setChiTietSP(String chiTietSP) {
        this.chiTietSP = chiTietSP;
    }

    public String getNgaySX() {
        return ngaySX;
    }

    public void setNgaySX(String ngaySX) {
        this.ngaySX = ngaySX;
    }

    
    // chạy trên console xây dụng phg thức  bên dưới
     @Override
    public String toString() {
        return "{" + "id=" + id + ", maSP=" + maSP + ", tenSP=" + tenSP + ", kichCo=" + kichCo + ", chiTietSP=" + chiTietSP + ", ngaySX=" + ngaySX + '}';
    }
    
   
}
