/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daos; import org.hibernate.Session;

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

/**
 *
 * @author Administrator
 */
public class Cart_Dao {

    private static final String CountOfBookInCart = "select NVL(sum(C_B_COUNT),0) from BOOKSTORE.CART WHERE  C_ID=? and B_ID=?";
    private static final String SQL_READ = "SELECT * FROM CART WHERE C_ID= ? ORDER BY B_ID desc";
    private static final String SQL_INSERT = "INSERT INTO CART(B_ID,C_ID,C_B_COUNT) VALUES(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE CART SET C_B_COUNT=? WHERE C_ID=? and B_ID=?";
    private static final String SQL_DELETE = "DELETE FROM CART WHERE C_ID=? and B_ID=?";
    private static final String SQL_DELETE_USER_CART = "DELETE FROM CART WHERE C_ID=? ";

    Session session = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    public Cart_Dao() {

    }

    public int countInCart(Cart cartObj) throws SQLException {
       int count=0;
        try {

            session = DbConnctor.opensession();
//            statement = session.prepareStatement(CountOfBookInCart);
//            statement.setInt(1, cartObj.getCustomerId());
//            statement.setInt(2, cartObj.getBookId());
           ResultSet executeQuery = statement.executeQuery();
           executeQuery.next();
           
           count=executeQuery.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnctor.closesession();
        }
        return count;
    }

    public boolean add(Cart cartObj) throws SQLException {
        try {

            session = DbConnctor.opensession();
//            statement = session.prepareStatement(SQL_INSERT);
//            statement.setInt(1, cartObj.getBookId());
//            statement.setInt(2, cartObj.getCustomerId());
//            statement.setInt(3, cartObj.getCBCount());
            if (statement.executeUpdate() > 0) {
                return true;
            }
//            session.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnctor.closesession();
        }
        return false;
    }

    public boolean update(Cart cartObj) throws SQLException {

        try {
            session = DbConnctor.opensession();
//            statement = session.prepareStatement(SQL_UPDATE);
            statement.setInt(1, cartObj.getCBCount());
//            statement.setInt(2, cartObj.getCustomerId());
//            statement.setInt(3, cartObj.getBookId());
            if (statement.executeUpdate() > 0) {
                return true;
            }
//            session.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnctor.closesession();
        }
        return false;
    }

    public boolean delete(Cart cartItem) throws SQLException {

        try {
            session = DbConnctor.opensession();
//            statement = session.prepareStatement(SQL_DELETE);
//            statement.setInt(1, cartItem.getCustomerId());
//            statement.setInt(2, cartItem.getBookId());
            if (statement.executeUpdate() > 0) {
                return true;
            }
//            session.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnctor.closesession();
        }
        return false;
    }

    public List<Cart> readAll(int customerID) throws SQLException {
        List<Cart> cartList = null;
        try {
            session = DbConnctor.opensession();
            Cart cart = null;
//            statement = session.prepareStatement(SQL_READ);
            statement.setInt(1, customerID);
            resultSet = statement.executeQuery();
            cartList = getCart(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnctor.closesession();
        }
        return cartList;
    }

    private List<Cart> getCart(ResultSet result) {

        List<Cart> list =null;
        Cart cartItem;
        try {
            while (result.next()) {
                if(list == null){
                    list = new ArrayList<>();
                }
                cartItem = new Cart();
                cartItem.setCBCount(result.getInt("C_B_COUNT"));
//                cartItem.setCustomer(new Customer(result.getInt("C_ID")));
                //bookObj.setBDescription(result.getString("B_DESCRIPTION"));
                list.add(cartItem);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Interests_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean freeCartOfCustmer(int customerId) throws SQLException {
       boolean isDeleted = false;
        try {
            session = DbConnctor.opensession();
//            statement = session.prepareStatement(SQL_DELETE_USER_CART);
            statement.setInt(1, customerId);
            if (statement.executeUpdate() > 0) {
                isDeleted= true;
            }
//            session.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnctor.closesession();
        }
        return isDeleted;
    }
}
