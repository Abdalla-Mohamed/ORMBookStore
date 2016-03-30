/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

import com.beans.Book;
import com.beans.Cart;
import com.beans.CartId;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.daos.Category_Dao;
import com.beans.Category;
import com.beans.Customer;
import com.daos.Cart_Dao;
import com.helpclasses.BookLists;
import com.helpclasses.CartController;
import com.utilts.SharedNames;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "AddToCart",urlPatterns = "/AddToCart")
public class AddToCart extends HttpServlet {

 

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

         HttpSession session = request.getSession(false);
        int isbn = Integer.parseInt((String) request.getParameter("ispnRow"));
        int count = Integer.parseInt((String) request.getParameter("count"));
        Customer loginCustomer= (Customer)(request.getSession().getAttribute(SharedNames.loginedCustomer));
        Integer cId = loginCustomer.getCId();
        CartId cartId = new CartId(isbn, cId);
        Cart cart = new Cart(cartId,new Book(isbn),loginCustomer );
        new CartController().addItemInCart(cart);

        response.sendRedirect("/OnlineBookShop/customerSite/grid-view.jsp");
    
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
