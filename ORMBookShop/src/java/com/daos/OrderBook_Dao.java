/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daos; import org.hibernate.Session;

import com.beans.OrderBook;
import com.utilts.DbConnctor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ElGazzar
 */
public class OrderBook_Dao {
    Session session = null;
    PreparedStatement pstatement = null;
    Statement statement = null;
    ResultSet resultSet = null;
    
    
    
    public void addOrderBook(OrderBook orderBook) throws SQLException
    {
        try {                
            session = DbConnctor.opensession();
            String sql= "INSERT INTO ORDER_BOOK(O_B_ID, O_B_COUNT, BOOK_ID, ORDER_NO)"
                        + "VALUES(ORDER_BOOK_SEQ.NEXTVAL,?,?,?)";
//            pstatement = session.prepareStatement(sql);
                
//            pstatement.setInt(1,orderBook.getId());
//            pstatement.setInt(1, orderBook.getCount());
//            pstatement.setInt(2, orderBook.getBookId().getBIsbn());
//            pstatement.setInt(3, orderBook.getOrderNo().getOrderId());
//                
            pstatement.executeUpdate();
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        finally{
            DbConnctor.closesession();
        }
    }
    
    public boolean deleteOrderBook(int orderId) throws SQLException {
        try {
            session = DbConnctor.opensession();
//            statement = session.createStatement();
            String query = "DELETE FROM ORDER_BOOK WHERE O_B_ID='"+orderId+"'";
              
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
    
    
    public ArrayList<OrderBook> getAllOrderBook() throws SQLException
    {
        session = DbConnctor.opensession();
        ArrayList<OrderBook> orderList = new ArrayList<OrderBook>();
        try {
            session = DbConnctor.opensession();
//            statement = session.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM ORDER_BOOK");
            while (resultSet.next()) {
                OrderBook orderBook = new OrderBook();
                
//                orderBook.setId(resultSet.getInt("O_B_ID"));
//                orderBook.setCount(resultSet.getInt("O_B_COUNT"));
//                
                orderList.add(orderBook);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DbConnctor.closesession();
        }

        return orderList;
    }
}
