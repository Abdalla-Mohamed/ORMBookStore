package com.beans;
// Generated Mar 29, 2016 3:52:04 PM by Hibernate Tools 4.3.1



import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Author generated by hbm2java
 */
@Entity
@Table(name="AUTHOR"
    ,schema="BOOKSTORE"
)
public class Author  implements java.io.Serializable {


     private Integer authId;
     private String authName;
     private String authAbout;
     private String authImg;
     private Set<Book> books = new HashSet<Book>(0);

    public Author() {
    }

	
    public Author(Integer authId) {
        this.authId = authId;
    }
    public Author(Integer authId, String authName, String authAbout, String authImg, Set<Book> books) {
       this.authId = authId;
       this.authName = authName;
       this.authAbout = authAbout;
       this.authImg = authImg;
       this.books = books;
    }
   
     @Id 
    @SequenceGenerator(name = "AUTHOR_SEQ_TMP", sequenceName = "AUTHOR_SEQ_TMP")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "AUTHOR_SEQ_TMP")
    @Column(name="AUTH_ID", unique=true, nullable=false, precision=22, scale=0)
    public Integer getAuthId() {
        return this.authId;
    }
    
    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    
    @Column(name="AUTH_NAME", length=50)
    public String getAuthName() {
        return this.authName;
    }
    
    public void setAuthName(String authName) {
        this.authName = authName;
    }

    
    @Column(name="AUTH_ABOUT", length=100)
    public String getAuthAbout() {
        return this.authAbout;
    }
    
    public void setAuthAbout(String authAbout) {
        this.authAbout = authAbout;
    }

    
    @Column(name="AUTH_IMG", length=50)
    public String getAuthImg() {
        return this.authImg;
    }
    
    public void setAuthImg(String authImg) {
        this.authImg = authImg;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="BOOK_AUTH", schema="BOOKSTORE", joinColumns = { 
        @JoinColumn(name="AUTHOR_ID", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="BOOK_ID", nullable=false, updatable=false) })
    public Set<Book> getBooks() {
        return this.books;
    }
    
    public void setBooks(Set<Book> books) {
        this.books = books;
    }




}


