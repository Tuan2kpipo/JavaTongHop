/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_themsuaxoa_csdl;

/**
 *
 * @author Admin
 */
public class dienthoai {
    private int id;
    private String maDienThoai,tenDienThoai,hangSanXuat,thongTinChung,giaBan;

    // xây dựng constructor
    public dienthoai(String maDienThoai, String tenDienThoai,String hangSanXuat, String thongTinChung, String giaBan) {
        this.maDienThoai = maDienThoai;
        this.tenDienThoai = tenDienThoai;
        this.hangSanXuat = hangSanXuat;
        this.thongTinChung = thongTinChung;
        this.giaBan =  giaBan;
    }

    // construct mặc định
    public dienthoai() {
    }

    // constructor có id
    public dienthoai(int id, String maDienThoai, String tenDienThoai,String hangSanXuat, String thongTinChung, String giaBan) {
        this.id = id;
        this.maDienThoai = maDienThoai;
        this.tenDienThoai = tenDienThoai;
        this.hangSanXuat = hangSanXuat;
        this.thongTinChung = thongTinChung;
        this.giaBan =  giaBan;
    }

    // tuong ung voi moi doi tuong , no se tuong ung voi moi dong du lieu
    // load du lieu ra vao,tim kiem 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaDienThoai() {
        return maDienThoai;
    }

    public void setMaDienThoai(String maDienThoai) {
        this.maDienThoai = maDienThoai;
    }

    public String getTenDienThoai() {
        return tenDienThoai;
    }

    public void setTenDienThoai(String tenDienThoai) {
        this.tenDienThoai = tenDienThoai;
    }

    public String getHangSanXuat() {
        return hangSanXuat;
    }

    public void setHangSanXuat(String hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }

    public String getThongTinChung() {
        return thongTinChung;
    }

    public void setThongTinChung(String thongTinChung) {
        this.thongTinChung = thongTinChung;
    }

    public String getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(String giaBan) {
        this.giaBan = giaBan;
    }



    @Override
    public String toString() {
        return "{" + "id=" + id + ", maDienThoai=" + maDienThoai + ", tenDienThoai=" + tenDienThoai + ", hangSanXuat=" + hangSanXuat + ", thongTinChung=" + thongTinChung + ", giaBan=" + giaBan + '}';
    }
}
