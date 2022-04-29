/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khothoitrang_java;

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
public class SanPhamView extends JFrame {
    JButton btnThem, btnSua, btnXoa, btnClear;
    JTextField txtID, txtMaSP, txtTenSP, txtKichCo, txtChiTietSP,txtNgaySX;
    JScrollPane tblPane;
    Panel southPane, textPane, buttonPane;
    JTable table;

    public void showListSanPham(SanPhamTableModel SanPhamModel) {
        //table = new JTable(sinhvienModel);
        table.setModel(SanPhamModel);
        table.getColumnModel().getColumn(0).setPreferredWidth(20);
        table.getColumnModel().getColumn(1).setPreferredWidth(70);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
    }
public void showdienthoai(SanPham sp) {
        txtID.setText("" + sp.getId());
        txtMaSP.setText(sp.getMaSP());
        txtTenSP.setText("" + sp.getTenSP());
        txtKichCo.setText(sp.getKichCo());
        txtChiTietSP.setText("" + sp.getChiTietSP());
        txtNgaySX.setText("" + sp.getNgaySX());
        btnSua.setEnabled(true);
        btnXoa.setEnabled(true);
        btnThem.setEnabled(false);
    }
    public  SanPhamView() {

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
        
        textPane = new Panel(new GridLayout(5, 3));
        txtID = new JTextField(5);
        txtMaSP = new JTextField(10);
        txtTenSP = new JTextField(10);
        txtKichCo = new JTextField(10);
        txtChiTietSP = new JTextField(10);
        txtNgaySX = new JTextField(10);
        textPane.add(new JLabel("ID:"));
        textPane.add(txtID);
        txtID.enable(false);
        textPane.add(new JLabel("Mã SP:"));
        textPane.add(txtMaSP);
        textPane.add(new JLabel("Tên SP:"));
        textPane.add(txtTenSP);
        textPane.add(new JLabel("Kích Cỡ:"));
        textPane.add(txtKichCo);
        textPane.add(new JLabel("Chi Tiết "));
        textPane.add(txtChiTietSP);
        textPane.add(new JLabel("Ngày SX "));
        textPane.add(txtNgaySX);
        //ButtonJTextFieldControl(0);
        southPane = new Panel(new BorderLayout());
        southPane.add(buttonPane, BorderLayout.NORTH);
        southPane.add(textPane, BorderLayout.CENTER);
        //this.getContentPane().add(tblPane, BorderLayout.CENTER);
        tblPane = new JScrollPane(table);
        this.getContentPane().add(tblPane, BorderLayout.CENTER);
        this.getContentPane().add(southPane, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        
        
        
    }

    public void filldienthoaiFromSelectedRow() {
        // lấy chỉ số của hàng được chọn 
        int row = table.getSelectedRow();
        if (row >= 0) {
            txtID.setText(table.getModel().getValueAt(row, 0).toString());
            txtMaSP.setText(table.getModel().getValueAt(row, 1).toString());
            txtTenSP.setText(table.getModel().getValueAt(row, 2).toString());
            txtKichCo.setText(table.getModel().getValueAt(row, 3).toString());
            txtChiTietSP.setText(table.getModel().getValueAt(row, 4).toString());
            txtNgaySX.setText(table.getModel().getValueAt(row, 5).toString());
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

    public void clearSanPhamInfo() {
        txtID.setText("");
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtKichCo.setText("");
        txtChiTietSP.setText("");
        txtNgaySX.setText("");
        // disable Edit and Delete buttons
        btnXoa.setEnabled(false);
        btnSua.setEnabled(false);
        // enable Add button
        btnThem.setEnabled(true);
    }

    public SanPham getSanPhamInfo() {
        // validate student        
        try {
            SanPham dt = new SanPham();
            if (txtID.getText() != null && !"".equals(txtID.getText())) {
                dt.setId(Integer.parseInt(txtID.getText()));
            }
            dt.setMaSP(txtMaSP.getText().trim());
            dt.setTenSP(txtTenSP.getText().trim());
            dt.setKichCo(txtKichCo.getText().trim());
            dt.setChiTietSP(txtChiTietSP.getText().trim());
            dt.setNgaySX(txtNgaySX.getText().trim());
            return dt;
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }

    public void addInsertSanPhamListener(ActionListener listener) {
        btnThem.addActionListener(listener);
    }

    public void addUpdateSanPhamListener(ActionListener listener) {
        btnSua.addActionListener(listener);
    }

    public void addDeleteSanPhamListener(ActionListener listener) {
        btnXoa.addActionListener(listener);
        //   System.out.println("run delete");
    }
    public void addClearSanPhamListener(ActionListener listener) {
        btnClear.addActionListener(listener);
        //   System.out.println("run delete");
    }

    public void addListSanPhamSelectionListener(ListSelectionListener listener) {
        table.getSelectionModel().addListSelectionListener(listener);
    }
}
