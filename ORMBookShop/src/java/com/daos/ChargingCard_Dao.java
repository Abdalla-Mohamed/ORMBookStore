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
    
    public List<ChargingCard> getAllCardNumber(int amount, int count) throws SQLException {
        
        List<ChargingCard> chargingCardList = new ArrayList<>();
        try {
            session = DbConnctor.opensession();
            session.beginTransaction();
            Query query = session.createQuery("select c from ChargingCard c where c.cardStatus =:cardStatus and c.cardAmount=:cardAmount")
                        .setParameter("cardStatus", 'F')
                        .setParameter("cardAmount", amount)
                        .setMaxResults(count);
            
                  chargingCardList=query.list();
            System.out.println("getAllCardNumber"+chargingCardList);
                  
                  session.getTransaction().commit();
                  return chargingCardList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chargingCardList;
    }
    
    public List<ChargingCard> getAllCardNumberCharged() throws SQLException
    {
        List<ChargingCard> chargingCardList = new ArrayList<>();
        try {
            session = DbConnctor.opensession();
            session.beginTransaction();
            Query query = session.createQuery("select c.cardNumber from ChargingCard c where c.cardPrinted =:cardPrinted")
                        .setParameter("cardPrinted", 'F');            
                  chargingCardList=query.list();
            System.out.println("charged "+chargingCardList);
                  
                  session.getTransaction().commit();
                  return chargingCardList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chargingCardList;
    }
    public Object charge(String cardNumber){
      Object result=null;
        try {
               
                    session = DbConnctor.opensession();
                    session.beginTransaction();
                    Query query = session.createQuery("select c.cardAmount from ChargingCard c where c.cardNumber =:cardNumber and c.cardStatus =:cardStatus")
                        .setParameter("cardNumber",cardNumber)
                        .setParameter("cardStatus", 'F');
                    
                    result = query.uniqueResult();
                    session.getTransaction().commit();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
          
    }
    
    public boolean updateCardStatus(String cardNumber) throws SQLException
    {
        boolean updated=false;
        
        session = DbConnctor.opensession();
        session.getTransaction().begin();
        Query query = session.createQuery("update ChargingCard c set c.cardStatus = :cardStatus where c.cardNumber =:cardNumber")
                    .setParameter("cardStatus", 'T')
                    .setParameter("cardNumber", cardNumber);
            query.executeUpdate();
        session.getTransaction().commit();

        return updated;
    }
    public List<ChargingCard> updateCardPrinted(List<ChargingCard> cardNumber) throws SQLException
    {
        List<ChargingCard> list = new ArrayList<>();
        session = DbConnctor.opensession();
        session.getTransaction().begin();
        Query query = session.createQuery("update ChargingCard c set c.cardPrinted = :cardPrinted where c.cardNumber =:cardNumber")
                    .setParameter("cardPrinted", 'T')
                    .setParameter("cardNumber", cardNumber);
            query.executeUpdate();
        list = query.list();
        session.getTransaction().commit();
        
        return list;
    }
    
}

