/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daos;

import org.hibernate.Session;

import com.beans.Author;
import com.utilts.DbConnctor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author Administrator
 */
public class Author_Dao {

    private static final String HQL_READ = " FROM Author";
    private static final String SQL_INSERT = "INSERT INTO AUTHOR(AUTH_ID,AUTH_NAME,AUTH_ABOUT,AUTH_IMG)"
            + "VALUES(AUTHOR_SEQ_TMP.NEXTVAL,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE AUTHOR SET AUTH_NAME=? WHERE AUTH_ID=?";
    private static final String SQL_DELETE = "DELETE FROM BOOK WHERE AUTH_ID=?";

    Session session = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    public Author_Dao() {

    }

    public boolean add(Author authorObj)  {
        try {
            try {
                session = DbConnctor.opensession();
            } catch (SQLException ex) {
                Logger.getLogger(Author_Dao.class.getName()).log(Level.SEVERE, null, ex);
            }
            session.beginTransaction();
            session.saveOrUpdate(authorObj);
            session.getTransaction().commit();
            return true;
            
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
    
    }

    public boolean update(Author authorObj) throws SQLException {

        try {
            session = DbConnctor.opensession();
//            statement = session.prepareStatement(SQL_UPDATE);
            statement.setString(1, authorObj.getAuthName());
            statement.setInt(2, authorObj.getAuthId());
            if (statement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return false;
    }

    public boolean delete(int authorID) throws SQLException {

        try {
            session = DbConnctor.opensession();
//            statement = session.prepareStatement(SQL_DELETE);
            statement.setInt(1, authorID);
            if (statement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return false;
    }
    
    public List<Author> readAll() throws SQLException {
       
 List<Author> authorList = null;
        session = DbConnctor.opensession();
       session.beginTransaction();
        Query query = session.createQuery(HQL_READ);
        authorList = query.list();
       session.getTransaction().commit();
        return authorList;
        
    }
}


