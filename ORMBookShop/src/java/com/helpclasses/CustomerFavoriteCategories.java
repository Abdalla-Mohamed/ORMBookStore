/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helpclasses;

import com.beans.Category;
import com.daos.Customer_Dao;
import com.daos.Interests_Dao;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hosam
 */
public class CustomerFavoriteCategories {
    
    public List<Category> getFCategories(int customerId){
        List<Category> list =null;
               
        
        Customer_Dao customerDao=new Customer_Dao();
        list =customerDao.getCustomerCategories(customerId);
            
      return list;      
    }
    
}
