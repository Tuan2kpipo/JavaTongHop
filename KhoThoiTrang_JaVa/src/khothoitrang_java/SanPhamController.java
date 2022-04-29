/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khothoitrang_java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Admin
 */
public class SanPhamController {
    
    SanPhamiplDAO DAO;
    private SanPhamTableModel SanPhamModel;
    private SanPhamView SanPhamView;

    public SanPhamController(SanPhamView _SanPhamView, SanPhamTableModel _SanPhamModel) {
        this.SanPhamView = _SanPhamView;
        SanPhamModel = _SanPhamModel;
        DAO = new SanPhamiplDAO("jdbc:mysql://localhost:3306/quanlykhothoitrang", "root", "");
    }

    SanPhamController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    SanPhamController(SanPhamTableModel SanPhamModel, SanPhamView SanPhamView) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void showSanPhamView() {
        SanPhamView.showListSanPham(SanPhamModel);
        SanPhamView.addListSanPhamSelectionListener(new ListSanPhamSelectionListener());
        SanPhamView.addDeleteSanPhamListener(new DeleteSanPhamListener());
        SanPhamView.addUpdateSanPhamListener(new UpdateSanPhamListener());
       SanPhamView.addInsertSanPhamListener(new InsertSanPhamListener());
        SanPhamView.addClearSanPhamListener(new ClearSanPhamListener());
        SanPhamView.setVisible(true);
       SanPhamView.setEnabled(true);
    }

    class ListSanPhamSelectionListener implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent e) {
            SanPhamView.filldienthoaiFromSelectedRow();
        }
    }

    class ClearSanPhamListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
             SanPhamView.clearSanPhamInfo();
        }
    }

    class InsertSanPhamListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
                SanPham sp = SanPhamView.getSanPhamInfo();
            if (sp != null) {
                DAO.insert(sp);
                SanPhamView.clearSanPhamInfo();
                SanPhamView.showListSanPham(new SanPhamTableModel(DAO.getAllSanPham()));
                SanPhamView.showMessage("Thêm thành công!");
            }
        }
    }

    class DeleteSanPhamListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            SanPham sp = SanPhamView.getSanPhamInfo();

            if (sp != null) {
                DAO.DeleteSanPham(sp);
                SanPhamView.clearSanPhamInfo();
                ArrayList<SanPham> ds = DAO.getAllSanPham();
                if (ds != null) {
                   SanPhamView.showListSanPham(new SanPhamTableModel(ds));
                } else {
                    SanPhamView.showMessage("Dữ liệu rỗng");
                }
                SanPhamView.showMessage("Xóa thành công!");
            }
        }
    }

    class UpdateSanPhamListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            SanPham sp = SanPhamView.getSanPhamInfo();
            if (sp != null) {
                DAO.updateSanPham(sp);
                // sinhvienView.showStudent(sv);
                SanPhamView.showListSanPham(new SanPhamTableModel(DAO.getAllSanPham()));
                SanPhamView.showMessage("Cập nhật thành công!");
            }
        }
    }
}
