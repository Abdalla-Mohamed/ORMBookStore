/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daos; 

import com.beans.Customer;
import com.utilts.DbConnctor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Hosam
 */
public class Customer_Dao {
    
    Session session = null;
            
    private static final String HQL_VALID = "from Customer c where c.CEmail = ?";
    private static final String HQL_LOGIN = "FROM Customer c WHERE c.CEmail =? AND c.CPassword =? ";
    private static final String HQL_GET_ALL = "FROM Customer";
    private static final String HQL_FIND_BY_NAME = "FROM Customer c where c.CName = ?";
    private static final String HQL_GET_CREDIT = "SELECT c.CCredit FROM Customer c where c.CId = ?";

    
    
      public boolean validEmail(String email) throws SQLException {
        
          boolean valid = false;
          
          
            session = DbConnctor.opensession();
            session.getTransaction().begin();
            
          Query query=session.createQuery(HQL_VALID).setString(0, email);
           List l= query.list();
           
            if (l.size()>0) {
                valid = true;
            } 
        
        DbConnctor.closesession();
        
        return valid;
    }
      
      
      
      public Customer login(String email, String passwd) throws SQLException {

        Customer customer = null;
        
        session = DbConnctor.opensession();
        session.getTransaction().begin();
        
        Query query=session.createQuery(HQL_LOGIN).setString(0, email).setString(1, passwd);
        List l= query.list();
        if (l.size()>0){
           
              customer= (Customer)l.get(0);
        }
               
        DbConnctor.closesession();
        
        return customer;
      }
      
      
       public boolean signUp(Customer c) throws SQLException {
        
        Boolean valid=false;
        
         if (!validEmail(c.getCEmail())) {
            
                valid=true;
                
                c.setCCredit(0);
        
            session = DbConnctor.opensession();
            session.getTransaction().begin();
            session.persist(c);
            session.getTransaction().commit();
               
       }
      return valid;
      
       }
       public List<Customer> getAllCustomers() throws SQLException {

        List<Customer> customerList = new ArrayList<Customer>();
        session = DbConnctor.opensession();
        session.getTransaction().begin();
        
        Query query=session.createQuery(HQL_GET_ALL);
        customerList= query.list();
        
        DbConnctor.closesession();
        
        return customerList;
       }    
       
       
     public List<Customer> findByName(String name) throws SQLException {

       List<Customer> customerList = new ArrayList<Customer>();
        
        session = DbConnctor.opensession();
        session.getTransaction().begin();
        
        Query query=session.createQuery(HQL_FIND_BY_NAME).setString(0, name);
        customerList= query.list();
        
        DbConnctor.closesession();
        
        return customerList;
     }
   
     
     public boolean update (Customer c) throws SQLException{
                
        boolean updated;   
        
            session = DbConnctor.opensession();
            session.getTransaction().begin();
            session.merge(c);
            session.getTransaction().commit();
                       
    return true;
     }
     
     
     
      public boolean updateCredit (Customer c) throws SQLException{
                
        boolean updated;   
        session = DbConnctor.opensession();
            session.getTransaction().begin();
            session.merge(c);
            session.getTransaction().commit();
                       
    return true;
     }
      
      
      public boolean deleteCustomer(int CustId) throws SQLException {
           
            session = DbConnctor.opensession();
            session.getTransaction().begin();
            session.delete(new Customer(CustId));
            session.getTransaction().commit();

            return true;
      }
      
       public double getCustomerCredit(int customerId) throws SQLException {
          double cridit=0;
          Customer customer;
            session = DbConnctor.opensession();
            session.getTransaction().begin();
            
          Query query=session.createQuery(HQL_GET_CREDIT).setInteger(0, customerId);
           List l= query.list();
           
            if (l.size()>0) {
                cridit= (int) l.get(0) ;
                
            } 
        
        DbConnctor.closesession();
      return  cridit;
      
       }
}

