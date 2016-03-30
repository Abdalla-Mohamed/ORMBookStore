/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.daos.Interests_Dao;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Hosam
 */
public class Interests {
    
    private int customerId;
    private int catId;
    
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }
    
//    public List<Category> getBookCategories(int customerId){
//        
//        Interests_Dao interestsDao=new Interests_Dao();
//        List<Category> list = null;
//        try {
//            
//            list=interestsDao.getCustomerCategories(customerId);
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(Interests.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//    }
// 
}
