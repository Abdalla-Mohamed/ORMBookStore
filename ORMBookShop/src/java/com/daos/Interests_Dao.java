/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daos; import org.hibernate.Session;

import com.beans.Category;
//import com.beans.Interests;
import com.utilts.DbConnctor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hosam
 */
public class Interests_Dao {

    private static final String SQL_SELECT = "SELECT * FROM INTEREST where CUSTOMER_ID = ?";
    private static final String SQL_INSERT = "INSERT INTO INTEREST(CUSTOMER_ID,CAT_ID) values(?,?)";
    private static final String SQL_DELETE = "DELETE FROM INTEREST WHERE CAT_ID=? and CUSTOMER_ID =?";
    private static final String CAT_LIST = "SELECT * FROM CATEGORY where CAT_ID IN (select CAT_ID from INTEREST where CUSTOMER_ID =?)";
    private static final String SQL_DELETECCUSTOMERCAT = "DELETE FROM INTEREST WHERE CUSTOMER_ID =?";
   
    
    
    Session session = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    public boolean add(int categoryId, int customerId) throws SQLException {

        Boolean added = false;
        try {
            session = DbConnctor.opensession();
//            statement = session.prepareStatement(SQL_INSERT);
            statement.setInt(1, customerId);
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

    public boolean delete(int categoryId, int customerId) throws SQLException {

        Boolean deleted = true;
        try {
            session = DbConnctor.opensession();
//            statement = session.prepareStatement(SQL_DELETE);
            statement.setInt(1, categoryId);
            statement.setInt(2, customerId);
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

//    public List<Category> getCustomerCategories(int customerId)throws SQLException {
//        ResultSet result;
//        List<Category> list = null;
//        try {
//            session = DbConnctor.opensession();
////            statement = session.prepareStatement(CAT_LIST);
//            statement.setInt(1, customerId);
//            result =statement.executeQuery();
//            list=getCategories(result);
//            
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            DbConnctor.closesession();
//        }
//        
//        return list;
//    }

    
    private List<Category> getCategories(ResultSet result){
        
            List<Category>list = new ArrayList() ;
            Category category;
            
        try {
                        
            while(result.next()){
                category=new Category();
                category.setCatId(result.getInt("CAT_ID"));
                category.setCatName(result.getString("CAT_NAME"));
                list.add(category);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Interests_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
      public boolean deleteCustomersCategories(int customerId) throws SQLException {

        Boolean deleted = true;
        try {
            session = DbConnctor.opensession();
//            statement = session.prepareStatement(SQL_DELETECCUSTOMERCAT);
            statement.setInt(1, customerId);
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
      
      
}
