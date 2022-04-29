/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khothoitrang_java;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */

// phác thảo thiết kế mẫ
public interface SanPhamDAO {
    public ArrayList<SanPham> getAllSanPham();

    public void insert(SanPham sp);

    public void updateSanPham(SanPham sp);

    public boolean DeleteSanPham(SanPham sp);

    public SanPham findSanPhamByID(int id);

    public SanPham findByName(String name);
}
