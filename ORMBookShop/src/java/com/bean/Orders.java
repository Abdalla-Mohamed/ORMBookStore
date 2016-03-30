/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import java.io.Serializable;
import java.sql.Date;
 

import java.util.List;

/**
 *
 * @author Abdalla
 */
public class Orders implements Serializable {
    private Integer orderId;
    private Date orderDate;
    private Double total;
    private List<OrderBook> orderBookList;
    private Customer customerId;

    public Orders() {
    }

    public Orders( Date orderDate, Double total, List<OrderBook> orderBookList, Customer customerId) {
        this.orderDate = orderDate;
        this.total = total;
        this.orderBookList = orderBookList;
        this.customerId = customerId;
    }

    public Orders(Integer orderId, Date orderDate, Double total, List<OrderBook> orderBookList, Customer customerId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.total = total;
        this.orderBookList = orderBookList;
        this.customerId = customerId;
    }
    

    
    public Orders(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<OrderBook> getOrderBookList() {
        return orderBookList;
    }

    public void setOrderBookList(List<OrderBook> orderBookList) {
        this.orderBookList = orderBookList;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Orders[ orderId=" + orderId + " ]";
    }
    
}
