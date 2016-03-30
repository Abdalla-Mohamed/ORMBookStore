/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import java.io.Serializable;

import java.util.List;

/**
 *
 * @author Abdalla
 */

public class Category implements Serializable {
    private Integer catId;
    private String catName;
    private List<Book> bookList;
    private List<Customer> customerList;

    public Category() {
    }

    public Category( String catName, List<Book> bookList, List<Customer> customerList) {
        this.catName = catName;
        this.bookList = bookList;
        this.customerList = customerList;
    }

    public Category(Integer catId, String catName, List<Book> bookList, List<Customer> customerList) {
        this.catId = catId;
        this.catName = catName;
        this.bookList = bookList;
        this.customerList = customerList;
    }
    
    

    
    
    public Category(Integer catId) {
        this.catId = catId;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catId != null ? catId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.catId == null && other.catId != null) || (this.catId != null && !this.catId.equals(other.catId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Category[ catId=" + catId + " ]";
    }
    
}
