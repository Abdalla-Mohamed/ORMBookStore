/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import java.io.Serializable;



/**
 *
 * @author Abdalla
 */
public class OrderBook implements Serializable {
    private Integer id;
    private Integer count;
    private Book bookId;
    private Orders orderNo;

    public OrderBook() {
    }

    public OrderBook( Integer count, Book bookId, Orders orderNo) {
        
        this.count = count;
        this.bookId = bookId;
        this.orderNo = orderNo;
    }

    public OrderBook(Integer id, Integer count, Book bookId, Orders orderNo) {
        this.id = id;
        this.count = count;
        this.bookId = bookId;
        this.orderNo = orderNo;
    }
    
    
    
    

    public OrderBook(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    public Orders getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Orders orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderBook)) {
            return false;
        }
        OrderBook other = (OrderBook) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.OrderBook[ id=" + id + " ]";
    }
    
}
