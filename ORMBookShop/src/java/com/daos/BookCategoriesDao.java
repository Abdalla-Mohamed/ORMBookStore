/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daos; import org.hibernate.Session;

import com.beans.Book;
import com.beans.Category;
import com.utilts.DbConnctor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hosam
 */
public class BookCategoriesDao {

    private static final String SQL_SELECT_BY_BOOK = "SELECT * FROM BOOK_CATEGORY where BOOK_ID = ?";
    private static final String SQL_SELECT_BY_CATEGORY = "SELECT * FROM BOOK_CATEGORY where CATG_ID = ?";
    private static final String SQL_INSERT = "INSERT INTO BOOK_CATEGORY(BOOK_ID,CATG_ID) values(?,?)";
    private static final String SQL_DELETE = "DELETE FROM BOOK_CATEGORY WHERE CAT_ID=? and BOOK_ID =?";
    private static final String BOOKS_LIST = "SELECT * FROM BOOK where B_ISBN IN (select BOOK_ID from BOOK_CATEGORY where CATG_ID =?)";
    private static final String CATEGORIES_OF_BOOK = "SELECT * FROM CATEGORY where CAT_ID IN (select CATG_ID from BOOK_CATEGORY where BOOK_ID =?)";
    private static final String BOOKS_WITH_NO_CATEGORY = "SELECT * FROM BOOK where B_ISBN NOT IN (select BOOK_ID from BOOK_CATEGORY)";
    private static final String BOOKS_IN_OTHER_CAT = "SELECT * FROM BOOK where B_ISBN NOT IN(?) ";
    Session session = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    public boolean add(int categoryId, int bookId) throws SQLException {

        boolean added = false;
        try {

            session = DbConnctor.opensession();
//            statement = session.prepareStatement(SQL_INSERT);
            statement.setInt(1, bookId);
            statement.setInt(2, categoryId);

            if (statement.executeUpdate() > 0) {
                added = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnctor.closesession();
        }
        return added;

    }

    public boolean delete(int categoryId, int bookID) throws SQLException {

        Boolean deleted = true;
        try {
            session = DbConnctor.opensession();
//            statement = session.prepareStatement(SQL_DELETE);
            statement.setInt(1, categoryId);
            statement.setInt(2, bookID);
            if (statement.executeUpdate() > 0) {
                deleted = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnctor.closesession();
        }
        return deleted;
    }

    public List<Book> getBooksByCategory(int categoryID) throws SQLException {
        ResultSet result;
        List<Book> list = null;
        try {
            session = DbConnctor.opensession();
//            statement = session.prepareStatement(BOOKS_LIST);
            statement.setInt(1, categoryID);
            result = statement.executeQuery();
            list = getBooks(result);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnctor.closesession();
        }

        return list;
    }
    
    public List<Book> getOtherCatBooks(int categoryID) throws SQLException {
        ResultSet result;
        List<Book> list = null;
        try {
            session = DbConnctor.opensession();
//            statement = session.prepareStatement(BOOKS_IN_OTHER_CAT);
            statement.setInt(1, categoryID);
            result = statement.executeQuery();
            list = getBooks(result);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnctor.closesession();
        }

        return list;
    }
    
    public List<Book> getBooksWithNoCategory() throws SQLException {
        ResultSet result;
        List<Book> list = null;
        try {
            session = DbConnctor.opensession();
//            statement = session.prepareStatement(BOOKS_WITH_NO_CATEGORY);
            result = statement.executeQuery();
            list = getBooks(result);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnctor.closesession();
        }

        return list;
    }

    private List<Book> getBooks(ResultSet result) {

        List<Book> list = new ArrayList();
        Book book;

        try {

            while (result.next()) {

                book = new Book();

                book.setBIsbn(result.getInt(1));
                book.setBName(result.getString(2));
                book.setBDescription(result.getString(3));
                book.setBQuote(result.getString(4));
                book.setBCount(result.getInt(5));
                book.setBPrice(result.getDouble(6));
                book.setBRating(result.getInt(7));

                // images folder path
                String imagesFolder = Book.uplodedImgFolderDestntion + book.getBIsbn()+"\\";

                book.setBFrontImg(imagesFolder + result.getString(8));
                book.setBBackImg(imagesFolder + result.getString(9));
                book.setBHdr01Img(imagesFolder + result.getString(10));
                book.setBHdr02Img(imagesFolder + result.getString(11));
                list.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookCategoriesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Category> getCategoriesOfBook(int bookId) throws SQLException {

        ResultSet result;
        List<Category> list = null;

        try {

            session = DbConnctor.opensession();
//            statement = session.prepareStatement(CATEGORIES_OF_BOOK);
            statement.setInt(1, bookId);
            result = statement.executeQuery();
            list = getCategories(result);
        } catch (SQLException ex) {
            Logger.getLogger(BookCategoriesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            DbConnctor.closesession();
        }
        return list;
    }

    private List<Category> getCategories(ResultSet result) {

        List<Category> list = new ArrayList();
        Category category;

        try {

            while (result.next()) {
                category = new Category();
                category.setCatId(result.getInt("CAT_ID"));
                category.setCatName(result.getString("CAT_NAME"));
                list.add(category);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Interests_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
