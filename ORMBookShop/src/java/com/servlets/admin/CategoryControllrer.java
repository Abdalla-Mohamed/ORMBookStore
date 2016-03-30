/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets.admin;

import com.beans.Category;
import com.daos.Category_Dao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hosam
 */
public class CategoryControllrer extends HttpServlet {
     @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        Category category= new Category();
        Category_Dao categoryDao = new Category_Dao();
        
        response.setContentType("text/html");
        
        
        
        category.setCatName(request.getParameter("catName"));
        
         try {
             //------------------------Add new category-------------------
             
             categoryDao.add(category);
             
         } catch (SQLException ex) {
             Logger.getLogger(CategoryControllrer.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        response.sendRedirect("adminPanel/secured/categorymanage.jsp"); 
    }
}
