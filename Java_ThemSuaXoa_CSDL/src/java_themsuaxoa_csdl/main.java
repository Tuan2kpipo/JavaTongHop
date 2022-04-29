/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_themsuaxoa_csdl;

/**
 *
 * @author Admin
 */
public class main {

    public static void main(String[] args) {
        // khoi tao ipldao
        dienthoaiiplDAO dienthoaiDAO = new dienthoaiiplDAO("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
        // khoitao model
        dienthoaiTableModel dienthoaiModel = new dienthoaiTableModel(dienthoaiDAO.getAlldienthoai());
        // khoi tao view
        dienthoaiview dienthoaiView = new dienthoaiview();
        // khoi tao controller
        dienthoaicontroller controller = new dienthoaicontroller(dienthoaiView, dienthoaiModel);
        controller.showdienthoaiView();
    }
}
