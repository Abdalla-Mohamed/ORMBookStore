/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daos;

import org.hibernate.Session;

import com.beans.Book;
import java.sql.*;
import com.utilts.DbConnctor;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;

/**
 *
 * @author Administrator
 */
public class Book_Dao {

    private static final String SQL_READ = "SELECT * FROM BOOK where B_COUNT > 0";
    private static final String SQL_RETRIVE_Books_InCart = "SELECT * FROM BOOK B WHERE B_ISBN IN(SELECT B_ID FROM CART WHERE C_ID = ?  ) ORDER BY B_ISBN desc ";
    private static final String SQL_READ_BY_NAME = "SELECT B_ISBN FROM BOOK where B_NAME=?";
    private static final String SQL_READ_BY_ISBN = "SELECT * FROM BOOK where B_ISBN=?";
    private static final String SQL_INSERT = "INSERT INTO BOOK(B_ISBN, B_NAME, B_DESCRIPTION, B_QUOTE,"
            + "B_COUNT,B_PRICE,B_RATING,B_FRONT_IMG,B_BACK_IMG,B_HDR01_IMG,B_HDR02_IMG) "
            + "VALUES(BOOK_SEQ_TMP.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE BOOK SET B_NAME=?,B_COUNT=?,B_PRICE=?,B_DESCRIPTION=? WHERE B_ISBN=?";
    private static final String SQL_UPDATE_IMAGES = "UPDATE BOOK SET B_FRONT_IMG=?,B_BACK_IMG=?,B_HDR01_IMG=?,B_HDR02_IMG=? WHERE B_ISBN=?";
    private static final String SQL_DELETE = "DELETE FROM BOOK WHERE B_ISBN=?";

    private static final String SQL_UPDATE_COUNT = "UPDATE BOOK SET B_COUNT=? WHERE B_ISBN=?";
    private static final String SQL_SELECT_COUNT = "sELECT B_COUNT FROM BOOK where B_ISBN=?";
    Session session = null;

    private static final String HQL_READ_BOOKS = "from Book";
    private static final String HQL_READ_BOOKBYNAME = "from Book where BName=? ";
    private static final String HQL_SELECT_COUNT = "SELECT b.BCount FROM Book b where b.BIsbn =?";

    public Book_Dao() {

    }

    public boolean add(Book bookObj) throws SQLException {
        boolean isAdded =false;
        try {

            session = DbConnctor.opensession();
            session.getTransaction().begin();
            session.persist(bookObj);
            session.getTransaction().commit();
            isAdded = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdded;
    }

    public boolean update(Book bookObj) throws SQLException {

        try {
            session = DbConnctor.opensession();
            session.getTransaction().begin();
            session.merge(bookObj);
            session.getTransaction().commit();

        } catch (SQLException e) {
            e.printStackTrace();
        } 
           
        
        return false;
    }

    public boolean updateImages(Book bookObj) throws SQLException {

             Book bookForUpdate = this.readByIsbn(bookObj.getBIsbn());
        bookForUpdate.setImages(bookObj.getBFrontImg(),bookObj.getBBackImg(),bookObj.getBHdr01Img(),bookObj.getBHdr02Img());
      return update(bookForUpdate);
    }

    public boolean delete(int bookID) throws SQLException {
        try {

            session = DbConnctor.opensession();
            session.getTransaction().begin();
            session.delete(new Book(bookID));
            session.getTransaction().commit();

        } catch (SQLException ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();

        }
        return true;
    }

    public List<Book> readAll() throws SQLException {
        List<Book> bookList = new ArrayList();

        try {
            session = DbConnctor.opensession();
            session.beginTransaction();
            Query query = session.createQuery(HQL_READ_BOOKS);
            bookList = query.list();
           
            session.getTransaction().commit();

        } catch (SQLException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }

        return bookList;
    }

    public Book readByName(String bookName) throws SQLException {
        Book book = null;

        try {

            session = DbConnctor.opensession();
            session.beginTransaction();
            Query query = session.createQuery(HQL_READ_BOOKBYNAME).setString(0, bookName);
            book = (Book) query.uniqueResult();
            session.getTransaction().commit();
        } catch (SQLException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        
           
        }
        return book;
    }

    public Book readByIsbn(int isbn) throws SQLException {
        Book book = null;

        try {

            session = DbConnctor.opensession();
            session.getTransaction().begin();
            book = (Book) session.get(Book.class, isbn);
            session.getTransaction().commit();

          
        } catch (SQLException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } 
           
        
        return book;
    }
//<editor-fold defaultstate="collapsed" desc="for delete">
//    
//    public List<Book> customerCartBooks(int CustmerID) throws SQLException {
//        ArrayList<Book> bookList = new ArrayList();
//        try {
//            session = DbConnctor.opensession();
//            Book book = null;
////            statement = session.prepareStatement(SQL_RETRIVE_Books_InCart);
//            statement.setInt(1, CustmerID);
//            resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                book = new Book();
//                book.setBIsbn(Integer.parseInt(resultSet.getString(1)));
//                book.setBName(resultSet.getString(2));
////                book.setBDescription(resultSet.getString(3));
////                book.setBQuote(resultSet.getString(4));
//                book.setBCount(resultSet.getInt(5));
//                book.setBPrice(resultSet.getDouble(6));
////                book.setBRating(resultSet.getInt(7));
//                
//                // images folder path
//                String imagesFolder = book.getBIsbn() + "/";
//                
//                book.setBFrontImg(imagesFolder + resultSet.getString(8));
//                book.setBBackImg(imagesFolder + resultSet.getString(9));
////                book.setBHdr01Img(imagesFolder + resultSet.getString(10));
////                book.setBHdr02Img(imagesFolder + resultSet.getString(11));
//                bookList.add(book);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            DbConnctor.closesession();
//        }
//        return bookList;
//    }
//</editor-fold>

    public int getBookCount(int bookID) throws SQLException {
        int count = 0;
        try {
            session = DbConnctor.opensession();;
            session.beginTransaction();
            Query query = session.createQuery(HQL_SELECT_COUNT).setInteger(0, bookID);
            count = (int) query.uniqueResult();
            session.getTransaction().commit();

        } catch (SQLException ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
        } 

           
        
        return count;
    }

    public boolean updateCount(Book book) throws SQLException {
        Book bookForUpdate = this.readByIsbn(book.getBIsbn());
        bookForUpdate.setBCount(book.getBCount());
      return update(bookForUpdate);
    }

}
