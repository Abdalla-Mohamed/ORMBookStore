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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Book generated by hbm2java
 */
@Entity
@Table(name="BOOK"
    ,schema="BOOKSTORE"
)
public class Book  implements java.io.Serializable {


     private Integer BIsbn;
     private String BName;
     private String BDescription;
     private String BQuote;
     private Integer BCount;
     private Double BPrice;
     private Integer BRating;
     private String BFrontImg;
     private String BBackImg;
     private String BHdr01Img;
     private String BHdr02Img;
     private Set<OrderBook> orderBooks = new HashSet<OrderBook>(0);
     private Set<Cart> carts = new HashSet<Cart>(0);
     private Set<Author> authors = new HashSet<Author>(0);
     private Set<Category> categories = new HashSet<Category>(0);
    static public final String uplodedImgFolderDestntion = "C:/Book_Shop/images";


    public Book() {
    }

	
    public Book(Integer BIsbn) {
        this.BIsbn = BIsbn;
    }
    public Book(Integer BIsbn, String BName, String BDescription, String BQuote, Integer BCount, Double BPrice, Integer BRating, String BFrontImg, String BBackImg, String BHdr01Img, String BHdr02Img, Set<OrderBook> orderBooks, Set<Cart> carts, Set<Author> authors, Set<Category> categories) {
       this.BIsbn = BIsbn;
       this.BName = BName;
       this.BDescription = BDescription;
       this.BQuote = BQuote;
       this.BCount = BCount;
       this.BPrice = BPrice;
       this.BRating = BRating;
       this.BFrontImg = BFrontImg;
       this.BBackImg = BBackImg;
       this.BHdr01Img = BHdr01Img;
       this.BHdr02Img = BHdr02Img;
       this.orderBooks = orderBooks;
       this.carts = carts;
       this.authors = authors;
       this.categories = categories;
    }

    
     public Book(String bName, String bDescription, String bQuote,Integer bCount, Double bPrice, Integer bRating) {
        this.BName = bName;
        this.BDescription = bDescription;
        this.BQuote = bQuote;
        this.BCount=bCount;
        this.BPrice = bPrice;
        this.BRating = bRating;
    }

    public Book(String bName, String bDescription, String bQuote, Integer bCount, Double bPrice, Integer bRating, String bFrontImg, String bBackImg, String bHdr01Img, String bHdr02Img, Set<Category> categoryList, Set<Author> authorList, Set<OrderBook> orderBookList, Set<Cart> cartList) {
     
       this.BName = bName;
       this.BDescription = bDescription;
       this.BQuote = bQuote;
       this.BCount = bCount;
       this.BPrice = bPrice;
       this.BRating = bRating;
       this.BFrontImg = bFrontImg;
       this.BBackImg = bBackImg;
       this.BHdr01Img = bHdr01Img;
       this.BHdr02Img = bHdr02Img;
       this.orderBooks = orderBookList;
       this.carts = cartList;
       this.authors = authorList;
       this.categories = categoryList;
    }
    
    public void setImages(String bFrontImg, String bBackImg, String bHdr01Img, String bHdr02Img) {
        this.BFrontImg = bFrontImg;
        this.BBackImg = bBackImg;
        this.BHdr01Img = bHdr01Img;
        this.BHdr02Img = bHdr02Img;

    }

    
    
    
     @Id
     @SequenceGenerator(name = "ORDER_BOOK_SEQ", sequenceName = "ORDER_BOOK_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ORDER_BOOK_SEQ")
     @Column(name="B_ISBN", unique=true, nullable=false, precision=22, scale=0)
    public Integer getBIsbn() {
        return this.BIsbn;
    }
    
    public void setBIsbn(Integer BIsbn) {
        this.BIsbn = BIsbn;
    }

    
    @Column(name="B_NAME", length=50)
    public String getBName() {
        return this.BName;
    }
    
    public void setBName(String BName) {
        this.BName = BName;
    }

    
    @Column(name="B_DESCRIPTION", length=50)
    public String getBDescription() {
        return this.BDescription;
    }
    
    public void setBDescription(String BDescription) {
        this.BDescription = BDescription;
    }

    
    @Column(name="B_QUOTE", length=50)
    public String getBQuote() {
        return this.BQuote;
    }
    
    public void setBQuote(String BQuote) {
        this.BQuote = BQuote;
    }

    
    @Column(name="B_COUNT", precision=22, scale=0)
    public Integer getBCount() {
        return this.BCount;
    }
    
    public void setBCount(Integer BCount) {
        this.BCount = BCount;
    }

    
    @Column(name="B_PRICE", precision=126, scale=0)
    public Double getBPrice() {
        return this.BPrice;
    }
    
    public void setBPrice(Double BPrice) {
        this.BPrice = BPrice;
    }

    
    @Column(name="B_RATING", precision=22, scale=0)
    public Integer getBRating() {
        return this.BRating;
    }
    
    public void setBRating(Integer BRating) {
        this.BRating = BRating;
    }

    
    @Column(name="B_FRONT_IMG", length=50)
    public String getBFrontImg() {
        return this.BFrontImg;
    }
    
    public String wrapPathBFrontImg() {
        return "/"+BIsbn+"/"+this.BFrontImg;
    }
    
    public void setBFrontImg(String BFrontImg) {
        System.out.println(BFrontImg);
        this.BFrontImg = BFrontImg;
    }

    
    @Column(name="B_BACK_IMG", length=50)
    public String getBBackImg() {
        return this.BBackImg;
    }
    
    public void setBBackImg(String BBackImg) {
        this.BBackImg = BBackImg;
    }

    
    @Column(name="B_HDR01_IMG", length=50)
    public String getBHdr01Img() {
        return this.BHdr01Img;
    }
    
    public void setBHdr01Img(String BHdr01Img) {
        this.BHdr01Img = BHdr01Img;
    }

    
    @Column(name="B_HDR02_IMG", length=50)
    public String getBHdr02Img() {
        return this.BHdr02Img;
    }
    
    public void setBHdr02Img(String BHdr02Img) {
        this.BHdr02Img = BHdr02Img;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="book")
    public Set<OrderBook> getOrderBooks() {
        return this.orderBooks;
    }
    
    public void setOrderBooks(Set<OrderBook> orderBooks) {
        this.orderBooks = orderBooks;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="book")
    public Set<Cart> getCarts() {
        return this.carts;
    }
    
    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="BOOK_AUTH", schema="BOOKSTORE", joinColumns = { 
        @JoinColumn(name="BOOK_ID", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="AUTHOR_ID", nullable=false, updatable=false) })
    public Set<Author> getAuthors() {
        return this.authors;
    }
    
    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="BOOK_CATEGORY", schema="BOOKSTORE", joinColumns = { 
        @JoinColumn(name="BOOK_ID", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="CATG_ID", nullable=false, updatable=false) })
    public Set<Category> getCategories() {
        return this.categories;
    }
    
    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }




}


