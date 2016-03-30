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

public class Cart implements Serializable {


    private Integer cBCount;
    
    private Book book;
    
    private Customer customer;

    public Cart() {
    }


    public Cart(Integer bookID, Integer customerId) {
        book =new Book(bookID);
        customer = new Customer(customerId);
        cBCount=0;
        
        
    }

    public Cart(Integer bookID, Integer customerId,Integer cBCount) {
        book =new Book(bookID);
        customer = new Customer(customerId);
        this.cBCount=cBCount;
        
        
    }

    public Cart( Book book, Customer customer,Integer cBCount) {
        this.cBCount = cBCount;
        this.book = book;
        this.customer = customer;
    }
    
    public void addOnCount(int oldCount){
        cBCount+=oldCount;
        
                
    }

  
    

   public int getBookId(){
       return book.getBIsbn();
   }

   public int getCustomerId(){
       return customer.getCId();
   }

    public Integer getCBCount() {
        return cBCount;
    }

    public void setCBCount(Integer cBCount) {
        this.cBCount = cBCount;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

   

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cart)) {
            return false;
        }
        Cart other = (Cart) object;
        if (((this.customer == null && other.customer != null) || (this.customer != null && !this.customer.equals(other.customer)))&&((this.book == null && other.book != null) || (this.book != null && !this.book.equals(other.book)))) {
            return false;
        }
        return true;
    }

    
}
