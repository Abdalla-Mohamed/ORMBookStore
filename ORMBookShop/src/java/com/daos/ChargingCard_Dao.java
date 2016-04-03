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
    
    public List<ChargingCard> getAllCardNumber(Integer amount) throws SQLException {
        
        List<ChargingCard> chargingCardList = new ArrayList<>();
        try {
            session = DbConnctor.opensession();
            session.beginTransaction();
            Query query = session.createQuery("select c.cardNumber from ChargingCard c where c.cardStatus =:cardStatus and c.cardAmount=:cardAmount")
                        .setParameter("cardStatus", 'F')
                        .setParameter("cardAmount", amount);
            
                  chargingCardList=query.list();
            System.out.println("getAllCardNumber"+chargingCardList);
                  
                  session.getTransaction().commit();
                  return chargingCardList;
        //    resultSet = statement.executeQuery("UPDATE CHARGING_CARD SET CARD_PRINTED = 'T'");
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
                    session.beginTransaction();
                    Query query = session.createQuery("select c.cardAmount from ChargingCard c where c.cardNumber =:cardNumber")
                        .setParameter("cardNumber", num);
                    session.getTransaction().commit();

                    return i;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return i;
          
    }
    
    public boolean updateCustomerCredit (int CCredit) throws SQLException{
                Customer customer = new Customer();
        boolean updated;              
        try {
            
            session = DbConnctor.opensession();
            session.getTransaction().begin();
//            session.merge(CCredit);
            int id = customer.getCId();
            Query query = session.createQuery("update Customer c set c.CCredit = :CCredit where c.cId =:id")
                    .setParameter("CCredit", CCredit)
                    .setParameter("cId", id);
            query.executeUpdate();
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
            ex.printStackTrace();
            updated=false;
        }
        return updated;
    }
    
}

