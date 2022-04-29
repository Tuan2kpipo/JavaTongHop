/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_themsuaxoa_csdl ;

import sql.ConnectDemo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class dienthoaiiplDAO implements dienthoaiDAO{
    // khai báo biến url..
    // một số câu lệnh truy vấn
    private String urlDB, userName, passWord;
    private String diverName = "com.mysql.jdbc.Driver";
    private String selectall = "select * from tbl_mathang";
    private String sqlInsert = "Insert into tbl_mathang (ma_madienthoai,ten_dienthoai,hang_sanxuat,thongtinchung,giaban) values (?,?,?,?,?)";
    private String sqlUpdate = "update tbl_mathang set ma_madienthoai=?,ten_dienthoai=?,hang_sanxuat=?,thongtinchung=?, giaban=? where id=?";
    private String sqlDelete = "delete from tbl_mathang where ID=?";
    private String sqlFindByID = "select * from tbl_mathang  where id=?";
    private String sqlFindByName = "select *from tbl_mathang where ten_dienthoai=?";

    // khoi tao lop dtipldao truen vao url, username,
    public dienthoaiiplDAO(String _urlDB, String _userName, String _passWord) {
        // gan ben ngoai bằng ben trong
        this.urlDB = _urlDB;
        this.userName = _userName;
        this.passWord = _passWord;
        // khởi tạo svipldao thì đồng thời load driver bằng class.forname
        try {
            // load driver
            Class.forName(diverName);
            
        } catch (ClassNotFoundException e1) {
            System.out.println("loi driver");
            e1.printStackTrace();
        }
    }

    // dong ketnoi
    // cứ cho 1 đổi  tg connection thì ta sẽ try catch đóng nó
    private static void  closeConnec(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // dong statement
    // truyền vào là 1 đối tg statment thì sẽ thực hiện đóng statement
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
    // khởi tạo connection dựa trên  urlDB, userName, passWord của svipldao
    private Connection getConnection() {
        try {           
            return DriverManager.getConnection(urlDB, userName, passWord);
        } catch (Exception e) {
            e.printStackTrace();
           
        }
        return null;
    }

    // xây dựng phg thức getalldt
    // muc dich hien thi dl trong csdl len jtable
    // trả về 1 arrlist , ỗi phần tử là 1 sv
    public ArrayList<dienthoai> getAlldienthoai() {
// khoi tao ket noi
        Connection con = getConnection();
        // khoi tao statement
        Statement st = null;
        // kahi bao doi tg arrlist
        ArrayList<dienthoai> listAll = new ArrayList<dienthoai>();
        // kahi bao dt resultset
        ResultSet rs = null;
        // neu ketnoi khac rong thì khoi tạo statement
        if (con != null) {
            try {
                // khoi tai statement
                st = con.createStatement();
                // gan resault = statement và thực thu câu lệnh selectall
                rs = st.executeQuery(selectall);
                // sau khi thực thi selectall sẽ trả về 1 tập các bản ghi
                // ta sẽ duyệt resault từ trên xuống dứi rs.next()
                while (rs.next()) {
                     // với mỗi bản ghi sẽ khởi tạo đối tg dt
                    dienthoai dt = new dienthoai(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                   // add đối tg vào listall
                    listAll.add(dt);
                }                
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // khi truy vấn xong thì sẽ đống
                // mở thì từ con-st-rs
                // đóng thì từ rs-st-con
             
                closeResultSet(rs);
                closeStatement(st);
                closeConnec(con);                
            }
        }
        // cuối cùng return listall
        return listAll;
    }

    // phg thức thêm 1 bản ghi
    public void insert(dienthoai dt) {
        Connection con = getConnection();
        PreparedStatement pr = null;
        if (con != null) {
            try {
                // lấy về sqlInsert
                pr = con.prepareStatement(sqlInsert);
                //  pr.setInt(1, _id);
                // thự hiện thay thế các dấu chấm hỏi bằng các thuộc tính getMaDienThoai...
                pr.setString(1, dt.getMaDienThoai());
                pr.setString(2, dt.getTenDienThoai());
                pr.setString(3, dt.getHangSanXuat());
                pr.setString(4, dt.getThongTinChung());
                pr.setString(5, dt.getGiaBan());
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

    // phg thức update
    public void updatedienthoai(dienthoai dt) {
        Connection con = getConnection();
        PreparedStatement pr = null;
        try {
            pr = con.prepareStatement(sqlUpdate);
             pr.setString(1, dt.getMaDienThoai());
             pr.setString(2, dt.getTenDienThoai());
             pr.setString(3, dt.getHangSanXuat());
             pr.setString(4, dt.getThongTinChung());
             pr.setString(5, dt.getGiaBan());
            pr.setInt(6, dt.getId());
            pr.executeUpdate();
            pr.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            closeConnec(con);
        }
    }

    public boolean Deletedienthoai(dienthoai dt) {
        Connection con = getConnection();
        PreparedStatement pr = null;
        int k = 0;
        try {
            pr = con.prepareStatement(sqlDelete);
            pr.setInt(1, dt.getId());
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

    public dienthoai finddienthoaiByID(int id) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = getConnection();
            stmt = con.prepareStatement(sqlFindByID);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                dienthoai sv = new dienthoai(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                rs.close();
                return sv;
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

    public dienthoai findByName(String name) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = getConnection();
            stmt = con.prepareStatement(sqlFindByName);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                dienthoai sv = new dienthoai(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                rs.close();
                stmt.close();
                return sv;
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
        ArrayList<dienthoai> listdienthoai = getAlldienthoai();
//        for(int i=0;i<listSinhVien.size();i++)
//        {SinhVien sv=listSinhVien.get(i);
//            System.out.println(sv.toString());
//        }
        for (dienthoai dt : listdienthoai) {
            System.out.println(dt.toString());
        }

    }

    public static void main(String args[]) {
        dienthoaiiplDAO demo = new dienthoaiiplDAO("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");

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
