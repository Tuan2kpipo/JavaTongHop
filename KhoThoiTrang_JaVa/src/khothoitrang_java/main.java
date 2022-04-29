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
public class main {
     public static void main(String[] args) {
     SanPhamiplDAO SanPhamDAO = new SanPhamiplDAO("jdbc:mysql://localhost:3306/quanlykhothoitrang", "root", "");
        SanPhamTableModel SanPhamModel = new SanPhamTableModel(SanPhamDAO.getAllSanPham());
        SanPhamView SanPhamView = new SanPhamView();
        SanPhamController controller = new SanPhamController(SanPhamView, SanPhamModel);
        controller.showSanPhamView();
     }
}
