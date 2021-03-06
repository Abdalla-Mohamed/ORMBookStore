/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

import com.beans.Customer;
import com.daos.Category_Dao;
import com.daos.Customer_Dao;
import com.daos.Interests_Dao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
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
public class AddFavoriteCategories extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Set categories = new HashSet();
        Category_Dao categoryDao = new Category_Dao();
        Customer_Dao customerDao = new Customer_Dao();
        
        Interests_Dao iDao = new Interests_Dao();
        HttpSession session = request.getSession(false);
        Customer customer = (Customer) session.getAttribute("customer");

        response.setContentType("text/html");
        String[] e = request.getParameterValues("favCategory");

        int id;

        if (e != null) {
            for (int i = 0; i < e.length; i++) {

                id = Integer.parseInt(e[i]);

                try {
                    categories.add(categoryDao.readById(id));
                    
                } catch (SQLException ex) {
                    Logger.getLogger(AddFavoriteCategories.class.getName()).log(Level.SEVERE, null, ex);
                }
                customerDao.addCcustomerInterests(customer.getCId(),categories);
            }
        }

        response.sendRedirect("customerSite/profile.jsp");

    }
}
