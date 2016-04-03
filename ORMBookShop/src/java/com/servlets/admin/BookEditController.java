/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets.admin;

import com.beans.Book;
import com.beans.Customer;
import com.daos.Book_Dao;
import com.daos.Customer_Dao;
import com.servlets.UpdateCustomerData;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.FileUploadException;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Abdalla
 */
public class BookEditController extends HttpServlet {

    private Book book;
    private Book_Dao book_Dao;
    final String jspBookMange = "adminPanel/secured/sign-up.jsp";

    public BookEditController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(Paths.get(".").toAbsolutePath().normalize().toString());

        Book book = new Book();
        Book_Dao bookDao = new Book_Dao();

        int id = Integer.parseInt(request.getParameter("ispnRow"));
        try {
            book = bookDao.readByIsbn(id);
            book.setBCount(-1);
            bookDao.update(book);

        } catch (SQLException ex) {
            Logger.getLogger(BookEditController.class.getName()).log(Level.SEVERE, null, ex);
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("book", book);

        response.setContentType("text/html");

        response.sendRedirect("adminPanel/secured/tables.jsp");
    }

    //   this.doPost(request, response);
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        if (updateBookForm(request)) {
//            // show msg succefully
//        } else {
//            // show msg error
//
//        }
        Book book = new Book();
        Book_Dao bookDao = new Book_Dao();
        String bName = request.getParameter("title");
        int id = Integer.parseInt(request.getParameter("isbn"));
        double price = Double.parseDouble(request.getParameter("price"));
        int count = Integer.parseInt(request.getParameter("count"));
        String desc = request.getParameter("description");
        int rate = Integer.parseInt(request.getParameter("rate"));

        HttpSession session = request.getSession(true);
        session.setAttribute("book", book);

        book.setBName(bName);
        book.setBIsbn(id);
        book.setBCount(count);
        book.setBDescription(desc);
        book.setBPrice(price);
        book.setBRating(rate);

        response.setContentType("text/html");
        try {
            bookDao.update(book);

        } catch (SQLException ex) {
            Logger.getLogger(UpdateCustomerData.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect("adminPanel/secured/tables.jsp");
    }

}

/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */
//------------------ besinse code ----------------------------------------------
  /*  public boolean updateBookForm(HttpServletRequest request) {
 boolean isInserted = false;
 try {

 // initial upload setting
 DiskFileItemFactory factory = new DiskFileItemFactory();
 ServletFileUpload upload = new ServletFileUpload(factory);

 // get parameter in form
 Map<String, List<FileItem>> parseParameterMap = upload.parseParameterMap(request);
 int id = Integer.parseInt(parseParameterMap.get("id").get(0).getString());
 // get data about book
 String title = parseParameterMap.get("title").get(0).getString();
            
 // insert book with primary data
 book_Dao = new Book_Dao();
 // book = new Book(title, description, quote, Count, price, rate);
 book = new Book();
 book_Dao.update(book);

 // get ID of new book 
 //   Book newBook = book_Dao.readByName(book.getBName());

 isInserted = true;
 } catch (FileUploadException ex) {
 Logger.getLogger(BookManageController.class.getName()).log(Level.SEVERE, null, ex);
 ex.printStackTrace();
 } catch (Exception ex) {
 Logger.getLogger(BookManageController.class.getName()).log(Level.SEVERE, null, ex);
 ex.printStackTrace();
 }
 return isInserted;
 }
 */
