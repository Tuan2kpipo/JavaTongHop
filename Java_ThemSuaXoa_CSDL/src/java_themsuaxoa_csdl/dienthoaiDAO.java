/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_themsuaxoa_csdl;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */

// phac thao theo thiet ke mau
public interface dienthoaiDAO {

    public ArrayList<dienthoai> getAlldienthoai();

    public void insert(dienthoai dt);

    public void updatedienthoai(dienthoai dt);

    public boolean Deletedienthoai(dienthoai dt);

    public dienthoai finddienthoaiByID(int id);

    public dienthoai findByName(String name);
}
