package com.beans;
// Generated Mar 29, 2016 3:52:04 PM by Hibernate Tools 4.3.1



import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Customer generated by hbm2java
 */
@Entity
@Table(name="CUSTOMER"
    ,schema="BOOKSTORE"
    , uniqueConstraints = @UniqueConstraint(columnNames="C_EMAIL") 
)
public class Customer  implements java.io.Serializable {


     private Integer CId;
     private String CName;
     private String CEmail;
     private String CPassword;
     private String CJob;
     private String CAddress;
     private String CMobile;
     private Integer CCredit;
     private Set<Category> categories = new HashSet<Category>(0);
     private Set<Cart> carts = new HashSet<Cart>(0);
     private Set<Orders> orderses = new HashSet<Orders>(0);

    public Customer() {
    }

	
    public Customer(Integer CId) {
        this.CId = CId;
    }
    public Customer(Integer CId, String CName, String CEmail, String CPassword, String CJob, String CAddress, String CMobile, Integer CCredit, Set<Category> categories, Set<Cart> carts, Set<Orders> orderses) {
       this.CId = CId;
       this.CName = CName;
       this.CEmail = CEmail;
       this.CPassword = CPassword;
       this.CJob = CJob;
       this.CAddress = CAddress;
       this.CMobile = CMobile;
       this.CCredit = CCredit;
       this.categories = categories;
       this.carts = carts;
       this.orderses = orderses;
    }
   
     @Id 

    
    @Column(name="C_ID", unique=true, nullable=false, precision=22, scale=0)
    public Integer getCId() {
        return this.CId;
    }
    
    public void setCId(Integer CId) {
        this.CId = CId;
    }

    
    @Column(name="C_NAME", length=50)
    public String getCName() {
        return this.CName;
    }
    
    public void setCName(String CName) {
        this.CName = CName;
    }

    
    @Column(name="C_EMAIL", unique=true, length=50)
    public String getCEmail() {
        return this.CEmail;
    }
    
    public void setCEmail(String CEmail) {
        this.CEmail = CEmail;
    }

    
    @Column(name="C_PASSWORD", length=20)
    public String getCPassword() {
        return this.CPassword;
    }
    
    public void setCPassword(String CPassword) {
        this.CPassword = CPassword;
    }

    
    @Column(name="C_JOB", length=20)
    public String getCJob() {
        return this.CJob;
    }
    
    public void setCJob(String CJob) {
        this.CJob = CJob;
    }

    
    @Column(name="C_ADDRESS", length=30)
    public String getCAddress() {
        return this.CAddress;
    }
    
    public void setCAddress(String CAddress) {
        this.CAddress = CAddress;
    }

    
    @Column(name="C_MOBILE", length=20)
    public String getCMobile() {
        return this.CMobile;
    }
    
    public void setCMobile(String CMobile) {
        this.CMobile = CMobile;
    }

    
    @Column(name="C_CREDIT", precision=22, scale=0)
    public Integer getCCredit() {
        return this.CCredit;
    }
    
    public void setCCredit(Integer CCredit) {
        this.CCredit = CCredit;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="INTEREST", schema="BOOKSTORE", joinColumns = { 
        @JoinColumn(name="CUSTOMER_ID", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="CAT_ID", nullable=false, updatable=false) })
    public Set<Category> getCategories() {
        return this.categories;
    }
    
    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="customer")
    public Set<Cart> getCarts() {
        return this.carts;
    }
    
    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="customer")
    public Set<Orders> getOrderses() {
        return this.orderses;
    }
    
    public void setOrderses(Set<Orders> orderses) {
        this.orderses = orderses;
    }




}


