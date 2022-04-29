/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khothoitrang_java;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class SanPhamTableModel extends AbstractTableModel {
private ArrayList<SanPham> dsSanPham=null;
private Object[][] data=null;
    public SanPhamTableModel(ArrayList<SanPham> _dsSanPham) {
        System.out.println("innit dienthoaimodel");
        dsSanPham=_dsSanPham;
        data=new Object[dsSanPham.size()][];
       for(int i=0;i<dsSanPham.size();i++){
           SanPham sp=dsSanPham.get(i);
        
          Object[] row={sp.getId(),sp.getMaSP(),sp.getTenSP(),sp.getKichCo(), sp.getChiTietSP(),sp.getNgaySX()};
          data[i]=row;           
        }
    }

    
    @Override
    public int getRowCount() {
        return dsSanPham.size();
    }
    
    @Override
    //data={{01,"nguyen van A", "thai Nguyen", "ktpm k18a", "190"},{"02,"Nguyen Thi B", "thai binh","ktpmk18b","1998"},.....}
    public int getColumnCount() {
       return data[0].length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {   //1,1 ="Nguyen Thi B"  
      System.out.println("rowIndex: "+rowIndex+"  columnIndex"+columnIndex);
       return data[rowIndex][columnIndex];        
    }    
}

