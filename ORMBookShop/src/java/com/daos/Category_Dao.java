/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daos;

import org.hibernate.Session;

import com.beans.Category;
import com.utilts.DbConnctor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Administrator
 */
public class Category_Dao {

   
    public static Session session;
    public static Transaction transcation;

    //  private static final String HQL_ADD = "";
    private static final String HQL_UPDATE = "update Category set catName=:name where catId=:id";
    private static final String HQL_DELETE = "delete Category where catId=:catid";
    private static final String HQL_READ_BYNAME = "from Category where catName=:catname";
    private static final String HQL_READ_ALL = "from Category";

    public void addCategory(Category categoryObj) throws SQLException {
        session = DbConnctor.opensession();
        transcation = session.beginTransaction();

        session.persist(categoryObj);
        session.getTransaction().commit();
        session.close();
    }

    public void updateCategory(int cID, String cName) throws SQLException {
        session = DbConnctor.opensession();
        session.beginTransaction();
        Query query = session.createQuery(HQL_UPDATE);
        Category cat = null;

        query.setParameter("name", cName);
        query.setParameter("id", cID);

        int result = query.executeUpdate();
        System.out.println(result + " records updated");

        session.getTransaction().commit();
    }

    public void deleteCategory(int catID) throws SQLException {
        session = DbConnctor.opensession();
        session.beginTransaction();
        Query query = session.createQuery(HQL_DELETE);

        query.setParameter("catid", catID);
        int result = query.executeUpdate();
        System.out.println(result + " records deleted");

        session.getTransaction().commit();
    }

    public List<Category> readCategory() throws SQLException {
        
        session = DbConnctor.opensession();
        session.beginTransaction();
        Query query = session.createQuery(HQL_READ_ALL);
        List results = query.list();

        session.getTransaction().commit();
        return results;
    }
}
