/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ie.team1.is2209ca1projectt1.dao;
import java.util.logging.Logger;
/**
 *
 * @author Daram

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/**
 *
 * @author 120463034
 */
public class Staff {
    private int id;
    private int  ShopId;
    private String StaffRole;

     public Staff(int id, int ShopId, String StaffRole) { //change data types to fit 
        this.id = id;
        this.ShopId = ShopId;
        this.StaffRole = StaffRole;
      
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShopId() {
        return ShopId;
    }

    public void setShopId(int ShopId) {
        this.ShopId = ShopId;
    }

    public String getStaffRole() {
        return StaffRole;
    }

    public void setStaffRole(String StaffRole) {
        this.StaffRole = StaffRole;
    }

    

///      public int getShopId() {
     //   return ShopId;
    //}
/*
    public void setid(int id) {
        this.id = id;
    }


    public int getid() {
        return id;
    }

    public void setShopId(int ShopId) {
        this.ShopId = ShopId;
    }

    public String getStaffRole() {
        return StaffRole;
    }

    public void setStaffRole(String StaffRole) {
        this.StaffRole = StaffRole;
    }

*/
    
    
  
    @Override

    public String toString() {
        return "Staff{" + "id=" + id + ", ShopId=" + ShopId + ", StaffRole" + StaffRole  + '}';
    }

  

  
  
    
}



