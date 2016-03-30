/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

import com.beans.Customer;
import com.daos.Author_Dao;
import com.daos.Customer_Dao;
import com.utilts.SharedNames;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hosam
 */
public class Login extends HttpServlet {

   @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        Boolean valid=false;
        Customer customer =new Customer();
        Customer_Dao customerDao =new Customer_Dao();
        
        response.setContentType("text/html");

        customer.setCEmail(request.getParameter("cEmail")) ;
        customer.setCPassword(request.getParameter("cPassword"));
        
       try {
         valid=customerDao.validEmail(customer.getCEmail());
           
            } catch (SQLException ex) {
           Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
       }
         
       if (valid){
           
            try {
                customer=customerDao.login(customer.getCEmail(),customer.getCPassword());
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                        
               if(customer !=null){
                   
                   HttpSession session = request.getSession(true);
                   session.setAttribute(SharedNames.loginedCustomer,customer);
                   
                   response.sendRedirect("customerSite/profile.jsp");
                
            }
           
       else{
              response.sendRedirect("customerSite/checkout.jsp");
//              RequestDispatcher rd = request.getRequestDispatcher("customerSite/checkout.jsp");
//              rd.forward(request, response);
                   
               }
       }
       else{
              
            response.sendRedirect("customerSite/checkout.jsp");
//              RequestDispatcher rd = request.getRequestDispatcher("customerSite/checkout.jsp");
//              rd.forward(request, response);
                   
               }
       
               
    }
}
