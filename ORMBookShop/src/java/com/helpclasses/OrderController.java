/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helpclasses;

import com.beans.Book;
import com.beans.Cart;
import com.beans.Customer;
import com.beans.OrderBook;
import com.beans.Orders;
import com.daos.Book_Dao;
import com.daos.Customer_Dao;
import com.daos.Orders_Dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdalla
 */
public class OrderController {

    Orders_Dao orderDao;

    public OrderController() {
        orderDao = new Orders_Dao();
    }

    public boolean checkoutTheCart(int customerId, double total) {
        boolean isDone = false;
        CartController cartController = new CartController();
        List<Cart> customerCart = cartController.getCustomerCart(customerId);

        if (isOrderValid(customerCart, total)) {
            if (updateClientAndBooks(customerCart, total)) {
                if (cartController.freeCart(customerId)) {
                    Orders newOrders = new Orders(new Date(), total, null, new Customer(customerId));
                    List<OrderBook> orderBooks = getOrederItems(customerCart,newOrders);
                    newOrders.setOrderBooks(new HashSet<OrderBook>(orderBooks));
                    orderDao.addOrder(newOrders);
                    isDone = true;
                }
            }
        }
        return isDone;
    }

    private List<OrderBook> getOrederItems(List<Cart> customerCart,Orders newOrders) {
        List<OrderBook> orderBooks = new ArrayList<>();
        for (Cart item : customerCart) {
            OrderBook orderBook = new OrderBook(null, item.getBook(), newOrders, item.getCBCount());
            orderBooks.add(orderBook);
        }
        return orderBooks;
    }

    private boolean updateClientAndBooks(List<Cart> customerCart, double total) {
        boolean isUpdated = false;
        try {
            int customerId = customerCart.get(0).getCustomer().getCId();

            double cridt = new Customer_Dao().getCustomerCredit(customerId);
            double newCridit = cridt - total;
            Customer customer = new Customer(customerId);
            customer.setCCredit((int) newCridit);
            new Customer_Dao().updateCredit(customer);

            for (Cart cartItem : customerCart) {
                int bookCount = new Book_Dao().getBookCount(cartItem.getBook().getBIsbn());
                int newCount = bookCount - cartItem.getCBCount();
                Book book = new Book(cartItem.getBook().getBIsbn());
                book.setBCount(newCount);
                new Book_Dao().updateCount(book);
            }
            isUpdated = true;

        } catch (SQLException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isUpdated;

    }

    private boolean isOrderValid(List<Cart> customerCart, double total) {
        boolean isValid = false;
        if (customerCart.isEmpty()) {
            return false;
        }
        try {
            double cridt = new Customer_Dao().getCustomerCredit(customerCart.get(0).getCustomer().getCId());

            if (cridt > total) {
                isValid = true;
            }

            for (Cart cartItem : customerCart) {
                double bookCount = new Book_Dao().getBookCount(cartItem.getBook().getBIsbn());
                if (bookCount < cartItem.getCBCount()) {
                    isValid = false;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isValid;
    }

}
