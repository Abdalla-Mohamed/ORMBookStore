/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

import com.beans.Customer;
import com.daos.Customer_Dao;
import java.io.IOException;
import java.io.PrintWriter;
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
public class Signup extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest requst, HttpServletResponse response) throws ServletException, IOException {
        
        Customer customer=new Customer();
        Customer_Dao customerDao=new Customer_Dao();
        Boolean ok = false;
        
        
        response.setContentType("text/html");
        
        //----------filling customer object with data from form--------------
        customer.setCName(requst.getParameter("cName"));
        customer.setCPassword(requst.getParameter("cPassword"));
        customer.setCJob(requst.getParameter("cJob"));
        customer.setCEmail(requst.getParameter("cEmail"));
        customer.setCAddress(requst.getParameter("cAddress"));
        customer.setCMobile(requst.getParameter("cMobile"));
        
        
        try {
            //----------------insert data to Db------------
           ok= customerDao.signUp(customer);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        if(ok){
            
            try {
               
                
                
               customer=customerDao.login(customer.getCEmail(),customer.getCPassword());
                

               
                if(customer !=null){
                   
                   HttpSession session = requst.getSession(true);
                   
                   session.setAttribute("customer",customer);
                   
                   response.sendRedirect("customerSite/profile.jsp");
               }
               
               else{
                    response.sendRedirect("customerSite/checkout.jsp");
//              RequestDispatcher rd = req.getRequestDispatcher("customerSite/checkout.jsp");
//              rd.forward(req, res);
                   
               }
                          
            } catch (SQLException ex) {
                Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
            }
             
            
        }
        else{
            response.sendRedirect("customerSite/checkout.jsp");
        }
        
        
    }
}
