/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets.admin;

import com.daos.BookCategoriesDao;
import com.daos.Book_Dao;
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
public class AddBookToCat extends HttpServlet {
    
     @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            Book_Dao bDao =new Book_Dao();
            
           response.setContentType("text/html");
       
           int catId=0;
           catId=Integer.parseInt(request.getParameter("catId"));
           int bookId=0;
           bookId=Integer.parseInt(request.getParameter("bookId"));
           
           if(catId!=0&&bookId!=0){
               
                try {
                    bDao.addCategory(bookId, catId);
                } catch (SQLException ex) {
                    Logger.getLogger(AddBookToCat.class.getName()).log(Level.SEVERE, null, ex);
                }
                response.sendRedirect("adminPanel/secured/categorymanage.jsp");
           }
    }
    
    
}
