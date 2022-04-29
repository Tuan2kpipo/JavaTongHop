/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_themsuaxoa_csdl;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
// khi mà extends từ AbstractTableModel thì ta cần  @Override các phg thức lại
public class dienthoaiTableModel extends AbstractTableModel {
   
private ArrayList<dienthoai> dsdienthoai=null;
private Object[][] data=null;
// khỏi tạo và truyền vào arrlist từ lớp DAO
    public dienthoaiTableModel(ArrayList<dienthoai> _dsdienthoai) {
        System.out.println("innit dienthoaimodel");
        //bản chất là đổ arrlist về mẳng 2 chiều , mỗi phần tử đặt là object
        dsdienthoai=_dsdienthoai;
        data=new Object[dsdienthoai.size()][];
        // duyệt list từ trên xuống dưới .
       for(int i=0;i<dsdienthoai.size();i++){
           //  vs mỗi dòng sẽ khởi tạo dienthoai từ arrlist
           dienthoai dt=dsdienthoai.get(i);
        
           // vs mỗi dòng sẽ gồm id,mã...
          Object[] row={dt.getId(),dt.getMaDienThoai(),dt.getTenDienThoai(),dt.getHangSanXuat(), dt.getThongTinChung(),dt.getGiaBan()};
         // gán 1 dòng bằng cái row
          data[i]=row;           
        }
    }

    // bản chất  của mẳng 2 chiều là mảng 1 chiều trong đó mỗi phần tử là 1 mẳng 1 chiều
    
    // kích thức arlist
    @Override
    public int getRowCount() {
        // trả về số dòng
        return dsdienthoai.size();
    }
    
    // số phần tử của dòng đầu (cột)
    @Override
    public int getColumnCount() {
        
       return data[0].length;
    }
    
    // phần tử của mảng 2 chiều , dòng bn, cột bn
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {   //1,1 ="Nguyen Thi B"  
      System.out.println("rowIndex: "+rowIndex+"  columnIndex"+columnIndex);
      // đổ dl từ ma trận 2 chiều 
       return data[rowIndex][columnIndex];        
    }    
}

