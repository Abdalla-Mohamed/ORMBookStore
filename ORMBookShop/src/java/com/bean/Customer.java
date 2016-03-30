/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.daos.Customer_Dao;
import java.io.Serializable;
import java.sql.SQLException;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdalla
 */
public class Customer implements Serializable {
    private Integer cId;
    private String cName;
    private String cEmail;
    private String cPassword;
    private String cJob;
    private String cAddress;
    private String cMobile;
    private Integer cCredit;
    private List<Category> categoryList;
    private List<Orders> ordersList;
    private List<Cart> cartList;

    public Customer() {
    }

    public Customer( String cName, String cEmail, String cPassword, String cJob, String cAddress, String cMobile, Integer cCredit, List<Category> categoryList, List<Orders> ordersList, List<Cart> cartList) {
        
        this.cName = cName;
        this.cEmail = cEmail;
        this.cPassword = cPassword;
        this.cJob = cJob;
        this.cAddress = cAddress;
        this.cMobile = cMobile;
        this.cCredit = cCredit;
        this.categoryList = categoryList;
        this.ordersList = ordersList;
        this.cartList = cartList;
    }

    public Customer(Integer cId, String cName, String cEmail, String cPassword, String cJob, String cAddress, String cMobile, Integer cCredit, List<Category> categoryList, List<Orders> ordersList, List<Cart> cartList) {
        this.cId = cId;
        this.cName = cName;
        this.cEmail = cEmail;
        this.cPassword = cPassword;
        this.cJob = cJob;
        this.cAddress = cAddress;
        this.cMobile = cMobile;
        this.cCredit = cCredit;
        this.categoryList = categoryList;
        this.ordersList = ordersList;
        this.cartList = cartList;
    }
    

    
    
    
    public Customer(Integer cId) {
        this.cId = cId;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public String getCEmail() {
        return cEmail;
    }

    public void setCEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getCPassword() {
        return cPassword;
    }

    public void setCPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    public String getCJob() {
        return cJob;
    }

    public void setCJob(String cJob) {
        this.cJob = cJob;
    }

    public String getCAddress() {
        return cAddress;
    }

    public void setCAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public String getCMobile() {
        return cMobile;
    }

    public void setCMobile(String cMobile) {
        this.cMobile = cMobile;
    }

    public Integer getCCredit() {
        return cCredit;
    }

    public void setCCredit(Integer cCredit) {
        this.cCredit = cCredit;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cId != null ? cId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Customer[ cId=" + cId + " ]";
    }
    
    
//    public List<Customer> getAllCustomers(){
//        
//        List<Customer>list=null;
//        Customer_Dao cDao=new Customer_Dao();
//        
//        try {
//            list=cDao.getAllCustomers();
//        } catch (SQLException ex) {
//            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//    }
    
    
}
