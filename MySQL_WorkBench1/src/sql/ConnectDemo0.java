/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

/**
 *
 * @author Admin
 */
public class ConnectDemo0 {
     
    public static void main(String[] args) {
        Connection con = null;
        try {
            //nạp drive bằng class.forname("tên của drive"). Tên drive quyết định khi ta tải drive đó về và đặt vào 1 vị trí
            //com.mysql.jdbc.Driver tương ứng vs hệ qtcsdl mysql
            Class.forName("com.mysql.jdbc.Driver");
            // để thiết lập kết nối ta sd phg thức getConnection của lớp DriverManager
            // khi đó trả về vs dạng ("đg dẫn url", "ten", " matkhau") 
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbsinhvien","TuanPiPo","26122000");
        }// ngoại lệ ClassNotFoundException trong trg hợp cái tên k tg ứng vs drive chúng ta đã dowload về
        catch (ClassNotFoundException e) {
            // in ra dấu vết của đối tượng e
            e.printStackTrace();
        }
        //
        catch (SQLException e1) {
            e1.printStackTrace();
        }
        try {
            // khởi tạo đối tượng statement
            Statement stm = con.createStatement();
            String sql1 = "select * from sinhvien";
            // giống như con trỏ, trỏ tới từng thành phần trong bảng
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
           
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
             
             
             
}
