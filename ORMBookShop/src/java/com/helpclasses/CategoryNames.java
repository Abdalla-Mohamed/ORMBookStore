/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helpclasses;

import com.beans.Category;
import com.daos.Category_Dao;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Hosam
 */
public class CategoryNames {

    public CategoryNames(){
        
    }
    
    public List<Category> getCategories(){
        List<Category> list =null;
        
           
        Category_Dao categoryDao = new Category_Dao();
        
        try {
            list =categoryDao.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryNames.class.getName()).log(Level.SEVERE, null, ex);
        }
            
      return list;      
    }
      
}