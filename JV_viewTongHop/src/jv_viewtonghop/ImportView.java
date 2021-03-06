/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jv_viewtonghop;

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
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import jv_viewtonghop.FormView;

/**
 *
 * @author tonguyen
 */

public class ImportView extends JPanel {

    JTable tableqa;
    JButton btnAdd, btnDelet, btnEdit;
    JScrollPane jScrollPaneqaTable;
    JTextField codeclothes, nameclothes, priceclothes, typeclothes, materialclothes,
             countclothes,unit, textFieldSearch;
    JComboBox importer, supplier;
    JDateChooser dateimport;

    public ImportView() {
        setBorder(new EmptyBorder(8, 8, 8, 8));
        setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;

        Input input = new Input();
        input.setBorder(new CompoundBorder(new TitledBorder("Nh???p th??ng tin"), new EmptyBorder(4, 4, 4, 4)));
        
        add(input, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        Table table = new Table();
        table.setBorder(new CompoundBorder(new TitledBorder("B???ng th??ng tin"), new EmptyBorder(4, 4, 4, 4)));
        add(table, gbc);

        this.setSize(900, 300);
        this.setVisible(true);

    }

    class Input extends JPanel {

        public Input() {
            this.setPreferredSize(new Dimension(600,250));
            String[] item = {"Vi???t Nam", "Adidas", "Th??nh C??ng"};
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);

            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            add(new JLabel("M?? qu???n ??o"), gbc);

            gbc.gridx += 2;
            add(new JLabel("T??n qu???n ??o"), gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            add(new JLabel("Gi??"), gbc);

            gbc.gridx += 2;
            add(new JLabel("S??? l?????ng"), gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            add(new JLabel("????n v??? t??nh"), gbc);

            gbc.gridx += 2;
            add(new JLabel("Ng??y nh???p"), gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            add(new JLabel("Ng?????i nh???p"), gbc);

            gbc.gridx += 2;
            add(new JLabel("Nh?? cung c???p"), gbc);
            
            gbc.gridx = 1;
            gbc.gridy = 0;
//      gi??n chi???u ngang ?????i t?????ng sao cho kh??t
            gbc.fill = GridBagConstraints.HORIZONTAL;
//      neo v??? tr?? ?????t ?????i t?????ng theo m???t v??? tr?? n??o ???? trong ?? ?????t
            gbc.anchor = GridBagConstraints.WEST;
//      kho???ng c??ch l???n ra gi???a c??c ?????i t?????ng 
            gbc.weightx = 0.5;
            codeclothes= new JTextField(10);
            add(codeclothes, gbc);

            gbc.gridx += 2;
            nameclothes = new JTextField(10);
            add(nameclothes, gbc);

            gbc.gridx = 1;
            priceclothes = new JTextField(10);
            gbc.gridy++;
            add(priceclothes, gbc);

            gbc.gridx += 2;
            typeclothes = new JTextField(10);
            add(typeclothes, gbc);

            gbc.gridx = 1;
            gbc.gridy++;
            materialclothes = new JTextField(10);
            add(materialclothes, gbc);

            gbc.gridx += 2;
            dateimport = new JDateChooser();
            add(dateimport, gbc);

            gbc.gridx = 1;
            gbc.gridy++;
            importer = new JComboBox();
            add(importer, gbc);
            
            gbc.gridx += 2;
            supplier = new JComboBox();
            add(supplier, gbc);
            
        }

    }

    class Table extends JPanel {

        private String[] columnNames = new String[]{
           "M?? qu???n ??o", "T??n qu???n ??o", "Gi??", "S??? l?????ng","????n v??? t??nh", "Ng??y nh???p",
            "Ng?????i nh???p","Nh?? cung c???p"};
        // ?????nh ngh??a d??? li???u m???c ?????nh c???a b???ng quanao l?? r???ng
        Object[][] data = {
            {"b??nh", "chocopie"}, {"k???o", "k???o cao su"}, {"ch??n", "ch??n b??ng"}};

        public Table() {
            tableqa = new JTable();
            tableqa.getTableHeader().setFont( new Font( "Arial" , Font.BOLD, 13 ));
            jScrollPaneqaTable = new JScrollPane();
            tableqa.setModel(new DefaultTableModel(data, columnNames));
            jScrollPaneqaTable.setViewportView(tableqa);
            jScrollPaneqaTable.setPreferredSize(new Dimension(700, 300));
          

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

            serach.add(new JLabel("T??m ki???m"));

            textFieldSearch = new JTextField(15);
            textFieldSearch.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(77, 77, 77)));
            serach.add(textFieldSearch);

            JPanel buttonsPane = new JPanel(new GridBagLayout());
            gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            buttonsPane.add(new JButton("Th??m", icon2), gbc);

            gbc.gridy++;
            buttonsPane.add(new JButton("S???a", icon3), gbc);

            gbc.gridy++;
            buttonsPane.add(new JButton("Xo??", icon1), gbc);

            setLayout(new BorderLayout());
            
            add(detainJPanel, BorderLayout.CENTER);
            add(serach, BorderLayout.NORTH);
            add(buttonsPane, BorderLayout.EAST);

        }

    }

}