/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_themsuaxoa_csdl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Admin
 */
public class dienthoaicontroller {

    dienthoaiiplDAO DAO;
    private dienthoaiTableModel dienthoaiModel;
    private dienthoaiview dienthoaiview;

    public dienthoaicontroller(dienthoaiview _dienthoaiView, dienthoaiTableModel _dienthoaiModel) {
        this.dienthoaiview = _dienthoaiView;
        dienthoaiModel = _dienthoaiModel;
        DAO = new dienthoaiiplDAO("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
    }

    public void showdienthoaiView() {
        dienthoaiview.showListdienthoai(dienthoaiModel);
        // đăng kí lắng nghe cho nútthêm sửa xóa..
        dienthoaiview.addListdienthoaiSelectionListener(new ListdienthoaiSelectionListener());
        dienthoaiview.addDeletedienthoaiListener(new DeletedienthoaiListener());
        dienthoaiview.addUpdatedienthoaiListener(new UpdatedienthoaiListener());
       dienthoaiview.addInsertdienthoaitListener(new InsertdienthoaiListener());
        dienthoaiview.addCleardienthoaiListener(new CleardienthoaiListener());
        dienthoaiview.setVisible(true);
        dienthoaiview.setEnabled(true);
    }

    class ListdienthoaiSelectionListener implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent e) {
            dienthoaiview.filldienthoaiFromSelectedRow();
        }
    }

    class CleardienthoaiListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            dienthoaiview.cleardienthoaiInfo();
        }
    }

    class InsertdienthoaiListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            dienthoai dt = dienthoaiview.getdienthoaiInfo();
            if (dt != null) {
                DAO.insert(dt);
                dienthoaiview.cleardienthoaiInfo();
                dienthoaiview.showListdienthoai(new dienthoaiTableModel(DAO.getAlldienthoai()));
                dienthoaiview.showMessage("Thêm thành công!");
            }
        }
    }

    class DeletedienthoaiListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            dienthoai dt = dienthoaiview.getdienthoaiInfo();

            if (dt != null) {
                DAO.Deletedienthoai(dt);
                dienthoaiview.cleardienthoaiInfo();
                ArrayList<dienthoai> ds = DAO.getAlldienthoai();
                if (ds != null) {
                   dienthoaiview.showListdienthoai(new dienthoaiTableModel(ds));
                } else {
                    dienthoaiview.showMessage("Dữ liệu rỗng");
                }
                dienthoaiview.showMessage("Xóa thành công!");
            }
        }
    }

    class UpdatedienthoaiListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            dienthoai dt = dienthoaiview.getdienthoaiInfo();
            if (dt != null) {
                DAO.updatedienthoai(dt);
                // sinhvienView.showStudent(sv);
                dienthoaiview.showListdienthoai(new dienthoaiTableModel(DAO.getAlldienthoai()));
                dienthoaiview.showMessage("Cập nhật thành công!");
            }
        }
    }
}
