/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daos; import org.hibernate.Session;

import com.beans.Customer;
import com.beans.OrderBook;
import com.beans.Orders;
import com.utilts.DbConnctor;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ElGazzar
 */
public class Orders_Dao {
    Session session = null;
    PreparedStatement pstatement = null;
    Statement statement = null;
    ResultSet resultSet = null;
    
    Customer customer;
    
    public void addOrder(Orders order)
    {
        try {                
            session = DbConnctor.opensession();
            String sql= "INSERT INTO ORDERS(ORDER_DATE, TOTAL, CUSTOMER_ID,ORDER_ID )"
                        + "VALUES(?,?,?,ORDER_SEQ_TMP.NEXTVAL)";
//            pstatement = session.prepareStatement(sql);
                
            pstatement.setDate(1, (Date) order.getOrderDate());
            pstatement.setDouble(2, order.getTotal());
//            pstatement.setInt(3,order.getCustomerId().getCId());
            
               
                
            pstatement.executeUpdate();
            
//            int selectLastOrderId = selectLastOrderId();
//             OrderBook_Dao orderBook_Dao = new OrderBook_Dao();
//           List<OrderBook> orderBookList = order.getOrderBookList();
//            for (OrderBook orderItem : orderBookList) {
//                orderItem.setOrderNo(new Orders(selectLastOrderId));
//                orderBook_Dao.addOrderBook(orderItem);
//            }
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
    }
    
    public void updateOrder(Orders order)
    {
        try {                
            session = DbConnctor.opensession();
            String sql= "UPDATE ORDERS SET ORDER_DATE=? AND TOTAL=? WHERE OREDR_ID='"+order.getOrderId()+"'";
//            pstatement = session.prepareStatement(sql);
                
            pstatement.setDate(1, (Date) order.getOrderDate());
            pstatement.setDouble(2, order.getTotal());
               
                
            pstatement.executeUpdate();
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
    }
    
    public boolean deleteOrders(int orderId) throws SQLException {
        try {
            session = DbConnctor.opensession();
//            statement = session.createStatement();
            String query = "DELETE FROM ORDERS WHERE ORDER_ID='"+orderId+"'";
              
            statement.executeUpdate(query);
                
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            
        }
        finally {

                DbConnctor.closesession();
            }
        return true;
    }
    
    public ArrayList selectByOrderId(int id) throws SQLException{
        
         ArrayList arr = new ArrayList();
        try {
            session = DbConnctor.opensession();;
//            pstatement = session.prepareStatement("SELECT * FROM ORDERS WHERE ORDER_ID =?");
            pstatement.setInt(1, id);
            resultSet = pstatement.executeQuery();
            
            while(resultSet.next())
            {
                int orderid = resultSet.getInt("ORDER_ID");
                Date orderDate = resultSet.getDate("ORDER_DATE");
                double cEmail = resultSet.getDouble("TOTAL");
                
                Orders orders = new Orders(orderDate, cEmail, null, null);
                arr.add(orders);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
      finally {

                DbConnctor.closesession();
            }
        
        return arr;
    }
    private int selectLastOrderId() throws SQLException{
        int lastID=0;
        try {
            session = DbConnctor.opensession();;
//            pstatement = session.prepareStatement("select max(ORDER_ID) from BOOKSTORE.ORDERS");
            resultSet = pstatement.executeQuery();
            
            while(resultSet.next())
            {
                lastID = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
      finally {

                DbConnctor.closesession();
            }
        
        return lastID;
    }
    
    public List<Orders> getAllOrders() throws SQLException {
        
        List<Orders> orderList = new ArrayList<Orders>();
        try {
            session = DbConnctor.opensession();
//            statement = session.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM ORDERS");
            while (resultSet.next()) {
                Orders order = new Orders();
                
                order.setOrderDate(resultSet.getDate("ORDER_DATE"));
                order.setTotal(resultSet.getDouble("TOTAL"));
                
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DbConnctor.closesession();
        }

        return orderList;
    }
    
    
}
