/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jv_viewtonghop;

/**
 *
 * @author BUIDUCQUYNH
 */
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import sun.font.EAttribute;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author BUIDUCQUYNH
 */
public class CustommerView extends JPanel {

    JTable tableqa;
    JButton btnAdd, btnDelet, btnEdit;
    JScrollPane jScrollPaneqaTable;
    JTextField codecustommer,namecustomer, numbercustomer, addresscustomer, textFieldSearch;
    JDateChooser purchasedate;
    JComboBox nameproduct;

    public CustommerView() {
        setBorder(new EmptyBorder(8, 8, 8, 8));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;

        Input1 input = new Input1();
        input.setBorder(new CompoundBorder(new TitledBorder("Nhập thông tin khách hàng"), new EmptyBorder(4, 4, 4, 4)));
        add(input, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        Table1 table = new Table1();
        table.setBorder(new CompoundBorder(new TitledBorder("Bảng thông tin khách hàng"), new EmptyBorder(4, 4, 4, 4)));
        add(table, gbc);

    }

    class Input1 extends JPanel {

        public Input1() {
            this.setPreferredSize(new Dimension(600,200));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);

            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            add(new JLabel("Mã khách hàng"), gbc);

            gbc.gridx += 2;
            add(new JLabel("Tên khách hàng"), gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            add(new JLabel("Số điện thoại"), gbc);

            gbc.gridx += 2;
            add(new JLabel("Địa chỉ"), gbc);
            
            
            gbc.gridx = 1;
            gbc.gridy = 0;
//      giãn chiều ngang đối tượng sao cho khít
            gbc.fill = GridBagConstraints.HORIZONTAL;
//      neo vị trí đặt đối tượng theo một vị trí nào đó trong ô đặt
            gbc.anchor = GridBagConstraints.WEST;
//      khoảng cách lớn ra giữa các đối tượng 
            gbc.weightx = 0.5;
            codecustommer = new JTextField(10);
            add(codecustommer, gbc);

            gbc.gridx += 2;
            namecustomer = new JTextField(10);
            add(namecustomer, gbc);

            gbc.gridx = 1;
            gbc.gridy++;
            numbercustomer = new JTextField(10);
            add(numbercustomer, gbc);

            gbc.gridx += 2;
            addresscustomer = new JTextField(10);
            add(addresscustomer, gbc);
            
            
        }
    }

    class Table1 extends JPanel {

        private String[] columnNames = new String[]{
            "Mã khách hàng","Tên khách hàng", "Số điện thoại", "Địa chỉ"};
        // định nghĩa dữ liệu mặc định của bẳng quanao là rỗng
        Object[][] data = {
            {"bánh", "chocopie"}, {"kẹo", "kẹo cao su"}, {"chăn", "chăn bông"}};

        public Table1() {
            tableqa = new JTable();
            tableqa.getTableHeader().setFont( new Font( "Arial" , Font.BOLD, 13 ));
            jScrollPaneqaTable = new JScrollPane();
            tableqa.setModel(new DefaultTableModel(data, columnNames));
            jScrollPaneqaTable.setViewportView(tableqa);
            jScrollPaneqaTable.setPreferredSize(new Dimension(600, 300));

            ImageIcon icon1 = FormView.createImageIcon("images/delete_30px.png");
            ImageIcon icon2 = FormView.createImageIcon("images/add_64px.png");
            ImageIcon icon3 = FormView.createImageIcon("images/edit_24px.png");

            JPanel detainJPanel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.EAST;
            detainJPanel.add(jScrollPaneqaTable, gbc);
            JPanel serach = new JPanel(new FlowLayout());

            serach.add(new JLabel("Tìm kiếm"));

            textFieldSearch = new JTextField(15);
            textFieldSearch.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(77, 77, 77)));
            serach.add(textFieldSearch);

            btnAdd = new JButton("Thêm");
            btnEdit = new JButton("Sửa");
            btnDelet = new JButton("Xoá");

            JPanel buttonsPane = new JPanel(new GridBagLayout());
            gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            buttonsPane.add(new JButton("Thêm", icon2), gbc);

            gbc.gridy++;
            buttonsPane.add(new JButton("Sửa", icon3), gbc);

            gbc.gridy++;
            buttonsPane.add(new JButton("Xoá", icon1), gbc);

            setLayout(new BorderLayout());
            add(detainJPanel);
            add(serach, BorderLayout.NORTH);
            add(buttonsPane, BorderLayout.EAST);

        }
    }
}