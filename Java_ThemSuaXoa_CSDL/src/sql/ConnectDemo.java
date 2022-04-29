/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

/**
 *
 * @author 84989
 */
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDemo {

    public static void main(String[] args) {
        Connection con = null;
        try {
            // nạp driver ( bắt buộc đặt trong try catch)
           // Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang","root","");
            
            // nếu nạp drive thì exception là classnotfoundexception
//        } catch (ClassNotFoundException e) {
                // in ra dấu vết của đối tg e để tìm ra ngoại lệ
//            e.printStackTrace();
        }
       
        catch (SQLException e1) {
            e1.printStackTrace();
        }
        try {
            // khoi tạo đối tg statement
            Statement stm = con.createStatement();
            String sql1 = "select * from tbl_mathang";
            ResultSet rs = stm.executeQuery(sql1);
            while(rs.next()){
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
            System.out.println(rs.getString(4));
            System.out.println(rs.getString(5));
            System.out.println(rs.getString(6));
                System.out.println("");
            }
            rs.close();
            stm.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}