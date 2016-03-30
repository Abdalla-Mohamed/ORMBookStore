/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

import com.beans.Author;
import com.beans.Book;
import com.daos.Author_Dao;
import com.daos.Book_Dao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Abdalla
 */
public class ShowBookDetails1 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            //ISBN for Book 
            String sisbn = request.getParameter("ispnRow");  

            int isbn = Integer.parseInt(sisbn);
            
            Book_Dao bookdao = new Book_Dao();
            Book bookobj = bookdao.readByIsbn(isbn);
            //upload to session
            HttpSession session = request.getSession();
            session.setAttribute("bookdetials", bookobj);

            response.sendRedirect("customerSite/book-detail_1.jsp");

            //----------------------------------------------------------
        } catch (SQLException ex) {
            Logger.getLogger(ShowBookDetails1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
