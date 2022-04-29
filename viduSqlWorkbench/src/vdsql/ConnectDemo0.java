/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vdsql;

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

public class ConnectDemo0 {

    public static void main(String[] args) {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhvien","root","");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e1) {
            e1.printStackTrace();
        }
        try {
            Statement stm = con.createStatement();
            String sql1 = "select * from sinhvien";
            ResultSet rs = stm.executeQuery(sql1);
            while(rs.next()){
            System.out.print(rs.getInt(1));
            System.out.print(rs.getString("hoten"));
            System.out.print(rs.getString("diachi"));
            System.out.print(rs.getString(4));
            System.out.print(rs.getInt(5));
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
