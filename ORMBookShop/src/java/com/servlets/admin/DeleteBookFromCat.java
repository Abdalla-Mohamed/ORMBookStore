/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets.admin;

import com.beans.Book;
import com.beans.Category;
import com.daos.BookCategoriesDao;
import com.utilts.SharedNames;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hosam
 */
public class DeleteBookFromCat extends HttpServlet {
  
     @Override
     public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
         
          response.setContentType("text/html");
       int catIid =0;
       int bookId =0;
         
         
         
     }
    
   @Override
   public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
       
       
       response.setContentType("text/html");
       int catnum =0;
       catnum=Integer.parseInt(request.getParameter("catNo3"));
       
       
               
               HttpSession session = request.getSession(true);
                   session.setAttribute("catN3",catnum);
                   
                   response.sendRedirect("adminPanel/secured/categorymanage.jsp");
          
     }
}
