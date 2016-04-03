/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets.admin;

import com.beans.Book;
import com.daos.Book_Dao;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Abdalla
 */
@WebServlet(name = "BookManage", urlPatterns = {"/BookManageSrvlt"})
public class BookManageController extends HttpServlet {

    private Book book;
    private Book_Dao book_Dao;
    final String jspBookMange = "/ORMBookShop/adminPanel/secured/tables.jsp";

    public BookManageController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                    System.out.println(Paths.get(".").toAbsolutePath().normalize().toString());

     //   this.doPost(request, response);
    }

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
        if (createNewBookFrom(request)) {
            // show msg succefully
        } else {
            // show msg error

        }
        response.sendRedirect(jspBookMange);

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

//------------------ besinse code ----------------------------------------------
    public boolean createNewBookFrom(HttpServletRequest request) {
        boolean isInserted = false;
        try {

            // initial upload setting
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            // get parameter in form
            Map<String, List<FileItem>> parseParameterMap = upload.parseParameterMap(request);

            // get data about book
            String title = parseParameterMap.get("title").get(0).getString();
            String description = parseParameterMap.get("description").get(0).getString();
            String quote = parseParameterMap.get("quote").get(0).getString();

            double price = Double.parseDouble(parseParameterMap.get("price").get(0).getString());
            int rate = Integer.parseInt(parseParameterMap.get("rate").get(0).getString());
            int Count = Integer.parseInt(parseParameterMap.get("count").get(0).getString());

            // insert book with primary data
            book_Dao = new Book_Dao();
            book = new Book(title, description, quote, Count, price, rate, null, null, null, null, null, null, null, null);
            book_Dao.add(book);

            // get ID of new book 
            Book newBook = book_Dao.readByName(book.getBName());
            // create new path where images of book will saved
            String bookImagesFolder = Book.uplodedImgFolderDestntion + newBook.getBIsbn();

            // get images of book from form
            FileItem imgFront = parseParameterMap.get("imgFront").get(0);
            FileItem imgBack = parseParameterMap.get("imgBack").get(0);
            FileItem frstHeader = parseParameterMap.get("frstHeader").get(0);
            FileItem scndHeader = parseParameterMap.get("scndHeader").get(0);

            // creat folder with id of book to save image in it
            boolean mkdirs = new File(bookImagesFolder).mkdirs();
            if (!mkdirs) {
                throw new Exception("cant creat folder");
            }

            // set folder as parent of images && save images at server
            File imgFrontFile = new File(bookImagesFolder, imgFront.getName());
            imgFront.write(imgFrontFile);

            File imgBackFile = new File(bookImagesFolder, imgBack.getName());
            imgBack.write(imgBackFile);

            File frstHeaderFile = new File(bookImagesFolder, frstHeader.getName());
            frstHeader.write(frstHeaderFile);

            File scndHeaderFile = new File(bookImagesFolder, scndHeader.getName());
            scndHeader.write(scndHeaderFile);
            
            newBook.setImages(imgFront.getName(), imgBack.getName(), frstHeader.getName(), scndHeader.getName());
            book_Dao.updateImages(newBook);

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

}
