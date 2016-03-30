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
public class Book implements Serializable {

    private Integer bIsbn;
    private String bName;
    private String bDescription;
    private String bQuote;
    private Integer bCount;
    private Double bPrice;
    private Integer bRating;
    private String bFrontImg;
    private String bBackImg;
    private String bHdr01Img;
    private String bHdr02Img;

    private List<Category> categoryList;
    private List<Author> authorList;
    private List<OrderBook> orderBookList;
    private List<Cart> cartList;
    static public final String uplodedImgFolderDestntion = "C:/Book_Shop/images/";


    public Book() {
    }

    public Book(String bName, String bDescription, String bQuote,Integer bCount, Double bPrice, Integer bRating) {
        this.bName = bName;
        this.bDescription = bDescription;
        this.bQuote = bQuote;
        this.bCount=bCount;
        this.bPrice = bPrice;
        this.bRating = bRating;
    }

    public Book(String bName, String bDescription, String bQuote, Integer bCount, Double bPrice, Integer bRating, String bFrontImg, String bBackImg, String bHdr01Img, String bHdr02Img, List<Category> categoryList, List<Author> authorList, List<OrderBook> orderBookList, List<Cart> cartList) {
        this.bName = bName;
        this.bDescription = bDescription;
        this.bQuote = bQuote;
        this.bCount = bCount;
        this.bPrice = bPrice;
        this.bRating = bRating;
        this.bFrontImg = bFrontImg;
        this.bBackImg = bBackImg;
        this.bHdr01Img = bHdr01Img;
        this.bHdr02Img = bHdr02Img;
        this.categoryList = categoryList;
        this.authorList = authorList;
        this.orderBookList = orderBookList;
        this.cartList = cartList;
    }

    public Book(Integer bIsbn, String bName, String bDescription, String bQuote, Integer bCount, Double bPrice, Integer bRating, String bFrontImg, String bBackImg, String bHdr01Img, String bHdr02Img, List<Category> categoryList, List<Author> authorList, List<OrderBook> orderBookList, List<Cart> cartList) {
        this.bIsbn = bIsbn;
        this.bName = bName;
        this.bDescription = bDescription;
        this.bQuote = bQuote;
        this.bCount = bCount;
        this.bPrice = bPrice;
        this.bRating = bRating;
        this.bFrontImg = bFrontImg;
        this.bBackImg = bBackImg;
        this.bHdr01Img = bHdr01Img;
        this.bHdr02Img = bHdr02Img;
        this.categoryList = categoryList;
        this.authorList = authorList;
        this.orderBookList = orderBookList;
        this.cartList = cartList;
    }

    public void setImages(String bFrontImg, String bBackImg, String bHdr01Img, String bHdr02Img) {
        this.bFrontImg = bFrontImg;
        this.bBackImg = bBackImg;
        this.bHdr01Img = bHdr01Img;
        this.bHdr02Img = bHdr02Img;

    }

    public Book(Integer bIsbn) {
        this.bIsbn = bIsbn;
    }

    public Integer getBIsbn() {
        return bIsbn;
    }

    public void setBIsbn(Integer bIsbn) {
        this.bIsbn = bIsbn;
    }

    public String getBName() {
        return bName;
    }

    public void setBName(String bName) {
        this.bName = bName;
    }

    public String getBDescription() {
        return bDescription;
    }

    public void setBDescription(String bDescription) {
        this.bDescription = bDescription;
    }

    public String getBQuote() {
        return bQuote;
    }

    public void setBQuote(String bQuote) {
        this.bQuote = bQuote;
    }

    public Integer getBCount() {
        return bCount;
    }

    public void setBCount(Integer bCount) {
        this.bCount = bCount;
    }

    public Double getBPrice() {
        return bPrice;
    }

    public void setBPrice(Double bPrice) {
        this.bPrice = bPrice;
    }

    public Integer getBRating() {
        return bRating;
    }

    public void setBRating(Integer bRating) {
        this.bRating = bRating;
    }

    public String getBFrontImg() {
        return bFrontImg;
    }

    public void setBFrontImg(String bFrontImg) {
        this.bFrontImg = bFrontImg;
    }

    public String getBBackImg() {
        return bBackImg;
    }

    public void setBBackImg(String bBackImg) {
        this.bBackImg = bBackImg;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public List<OrderBook> getOrderBookList() {
        return orderBookList;
    }

    public void setOrderBookList(List<OrderBook> orderBookList) {
        this.orderBookList = orderBookList;
    }

    public String getBHdr01Img() {
        return bHdr01Img;
    }

    public void setBHdr01Img(String bHdr01Img) {
        this.bHdr01Img = bHdr01Img;
    }

    public String getBHdr02Img() {
        return bHdr02Img;
    }

    public void setBHdr02Img(String bHdr02Img) {
        this.bHdr02Img = bHdr02Img;
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
        hash += (bIsbn != null ? bIsbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.bIsbn == null && other.bIsbn != null) || (this.bIsbn != null && !this.bIsbn.equals(other.bIsbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Book[ bIsbn=" + bIsbn + " ]";
    }

}
