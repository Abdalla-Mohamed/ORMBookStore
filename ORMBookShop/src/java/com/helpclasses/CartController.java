/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helpclasses;

import com.beans.Book;
import com.beans.Book;
import com.beans.Cart;
import com.beans.Customer;
import com.daos.Book_Dao;
import com.daos.Cart_Dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hosam
 */
public class CartController {

    Cart_Dao cartDao;

    public CartController() {
        cartDao = new Cart_Dao();
    }

    public boolean addItemInCart(Cart cart) {
        boolean added = false;
        try {
            int countInCart = cartDao.countInCart(cart);
            if (countInCart == 0) {
                added = cartDao.add(cart);
            } else {
                cart.addOnCount(countInCart);
                added = cartDao.update(cart);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return added;
    }

    public List<Cart> getCustomerCart(int customerId) {
        List<Cart> theCart = null;
        try {
            theCart = cartDao.readAll(customerId);

            if (theCart != null && !theCart.isEmpty()) {
                            Iterator<Cart> iteratorCart = theCart.iterator();

                List<Book> customerCartBooks = new Book_Dao().customerCartBooks(customerId);
                for (Iterator<Book> iterator = customerCartBooks.iterator(); iterator.hasNext();) {
                    Cart cartN = iteratorCart.next();
                    Book bookN = iterator.next();
                    cartN.setBook(bookN);
                    cartN.setCustomer(new Customer(customerId));
                }

            }else{
                theCart = new ArrayList<>();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return theCart;
    }

    public boolean freeCart(int customerId) {
        boolean deleted = false;
        try {
            deleted = cartDao.freeCartOfCustmer(customerId);

        } catch (SQLException ex) {
            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return deleted;

    }

}
