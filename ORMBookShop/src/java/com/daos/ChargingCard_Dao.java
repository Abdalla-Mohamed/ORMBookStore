/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daos; import org.hibernate.Session;

import com.beans.ChargingCard;
import com.beans.ChargingCardList;
import com.beans.Customer;
import com.utilts.DbConnctor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ElGazzar
 */
public class ChargingCard_Dao {
    Session session = null;
    PreparedStatement pstatement = null;
    Statement statement = null;
    ResultSet resultSet = null;
    
    
    public boolean addChargingCard(ChargingCard chargingCard) throws SQLException
    {
        try {                
            session = DbConnctor.opensession();
            String sql= "INSERT INTO CHARGING_CARD(CARD_NUMBER, CARD_AMOUNT, CARD_STATUS)"
                        + "VALUES(?,?,?)";
//            pstatement = session.prepareStatement(sql);
                
            pstatement.setString(1, chargingCard.getCardNumber());
            pstatement.setInt(2, chargingCard.getCardAmount());
            pstatement.setString(3,chargingCard.getCardStatus()+"");
               
                
            pstatement.executeUpdate();
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        finally {

                DbConnctor.closesession();
            }
        return true;
    }
    
    public boolean deleteChargingCard(ChargingCard chargingCard) throws SQLException {
        try {
            session = DbConnctor.opensession();
//            statement = session.createStatement();
            String query = "DELETE FROM CHARGING_CARD WHERE CARD_NUMBER='"+chargingCard.getCardNumber()+"'";
              
            statement.executeUpdate(query);
                
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            
        }
        finally {

                DbConnctor.closesession();
            }
        return true;
    }
    
    public List<ChargingCard> getAllChargingCard() throws SQLException {
        
        List<ChargingCard> chargingCardList = new ArrayList<ChargingCard>();
        try {
            session = DbConnctor.opensession();
//            statement = session.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM CHARGING_CARD");
            while (resultSet.next()) {
                ChargingCard card = new ChargingCard();
                
                card.setCardNumber(resultSet.getString("CARD_NUMBER"));
                card.setCardAmount(resultSet.getInt("CARD_AMOUNT"));
                card.setCardStatus(resultSet.getString("CARD_STATUS").charAt(0));
                
                
                chargingCardList.add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DbConnctor.closesession();
        }

        return chargingCardList;
    }
    
    public List<ChargingCard> getAllCardNumber() throws SQLException {
        
        List<ChargingCard> chargingCardList = new ArrayList<ChargingCard>();
        try {
            session = DbConnctor.opensession();
//            statement = session.createStatement();
            resultSet = statement.executeQuery("SELECT CARD_NUMBER FROM CHARGING_CARD");
            while (resultSet.next()) {
                ChargingCard card = new ChargingCard();
                
                card.setCardNumber(resultSet.getString("CARD_NUMBER"));
                               
                chargingCardList.add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DbConnctor.closesession();
        }

        return chargingCardList;
    }
    
    public List<ChargingCardList> getAllChargingCardByAmount() throws SQLException {
        
        List<ChargingCardList> chargingCardList = new ArrayList<ChargingCardList>();
        try {
            session = DbConnctor.opensession();
//            statement = session.createStatement();
            resultSet = statement.executeQuery("SELECT CARD_AMOUNT, COUNT(CARD_AMOUNT) FROM CHARGING_CARD WHERE CARD_STATUS='F' GROUP BY CARD_AMOUNT ORDER BY CARD_AMOUNT");
            while (resultSet.next()) {
                ChargingCardList card = new ChargingCardList();
                
                card.setCardAmount(resultSet.getInt("CARD_AMOUNT")); 
            card.setCountAmount(resultSet.getInt(2));
                
                chargingCardList.add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DbConnctor.closesession();
        }

        return chargingCardList;
    }
    
    public List<ChargingCard> getAllCardNumber(int amount) throws SQLException {
        
        List<ChargingCard> chargingCardList = new ArrayList<ChargingCard>();
        try {
            session = DbConnctor.opensession();
//            statement = session.createStatement();
            resultSet = statement.executeQuery("SELECT CARD_NUMBER FROM CHARGING_CARD WHERE CARD_PRINTED = 'F' AND CARD_AMOUNT = '"+amount+"'");
            while (resultSet.next()) {
                ChargingCard card = new ChargingCard();
                
                card.setCardNumber(resultSet.getString("CARD_NUMBER"));
                               
                chargingCardList.add(card);
            }
            
        //    resultSet = statement.executeQuery("UPDATE CHARGING_CARD SET CARD_PRINTED = 'T'");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DbConnctor.closesession();
        }

        return chargingCardList;
    }
    
    public int charge(String num){
        int i = 0;
        try {
            
                    session = DbConnctor.opensession();
//                    statement = session.createStatement();
                    
                    resultSet = statement.executeQuery("select CARD_AMOUNT from  CHARGING_CARD where CARD_NUMBER = '"+num+"'");
      
                    
                     while (resultSet.next()) { 
                         i = resultSet.getInt("CARD_AMOUNT");
                     }
                    return i;
        } catch (SQLException ex) {
            Logger.getLogger(ChargingCard_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
//        resultSet = statement.executeQuery("SELECT C_CREDIT FROM CUSTOMER WHERE C_ID = '"+c.getCId()+"'");

        try {
            while (resultSet.next()) {
                try {
                    int cridet = resultSet.getInt("C_CREDIT");
                } catch (SQLException ex) {
                    Logger.getLogger(ChargingCard_Dao.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChargingCard_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
//            statement = session.createStatement();
//            resultSet = statement.executeQuery("UPDATE CUSTOMER SET C_CREDIT WHERE C_ID = '"+c.getCId()+"'");

//            while (resultSet.next()) {                
//                int i = Integer.parseInt(resultSet.getString("C_CREDIT"));
//                               
//            }
        return i;
          
    }
    
    public boolean update (Customer c) throws SQLException{
                
        boolean updated;              
        try {
            
            session = DbConnctor.opensession();
//            statement = session.createStatement();
            resultSet = statement.executeQuery("SELECT C_CREDIT FROM CUSTOMER WHERE C_ID = '"+c.getCId()+"'");

            while (resultSet.next()) {                
                int i = resultSet.getInt("C_CREDIT");
                               
            }
            
            
//            statement = session.createStatement();
            resultSet = statement.executeQuery("UPDATE CUSTOMER SET C_CREDIT WHERE C_ID = '"+c.getCId()+"'");

            while (resultSet.next()) {                
                int i = Integer.parseInt(resultSet.getString("C_CREDIT"));
                               
            }
            
            updated=true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Customer_Dao.class.getName()).log(Level.SEVERE, null, ex);
            updated=false;
        }
        return updated;
    }
    
}

