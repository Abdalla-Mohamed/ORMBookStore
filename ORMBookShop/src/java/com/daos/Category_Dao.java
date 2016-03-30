/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daos; import org.hibernate.Session;

import com.beans.Category;
import com.utilts.DbConnctor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class Category_Dao {
    private static final String SQL_READ = "SELECT * FROM CATEGORY";
    private static final String SQL_INSERT = "INSERT INTO CATEGORY(CAT_ID,CAT_NAME)"
            + "VALUES(CATEGORY_SEQ_TMP.NEXTVAL,?)";
    private static final String SQL_UPDATE = "UPDATE CATEGORY SET CAT_NAME=? WHERE CAT_ID=?";
    private static final String SQL_DELETE = "DELETE FROM CATEGORY WHERE CAT_ID=?";

    Session session = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    public Category_Dao() {

    }

    public boolean add(Category categoryObj) throws SQLException {
        try {

            session = DbConnctor.opensession();
//            statement = session.prepareStatement(SQL_INSERT);
           //statement.setInt(1, categoryObj .getCatId());
            statement.setString(1, categoryObj.getCatName());
//            session.commit();
            if (statement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnctor.closesession();
        }
        return false;
    }

    public boolean update(Category categoryObj) throws SQLException {

        try {
            session = DbConnctor.opensession();
//            statement = session.prepareStatement(SQL_UPDATE);
            statement.setString(1, categoryObj.getCatName());
            statement.setInt(2, categoryObj.getCatId());
            if (statement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnctor.closesession();
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
        } finally {
            DbConnctor.closesession();
        }
        return false;
    }

    public List<Category> readAll() throws SQLException {
        ArrayList<Category> catgList = new ArrayList();
        try {
            session = DbConnctor.opensession();
            Category category = null;
//            statement = session.prepareStatement(SQL_READ);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                category = new Category();
                category.setCatId(resultSet.getInt(1));
                category.setCatName(resultSet.getString(2));
                catgList.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnctor.closesession();
        }
        return catgList;
    }


}
