/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import java.io.Serializable;

import java.util.List;
/////test 
//Test First  bull 2 
/**
 *
 * @author Abdalla
 */
public class Author implements Serializable {
    private Integer authId;
    private String authName;
    private String authAbout;
    private String authImg;
    private List<Book> bookList;

    public Author() {
    }

    public Author( String authName, String authAbout, String authImg, List<Book> bookList) {
        this.authId = authId;
        this.authName = authName;
        this.authAbout = authAbout;
        this.authImg = authImg;
        this.bookList = bookList;
    }

    public Author(Integer authId, String authName, String authAbout, String authImg, List<Book> bookList) {
        this.authId = authId;
        this.authName = authName;
        this.authAbout = authAbout;
        this.authImg = authImg;
        this.bookList = bookList;
    }

    
    
    public Author(Integer authId) {
        this.authId = authId;
    }

    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getAuthAbout() {
        return authAbout;
    }

    public void setAuthAbout(String authAbout) {
        this.authAbout = authAbout;
    }

    public String getAuthImg() {
        return authImg;
    }

    public void setAuthImg(String authImg) {
        this.authImg = authImg;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (authId != null ? authId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Author)) {
            return false;
        }
        Author other = (Author) object;
        if ((this.authId == null && other.authId != null) || (this.authId != null && !this.authId.equals(other.authId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Author[ authId=" + authId + " ]";
    }
    //hello
}
