/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helpclasses;


import com.beans.Book;
//import com.daos.BookCategoriesDao;
import com.daos.Book_Dao;
import com.daos.Category_Dao;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hosam
 */
public class BookLists {

    Book_Dao bookDao;
   // BookCategoriesDao bookCatDao;
    Category_Dao categoryDao= new Category_Dao();
    public BookLists() {
        bookDao = new Book_Dao();
    //    bookCatDao=new BookCategoriesDao();
    }

    public List<Book> getAllBooks() {
        List<Book> books = null;

        try {
            books = bookDao.readAll();
                 } catch (SQLException ex) {
            Logger.getLogger(BookLists.class.getName()).log(Level.SEVERE, null, ex);
        }

        return books;
    }
    public List<Book> getAdminBooks() {
        List<Book> books = null;

        try {
            books = bookDao.readAdminAll();
                 } catch (SQLException ex) {
            Logger.getLogger(BookLists.class.getName()).log(Level.SEVERE, null, ex);
        }

        return books;
    }
    
    
//    public List<Book> getCustomerCartBooks(int CustmerID) {
//        List<Book> books = null;
//
//        try {
//            books = bookDao.customerCartBooks(CustmerID);
//            System.out.println("");
//        } catch (SQLException ex) {
//            Logger.getLogger(BookLists.class.getName()).log(Level.SEVERE, null, ex);
//        }

//        return books;
//    }
    
    public Book getBook(int isbn) {
        Book book = null;

        try {
            book = bookDao.readByIsbn(isbn);

        } catch (SQLException ex) {
            Logger.getLogger(BookLists.class.getName()).log(Level.SEVERE, null, ex);
        }

        return book;
    }
    
    public List<Book> getBooksByCategory(int catId){
        List<Book>books=null;
        if(catId!=0){
        try {
            books=categoryDao.getBooksByCategory(catId);
        } catch (SQLException ex) {
            Logger.getLogger(BookLists.class.getName()).log(Level.SEVERE, null, ex);
        }}
        return books;
    }
    
    public List<Book> getBooksWithNoCategory(){
        List<Book>books=null;
        
        try {
            books=bookDao.getBooksWithNoCategory();
        } catch (SQLException ex) {
            Logger.getLogger(BookLists.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }
    
    
    public List<Book> getOtherBooks(int catID){
         List<Book>books=null;
         
        try {
            books=categoryDao.getOtherBooks(catID);
        } catch (SQLException ex) {
            Logger.getLogger(BookLists.class.getName()).log(Level.SEVERE, null, ex);
        }
         return books;
    }

}
