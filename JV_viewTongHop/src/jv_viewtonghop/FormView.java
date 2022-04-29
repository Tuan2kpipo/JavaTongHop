/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jv_viewtonghop;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author BUIDUCQUYNH
 */
public class FormView  {

    public FormView() {
        
        JFrame frame = new JFrame("Quản Lý Shop Quần Áo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        JPanel mainPanel = new JPanel(new GridLayout(1, 1));
        JTabbedPane tabbedPane = new JTabbedPane();
        
        ImageIcon icon1 = FormView.createImageIcon("images/import_50px.png");
        ImageIcon icon2 = FormView.createImageIcon("images/customer_26px.png");
        ImageIcon icon3 = FormView.createImageIcon("images/supplier_30px.png");
        ImageIcon icon4 = FormView.createImageIcon("images/staff_24px.png");
        
        ImportView panel1 = new ImportView();
        tabbedPane.addTab("Quản lý Nhập Kho", icon1, panel1);
        CustommerView panel2 = new CustommerView();
        tabbedPane.addTab("Quản lý Khách Hàng", icon2, panel2);
        SupplierView panel3 = new SupplierView();
        tabbedPane.addTab("Quản lý Nhà Cung Cấp", icon3, panel3);
        StaffView panel4 = new StaffView();
        tabbedPane.addTab("Quản lý nhân viên", icon4, panel4);
        InvoiceView panel5 = new InvoiceView();
        tabbedPane.addTab("Quản lý hoá đơn", icon4, panel5);
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        mainPanel.add(tabbedPane);
        frame.add(mainPanel, BorderLayout.CENTER);
        
        frame.pack();
        frame.setSize(900,800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = FormView.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}