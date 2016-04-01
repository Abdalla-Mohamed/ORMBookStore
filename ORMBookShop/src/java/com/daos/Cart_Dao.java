/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daos;

import org.hibernate.Session;

import com.beans.Book;
import com.beans.Customer;
import com.beans.Cart;
import com.beans.Category;
import com.utilts.DbConnctor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author Administrator
 */
public class Cart_Dao {

//    private static final String CountOfBookInCart = "select NVL(sum(C_B_COUNT),0) from BOOKSTORE.CART WHERE  C_ID=? and B_ID=?";
    private static final String SQL_READ = "SELECT * FROM CART WHERE C_ID= ? ORDER BY B_ID desc";
    private static final String SQL_INSERT = "INSERT INTO CART(B_ID,C_ID,C_B_COUNT) VALUES(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE CART SET C_B_COUNT=? WHERE C_ID=? and B_ID=?";
    private static final String SQL_DELETE = "DELETE FROM CART WHERE C_ID=? and B_ID=?";
    private static final String SQL_DELETE_USER_CART = "DELETE FROM CART WHERE C_ID=? ";

    private static final String HQL_READ = "FROM  Cart  C  where C.customer.CId=?";
    private static final String CountOfBookInCart = "select NVL(sum(CBCount),0) from  Cart c  where  c.customer.CId= ? and c.book.BIsbn=?";
    private static final String HQL_DELETE = "DELETE  Cart C  WHERE C.customer.CId=?  and C.book.BIsbn=?";
    private static final String HQL_UPDATE = "UPDATE Cart   C set CBCount=? WHERE C.customer.CId=? and C.book.BIsbn=?";
    private static final String HQL_DELETE_USER_CART = "DELETE  Cart C  WHERE C.customer.CId=?";

    private  Session session = null;
   
    public Cart_Dao() {

    }

    public int countInCart(Cart cartObj) throws SQLException {
        int count = 0;
        try {
            session = DbConnctor.opensession();
           session.getTransaction().begin();
            Query query = session.createQuery(CountOfBookInCart).setParameter(0, cartObj.getId().getCId()).setParameter(1, cartObj.getId().getBId());
            count =( (Long)query.uniqueResult()).intValue();
            session.getTransaction().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public boolean add(Cart cartObj) throws SQLException {

        try {
            session = DbConnctor.opensession();
            session.beginTransaction();
            session.saveOrUpdate(cartObj);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Cart cartObj) throws SQLException {

        try {

            session = DbConnctor.opensession();
            session.getTransaction().begin();
            session.merge(cartObj);
            session.getTransaction().commit();
            return true;
        } catch (SQLException ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
            return false;
        }
    }

    public boolean delete(Cart cartItem) throws SQLException {

        try {

            session = DbConnctor.opensession();
            session.getTransaction().begin();
            session.delete(cartItem);
            session.getTransaction().commit();

            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }

    }

    public List<Cart> readAll(int customerID) throws SQLException {
        List<Cart> cartList = null;
        try {
            session = DbConnctor.opensession();
            session.beginTransaction();
            Query query = session.createQuery(HQL_READ).setParameter(0, customerID);;
            cartList = query.list();
            session.getTransaction().commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cartList;
    }

  
    public boolean freeCartOfCustmer(int customerId) throws SQLException {
        boolean isDeleted = false;
        try {
            session = DbConnctor.opensession();
            session.beginTransaction();
            Query query = session.createQuery(HQL_DELETE_USER_CART).setInteger(0, customerId);
            query.executeUpdate();
            session.getTransaction().commit();

        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();

        }
        return isDeleted;
    }
}
