/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

import com.beans.Customer;
import com.daos.Customer_Dao;
import java.io.IOException;
import java.sql.SQLException;
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
public class UpdateCustomerData extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         Customer customer=new Customer();
        Customer_Dao customerDao=new Customer_Dao();
        
          response.setContentType("text/html");
        
          
        customer.setCId(Integer.parseInt(request.getParameter("cId")));  
        customer.setCName(request.getParameter("cName"));
        customer.setCPassword(request.getParameter("cPassword"));
        customer.setCJob(request.getParameter("cJob"));
        customer.setCAddress(request.getParameter("cAddress"));
        customer.setCMobile(request.getParameter("cMobile"));
        
        try {
            customerDao.update(customer);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateCustomerData.class.getName()).log(Level.SEVERE, null, ex);
        }
         HttpSession session = request.getSession(true);
         session.setAttribute("customer",customer); 
         response.sendRedirect("customerSite/profile.jsp");
    }
}
