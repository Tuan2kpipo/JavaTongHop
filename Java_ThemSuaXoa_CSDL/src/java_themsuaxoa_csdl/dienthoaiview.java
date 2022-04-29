/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_themsuaxoa_csdl;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class dienthoaiview extends JFrame {
    JButton btnThem, btnSua, btnXoa, btnClear;
    JTextField txtID, txtMaDienThoai, txtTenDienThoai, txtHangSanXuat, txtThongTinChung,txtGiaBan;
    JScrollPane tblPane;
    Panel southPane, textPane, buttonPane;
    JTable table;
// phg thức showdt truyền vào là tablemodel
    public void showListdienthoai(dienthoaiTableModel dienthoaiModel) {
        //table = new JTable(sinhvienModel);
        table.setModel(dienthoaiModel);
        // điều chỉnh độ rộng
        table.getColumnModel().getColumn(0).setPreferredWidth(20);
        table.getColumnModel().getColumn(1).setPreferredWidth(70);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);

        
    }
public void showdienthoai(dienthoai dt) {
        txtID.setText("" + dt.getId());
        txtMaDienThoai.setText(dt.getMaDienThoai());
        txtTenDienThoai.setText("" + dt.getTenDienThoai());
        txtHangSanXuat.setText(dt.getHangSanXuat());
        txtThongTinChung.setText("" + dt.getThongTinChung());
        txtGiaBan.setText("" + dt.getGiaBan());

        btnSua.setEnabled(true);
        btnXoa.setEnabled(true);
   
        btnThem.setEnabled(false);
    }
    public dienthoaiview() {
        
      
        
            
        table = new JTable();

        
    
        buttonPane = new Panel(new FlowLayout());
        btnThem = new JButton("Thêm");
        btnSua = new JButton("Sửa");
        btnXoa = new JButton("Xóa");
        btnClear = new JButton("Clear");
     
        buttonPane.add(btnThem);
        buttonPane.add(btnSua);
        buttonPane.add(btnXoa);
        buttonPane.add(btnClear);
        
        textPane = new Panel(new GridLayout(3, 2));
        txtID = new JTextField(15);
        txtMaDienThoai = new JTextField(15);
        txtTenDienThoai = new JTextField(15);
        txtHangSanXuat = new JTextField(15);
        txtThongTinChung = new JTextField(15);
        txtGiaBan = new JTextField(15);
        textPane.add(new JLabel("ID:"));
        textPane.add(txtID);
        txtID.enable(false);
        textPane.add(new JLabel("Mã DT:"));
        textPane.add(txtMaDienThoai);
        textPane.add(new JLabel("Tên DT:"));
        textPane.add(txtTenDienThoai);
        textPane.add(new JLabel("Hãng SX:"));
        textPane.add(txtHangSanXuat);
        textPane.add(new JLabel("Thông Tin "));
        textPane.add(txtThongTinChung);
        textPane.add(new JLabel("Gía Bán: "));
        textPane.add(txtGiaBan);

        southPane = new Panel(new BorderLayout());
        southPane.add(buttonPane, BorderLayout.NORTH);
        southPane.add(textPane, BorderLayout.CENTER);
        
        tblPane = new JScrollPane(table);
        this.getContentPane().add(tblPane, BorderLayout.CENTER);
        this.getContentPane().add(southPane, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setSize(700, 500);
        
        
   
    }
// bắt sự kiện cho bảng
    public void filldienthoaiFromSelectedRow() {
        // lấy chỉ số của hàng được chọn  traả về số dòng ng dùng trọn
        int row = table.getSelectedRow();
        // nêu > 0
        if (row >= 0) {
            // lấy dl từ table điền vào textview
            txtID.setText(table.getModel().getValueAt(row, 0).toString());
            txtMaDienThoai.setText(table.getModel().getValueAt(row, 1).toString());
            txtTenDienThoai.setText(table.getModel().getValueAt(row, 2).toString());
            txtHangSanXuat.setText(table.getModel().getValueAt(row, 3).toString());
            txtThongTinChung.setText(table.getModel().getValueAt(row, 4).toString());
            txtGiaBan.setText(table.getModel().getValueAt(row, 5).toString());
            // enable Edit and Delete buttons
            btnThem.setEnabled(false);
            btnXoa.setEnabled(true);
            btnSua.setEnabled(true);
            btnClear.setEnabled(true);
           
        }
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void cleardienthoaiInfo() {
        txtID.setText("");
        txtMaDienThoai.setText("");
        txtTenDienThoai.setText("");
        txtHangSanXuat.setText("");
        txtThongTinChung.setText("");
        txtGiaBan.setText("");
        
        btnXoa.setEnabled(false);
        btnSua.setEnabled(false);
        btnThem.setEnabled(true);
    }

    public dienthoai getdienthoaiInfo() {
      
        try {
            dienthoai dt = new dienthoai();
            if (txtID.getText() != null && !"".equals(txtID.getText())) {
                dt.setId(Integer.parseInt(txtID.getText()));
            }
            dt.setMaDienThoai(txtMaDienThoai.getText().trim());
            dt.setTenDienThoai(txtTenDienThoai.getText().trim());
            dt.setHangSanXuat(txtHangSanXuat.getText().trim());
            dt.setThongTinChung(txtThongTinChung.getText().trim());
            dt.setGiaBan(txtGiaBan.getText().trim());
            return dt;
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }

    // đăng kí đối tg lắng nghe cho nút thêm sử xóa...
    public void addInsertdienthoaitListener(ActionListener listener) {
        btnThem.addActionListener(listener);
    }

    public void addUpdatedienthoaiListener(ActionListener listener) {
        btnSua.addActionListener(listener);
    }

    public void addDeletedienthoaiListener(ActionListener listener) {
        btnXoa.addActionListener(listener);
  
    }
    public void addCleardienthoaiListener(ActionListener listener) {
        btnClear.addActionListener(listener);
       
    }

    public void addListdienthoaiSelectionListener(ListSelectionListener listener) {
        table.getSelectionModel().addListSelectionListener(listener);
    }
}
