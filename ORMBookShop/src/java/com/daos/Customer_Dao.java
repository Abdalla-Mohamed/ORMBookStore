/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daos;

import com.beans.Category;
import com.beans.Customer;
import com.utilts.DbConnctor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        Query query = session.createQuery(HQL_VALID).setString(0, email);
        List l = query.list();

        if (l.size() > 0) {
            valid = true;
        }

        return valid;
    }

    public Customer login(String email, String passwd) throws SQLException {

        Customer customer = null;

        session = DbConnctor.opensession();
        session.getTransaction().begin();

        Query query = session.createQuery(HQL_LOGIN).setString(0, email).setString(1, passwd);
        List l = query.list();
        if (l.size() > 0) {

            customer = (Customer) l.get(0);
        }

        return customer;
    }

    public boolean signUp(Customer c) throws SQLException {

        Boolean valid = false;

        if (!validEmail(c.getCEmail())) {

            valid = true;

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

        Query query = session.createQuery(HQL_GET_ALL);
        customerList = query.list();

        return customerList;
    }

    public List<Customer> findByName(String name) throws SQLException {

        List<Customer> customerList = new ArrayList<Customer>();

        session = DbConnctor.opensession();
        session.getTransaction().begin();

        Query query = session.createQuery(HQL_FIND_BY_NAME).setString(0, name);
        customerList = query.list();

        return customerList;
    }

    public boolean update(Customer c) throws SQLException {

        boolean updated;

        session = DbConnctor.opensession();
        session.getTransaction().begin();
        session.merge(c);
        session.getTransaction().commit();

        return true;
    }

    public Customer findCustomerByID(int id) throws SQLException {

        Customer customer = null;

        session = DbConnctor.opensession();
        session.getTransaction().begin();
        customer = (Customer) session.get(Customer.class, id);
        session.getTransaction().commit();

        return customer;
    }

    public boolean updateCredit(Customer updatedCustomer) throws SQLException {

        boolean updated=false;
        
        Customer oldCustomer = findCustomerByID(updatedCustomer.getCId());
        oldCustomer.setCCredit(updatedCustomer.getCCredit());
        session = DbConnctor.opensession();
        session.getTransaction().begin();
        session.merge(oldCustomer);
        session.getTransaction().commit();

        return updated;
    }

    public boolean deleteCustomer(int CustId) throws SQLException {

        session = DbConnctor.opensession();
        session.getTransaction().begin();
        session.delete(new Customer(CustId));
        session.getTransaction().commit();

        return true;
    }

    public double getCustomerCredit(int customerId) throws SQLException {
        double cridit = 0;
        Customer customer;
        session = DbConnctor.opensession();
        session.getTransaction().begin();

        Query query = session.createQuery(HQL_GET_CREDIT).setInteger(0, customerId);
        List l = query.list();

        if (l.size() > 0) {
            cridit = (int) l.get(0);

        }

        return cridit;

    }
    public List<Category> getCustomerCategories(int customerId){
        List<Category>list=new ArrayList();
        try {
            Customer customer = findCustomerByID(customerId);
            list.addAll(customer.getCategories());
            
        } catch (SQLException ex) {
            Logger.getLogger(Customer_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
       return list;
    }
    
    public void deleteCustomersCategories(int customerId){
        
        try {
            Customer customer = findCustomerByID(customerId);
            customer.getCategories().clear();
            update(customer);
        } catch (SQLException ex) {
            Logger.getLogger(Customer_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addCcustomerInterests(int customerId,Set Categories){
        
         try {
             deleteCustomersCategories(customerId);
             
          Customer customer = findCustomerByID(customerId);
            
            customer.getCategories().addAll(Categories); 
             update(customer);
             
        } catch (SQLException ex) {
            Logger.getLogger(Customer_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
