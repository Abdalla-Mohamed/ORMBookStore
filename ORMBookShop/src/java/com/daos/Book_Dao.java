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
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    public Book_Dao() {

    }

    public boolean add(Book bookObj) throws SQLException {
        try {

            session = DbConnctor.opensession();
//            statement = session.prepareStatement(SQL_INSERT);
//            statement.setInt(1, bookObj.getBIsbn());
            statement.setString(1, bookObj.getBName());
            statement.setString(2, bookObj.getBDescription());
            statement.setString(3, bookObj.getBQuote());
            statement.setInt(4, bookObj.getBCount());
            statement.setDouble(5, bookObj.getBPrice());
            statement.setInt(6, bookObj.getBRating());
            statement.setString(7, bookObj.getBFrontImg());
            statement.setString(8, bookObj.getBBackImg());
            statement.setString(9, bookObj.getBHdr01Img());
            statement.setString(10, bookObj.getBHdr02Img());
            if (statement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnctor.closesession();
        }
        return false;
    }

    public boolean update(Book bookObj) throws SQLException {

        try {
            session = DbConnctor.opensession();
//            statement = session.prepareStatement(SQL_UPDATE);
            statement.setString(1, bookObj.getBName());
            statement.setInt(2, bookObj.getBCount());
            statement.setDouble(3, bookObj.getBPrice());
            statement.setString(4, bookObj.getBDescription());
            statement.setInt(5, bookObj.getBIsbn());
            if (statement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnctor.closesession();
        }
        return false;
    }

    public boolean updateImages(Book bookObj) throws SQLException {

        try {
            session = DbConnctor.opensession();
//            statement = session.prepareStatement(SQL_UPDATE_IMAGES);
            statement.setString(1, bookObj.getBFrontImg());
            statement.setString(2, bookObj.getBBackImg());
            statement.setString(3, bookObj.getBHdr01Img());
            statement.setString(4, bookObj.getBHdr02Img());
            statement.setInt(5, bookObj.getBIsbn());
            if (statement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnctor.closesession();
        }
        return false;
    }

    public boolean delete(int bookID) throws SQLException {

        try {
            session = DbConnctor.opensession();
//            statement = session.prepareStatement(SQL_DELETE);
            statement.setInt(1, bookID);
            if (statement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnctor.closesession();
        }
        return false;
    }

    public List<Book> readAll() throws SQLException {
        ArrayList<Book> bookList = new ArrayList();
        try {
            session = DbConnctor.opensession();
            Book book = null;
//            statement = session.prepareStatement(SQL_READ);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                book = new Book();
                book.setBIsbn(Integer.parseInt(resultSet.getString(1)));
                book.setBName(resultSet.getString(2));
                book.setBDescription(resultSet.getString(3));
                book.setBQuote(resultSet.getString(4));
                book.setBCount(resultSet.getInt(5));
                book.setBPrice(resultSet.getDouble(6));
                book.setBRating(resultSet.getInt(7));

                // images folder path
                String imagesFolder = book.getBIsbn() + "/";

                book.setBFrontImg(imagesFolder + resultSet.getString(8));
                book.setBBackImg(imagesFolder + resultSet.getString(9));
                book.setBHdr01Img(imagesFolder + resultSet.getString(10));
                book.setBHdr02Img(imagesFolder + resultSet.getString(11));
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnctor.closesession();
        }
        return bookList;
    }

    public Book readByName(String bookName) throws SQLException {
        Book book = null;

        try {

            session = DbConnctor.opensession();
//            statement = session.prepareStatement(SQL_READ_BY_NAME);
            statement.setString(1, bookName);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                book = new Book();
                book.setBIsbn(Integer.parseInt(resultSet.getString(1)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnctor.closesession();
        }
        return book;
    }

    public Book readByIsbn(int isbn) throws SQLException {
        Book book = null;

        try {

            session = DbConnctor.opensession();
//            statement = session.prepareStatement(SQL_READ_BY_ISBN);
            statement.setInt(1, isbn);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                book = new Book();
                book.setBIsbn(resultSet.getInt(1));
                book.setBName(resultSet.getString(2));
                book.setBDescription(resultSet.getString(3));
                book.setBQuote(resultSet.getString(4));
                book.setBCount(resultSet.getInt(5));
                book.setBPrice(resultSet.getDouble(6));
                book.setBRating(resultSet.getInt(7));

                // images folder path
//                String imagesFolder = Book.uplodedImgFolderDestntion + book.getBIsbn() + "\\";
                String imagesFolder = book.getBIsbn() + "/";

                book.setBFrontImg(imagesFolder + resultSet.getString(8));
                book.setBBackImg(imagesFolder + resultSet.getString(9));
                book.setBHdr01Img(imagesFolder + resultSet.getString(10));
                book.setBHdr02Img(imagesFolder + resultSet.getString(11));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnctor.closesession();
        }
        return book;
    }

    public List<Book> customerCartBooks(int CustmerID) throws SQLException {
        ArrayList<Book> bookList = new ArrayList();
        try {
            session = DbConnctor.opensession();
            Book book = null;
//            statement = session.prepareStatement(SQL_RETRIVE_Books_InCart);
            statement.setInt(1, CustmerID);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                book = new Book();
                book.setBIsbn(Integer.parseInt(resultSet.getString(1)));
                book.setBName(resultSet.getString(2));
//                book.setBDescription(resultSet.getString(3));
//                book.setBQuote(resultSet.getString(4));
                book.setBCount(resultSet.getInt(5));
                book.setBPrice(resultSet.getDouble(6));
//                book.setBRating(resultSet.getInt(7));

                // images folder path
                String imagesFolder = book.getBIsbn() + "/";

                book.setBFrontImg(imagesFolder + resultSet.getString(8));
                book.setBBackImg(imagesFolder + resultSet.getString(9));
//                book.setBHdr01Img(imagesFolder + resultSet.getString(10));
//                book.setBHdr02Img(imagesFolder + resultSet.getString(11));
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnctor.closesession();
        }
        return bookList;
    }

    public int getBookCount(int bookID) throws SQLException {
        int count = 0;
        try {
            session = DbConnctor.opensession();;
//            statement = session.prepareStatement(SQL_SELECT_COUNT);
            statement.setInt(1, bookID);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            DbConnctor.closesession();
        }
        return count;
    }

    public boolean updateCount(Book book) throws SQLException {

        boolean updated;
        try {
            session = DbConnctor.opensession();
//            statement = session.prepareStatement(SQL_UPDATE_COUNT);

            statement.setInt(1, book.getBCount());
            statement.setInt(2, book.getBIsbn());
            statement.executeUpdate();

            updated = true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            updated = false;
        }
        return updated;
    }

}
