/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daos; 

import org.hibernate.Session;

import com.beans.ChargingCard;
import com.beans.ChargingCardList;
import com.beans.Customer;
import com.utilts.DbConnctor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;

/**
 *
 * @author ElGazzar
 */
public class ChargingCard_Dao {
    Session session = null;
    
    public boolean addChargingCard(ChargingCard chargingCard) throws SQLException
    {
        try {                
            session = DbConnctor.opensession();
            session.getTransaction().begin();
            session.persist(chargingCard);
            session.getTransaction().commit();
             
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        
        return true;
    }
    
    public boolean deleteChargingCard(String chargingNumber) throws SQLException {
        try {
            session = DbConnctor.opensession();
            session.getTransaction().begin();
            session.delete(new ChargingCard(chargingNumber));
            session.getTransaction().commit();
               
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            
        }
       
        return true;
    }
    
    public List<ChargingCard> getAllChargingCard() throws SQLException {
        
        List<ChargingCard> chargingCardList = new ArrayList<>();
        try {
            session = DbConnctor.opensession();
            Query query = session.createQuery("from ChargingCard");
            chargingCardList= query.list();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chargingCardList;
    }
    
    public List<ChargingCard> getAllCardNumber() throws SQLException {
        
        List<ChargingCard> chargingCardList = new ArrayList<ChargingCard>();
        try {
            session = DbConnctor.opensession();
            session.beginTransaction();
            Query query = session.createQuery("select c.cardNumber from ChargingCard c");
            chargingCardList= query.list();

            session.getTransaction().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return chargingCardList;
    }
    
    public List<ChargingCardList> getAllChargingCardByAmount() throws SQLException {
        List<ChargingCardList> cardLists = new ArrayList<>();
        
        try {
            
            session = DbConnctor.opensession();
            session.beginTransaction();
            Query query = session.createQuery("select c.cardAmount, count(c.cardAmount) from ChargingCard c where c.cardStatus =:cardStatus group by c.cardAmount order by c.cardAmount")
                         .setParameter("cardStatus", 'F');
            
                  List<Object[]> obj=query.list();
                  for (Object[] line : obj) {
                      ChargingCardList c = new ChargingCardList(Integer.parseInt(line[0]+""), Integer.parseInt(line[1]+""));
                      cardLists.add(c);
                    System.out.println("Card Amount is : " + line[0] + " is " + line[1]);
                }
                  session.getTransaction().commit();
                  return cardLists;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cardLists;
    }
    
    public List<ChargingCard> getAllCardNumber(int amount) throws SQLException {
        
        List<ChargingCard> chargingCardList = new ArrayList<>();
        try {
            session = DbConnctor.opensession();
            session.beginTransaction();
            Query query = session.createQuery("select c.cardNumber from ChargingCard c where c.cardPrinted =:cardPrinted and c.cardAmount=:cardAmount")
                        .setParameter("cardPrinted", 'F')
                        .setParameter("cardAmount", amount);
            
                  chargingCardList=query.list();
                  
                  session.getTransaction().commit();
            System.out.println("fffffffffff"+chargingCardList);
        //    resultSet = statement.executeQuery("UPDATE CHARGING_CARD SET CARD_PRINTED = 'T'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chargingCardList;
    }
    
    public int charge(String num){
        int i = 0;
        try {
            
                    session = DbConnctor.opensession();
                    Query query = session.createQuery("select c.cardAmount from ChargingCard c where c.cardNumber =:cardNumber")
                        .setParameter("cardNumber", num);
//                    statement = session.createStatement();
                    
//                    resultSet = statement.executeQuery("select CARD_AMOUNT from  CHARGING_CARD where CARD_NUMBER = '"+num+"'");
//      
//                    
//                     while (resultSet.next()) { 
//                         i = resultSet.getInt("CARD_AMOUNT");
//                     }
                    return i;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
//        resultSet = statement.executeQuery("SELECT C_CREDIT FROM CUSTOMER WHERE C_ID = '"+c.getCId()+"'");

//        try {
//            while (resultSet.next()) {
//                try {
//                    int cridet = resultSet.getInt("C_CREDIT");
//                } catch (SQLException ex) {
//                    Logger.getLogger(ChargingCard_Dao.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ChargingCard_Dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
            
            
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
            session = DbConnctor.opensession();
            session.getTransaction().begin();
            session.merge(c);
            session.getTransaction().commit();
//            statement = session.createStatement();
//            resultSet = statement.executeQuery("SELECT C_CREDIT FROM CUSTOMER WHERE C_ID = '"+c.getCId()+"'");
//
//            while (resultSet.next()) {                
//                int i = resultSet.getInt("C_CREDIT");
//                               
//            }
            
            
//            statement = session.createStatement();
//            resultSet = statement.executeQuery("UPDATE CUSTOMER SET C_CREDIT WHERE C_ID = '"+c.getCId()+"'");
//
//            while (resultSet.next()) {                
//                int i = Integer.parseInt(resultSet.getString("C_CREDIT"));
//                               
//            }
            
            updated=true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Customer_Dao.class.getName()).log(Level.SEVERE, null, ex);
            updated=false;
        }
        return updated;
    }
    
}

