/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daos;

import org.hibernate.Session;

import com.beans.Orders;
import com.utilts.DbConnctor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author ElGazzar
 */
public class Orders_Dao {

 private final String hqlFrom = "from ORDERS";

 private    Session session = null;

    public void addOrder(Orders order) {
        try {

            session = DbConnctor.opensession();
            session.getTransaction().begin();
            session.persist(order);
            session.getTransaction().commit();

            
        } catch (SQLException ex) {
             session.getTransaction().rollback();
            ex.printStackTrace();
        }
    }

    public void updateOrder(Orders order) {
        try {
           
            session = DbConnctor.opensession();
            session.getTransaction().begin();
            session.merge(order);
            session.getTransaction().commit();

        } catch (SQLException ex) {
                     session.getTransaction().rollback();
            ex.printStackTrace();
        }
    }


    
    
    public boolean deleteOrders(int orderId) throws SQLException {
        try {
           
            session = DbConnctor.opensession();
            session.getTransaction().begin();
            session.delete(new Orders(orderId));
            session.getTransaction().commit();

        } catch (SQLException ex) {
             session.getTransaction().rollback();
            ex.printStackTrace();

        }
        return true;
    }

    public ArrayList selectByOrderId(int id) throws SQLException {

        ArrayList arr = new ArrayList();
        try {
              session = DbConnctor.opensession();
//            session.getTransaction().begin();
            Orders order = (Orders) session.get(Orders.class,id);
//            session.getTransaction().commit();
            arr.add(order);
            
        } catch (SQLException ex) {
               
  ex.printStackTrace();
        }

        return arr;
    }

   
    public List<Orders> getAllOrders() throws SQLException {

        List<Orders> orderList = new ArrayList<Orders>();
        try {
           session = DbConnctor.opensession();
            Query query = session.createQuery(hqlFrom);
            orderList= query.list();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return orderList;
    }

}
