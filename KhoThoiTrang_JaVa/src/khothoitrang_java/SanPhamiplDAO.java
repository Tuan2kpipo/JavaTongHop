/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khothoitrang_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class SanPhamiplDAO implements SanPhamDAO{
     private String urlDB, userName, passWord;
    private String diverName = "com.mysql.jdbc.Driver";
    private String selectall = "select * from sanpham";
    private String sqlInsert = "Insert into sanpham (maSP,tenSP,kichCo,chiTietSP,ngaySX) values (?,?,?,?,?)";
    private String sqlUpdate = "update sanpham set maSP=?,tenSP=?,kichCo=?,chiTietSP=?, ngaySX=? where id=?";
    private String sqlDelete = "delete from sanpham where ID=?";
    private String sqlFindByID = "select * from sanpham  where id=?";
    private String sqlFindByName = "select *from sanpham where tensp=?";

    public SanPhamiplDAO(String _urlDB, String _userName, String _passWord) {
        this.urlDB = _urlDB;
        this.userName = _userName;
        this.passWord = _passWord;
        try {
            // load driver
            Class.forName(diverName);
        } catch (ClassNotFoundException e1) {
            System.out.println("loi driver");
            e1.printStackTrace();
        }
    }

    // dong ketnoi
    private static void  closeConnec(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // dong statement
    private static void closeStatement(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
    
    // dong resultset
    private static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    // phuong thuc getconnection
    private Connection getConnection() {
        try {           
            return DriverManager.getConnection(urlDB, userName, passWord);
        } catch (Exception e) {
            e.printStackTrace();
           
        }
        return null;
    }

    // muc dich hien thi dl trong csdl len jtable
    public ArrayList<SanPham> getAllSanPham() {

        Connection con = getConnection();
        Statement st = null;
        ArrayList<SanPham> listAll = new ArrayList<SanPham>();
        ResultSet rs = null;
        if (con != null) {
            try {
                st = con.createStatement();
                rs = st.executeQuery(selectall);
                while (rs.next()) {
                    SanPham sp = new SanPham(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                    listAll.add(sp);
                }                
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeResultSet(rs);
                closeStatement(st);
                closeConnec(con);                
            }
        }
        return listAll;
    }

    public void insert(SanPham sp) {
        Connection con = getConnection();
        PreparedStatement pr = null;
        if (con != null) {
            try {
                pr = con.prepareStatement(sqlInsert);
                //  pr.setInt(1, _id);
                pr.setString(1, sp.getMaSP());
                pr.setString(2, sp.getTenSP());
                pr.setString(3, sp.getKichCo());
                pr.setString(4, sp.getChiTietSP());
                pr.setString(5, sp.getNgaySX());
                System.out.println(pr.toString());
                pr.executeUpdate();
                pr.close();
            } catch (SQLException e) {
                
                e.printStackTrace();
            } finally {                
                closeConnec(con);
            }

        }
    }

    public void updateSanPham(SanPham sp) {
        Connection con = getConnection();
        PreparedStatement pr = null;
        try {
            pr = con.prepareStatement(sqlUpdate);
            pr.setString(1, sp.getMaSP());
            pr.setString(2, sp.getTenSP());
            pr.setString(3, sp.getKichCo());
            pr.setString(4, sp.getChiTietSP());
            pr.setString(5, sp.getNgaySX());
            pr.setInt(6, sp.getId());
            pr.executeUpdate();
            pr.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            closeConnec(con);
        }
    }

    public boolean DeleteSanPham(SanPham sp) {
        Connection con = getConnection();
        PreparedStatement pr = null;
        int k = 0;
        try {
            pr = con.prepareStatement(sqlDelete);
            pr.setInt(1, sp.getId());
            k = pr.executeUpdate();
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            closeConnec(con);
        }
        if (k > 0) {
            return true;
        }
        return false;
    }

    public SanPham findSanPhamByID(int id) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = getConnection();
            stmt = con.prepareStatement(sqlFindByID);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                SanPham sp = new SanPham(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                rs.close();
                return sp;
            } else {
                return null;
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnec(con);
        }
    }

    public SanPham findByName(String name) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = getConnection();
            stmt = con.prepareStatement(sqlFindByName);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                SanPham sp = new SanPham(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                rs.close();
                stmt.close();
                return sp;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnec(con);
        }
    }

    public void showData() {
        ArrayList<SanPham> listSanPham = getAllSanPham();
        for (SanPham dt : listSanPham) {
            System.out.println(dt.toString());
        }

    }

    public static void main(String args[]) {
        SanPhamiplDAO demo = new SanPhamiplDAO("jdbc:mysql://localhost:3306/quanlykhobanhang", "root", "");

//        dienthoai dt = new dienthoai("madt05", "iphone 2000e", "sansung", "dienthoai 2026", "2000");
//         demo.insert(dt);
       // SinhVien svXoa = demo.findSinhVienByID(2);
        
//        demo.showData();
        //demo.DeleteSinhVien(svXoa);
        // System.out.println("Sau khi xoa sinh vien thu 2");
//        demo.showData();
//        dienthoai dtSua=demo.findByName("iphone 2000d");
//        dtSua.setTenDienThoai("iphone 500s");
//       demo.updatedienthoai(dtSua);
//       System.out.println("Sau khi sua ");
        demo.showData();
//        ResultSet r=demo.getData();
//         if(r!=null){
//             System.out.println("du lieu sau khi insert");
//             demo.showData(r);
//         }
    }
}
