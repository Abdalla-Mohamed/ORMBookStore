/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.daos.ChargingCard_Dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ElGazzar
 */
public class ChargingCardList {
    private Integer cardAmount;
    private Integer countAmount;
     private String cardNumber;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public ChargingCardList() {
    }

    
    public ChargingCardList(Integer cardAmount, Integer countAmount) {
        this.cardAmount = cardAmount;
        this.countAmount = countAmount;
    }

    public ChargingCardList(Integer cardAmount, Integer countAmount, String cardNumber) {
        this.cardAmount = cardAmount;
        this.countAmount = countAmount;
        this.cardNumber = cardNumber;
    }

    public Integer getCardAmount() {
        return cardAmount;
    }

    public void setCardAmount(Integer cardAmount) {
        this.cardAmount = cardAmount;
    }

    public Integer getCountAmount() {
        return countAmount;
    }

    public void setCountAmount(Integer countAmount) {
        this.countAmount = countAmount;
    }
    
    
    public List<ChargingCardList> getAmountList()
    {
        
        List<ChargingCardList> cardLists = null;
        try {
            ChargingCard_Dao card_Dao = new ChargingCard_Dao();
            
            cardLists = card_Dao.getAllChargingCardByAmount();
            
            for (ChargingCardList cardList : cardLists) {
//                ChargingCardList l = new ChargingCardList(cardList.getCardAmount(), cardList.getCountAmount());
//                cardLists.add(l);
                System.out.println(cardList.getCardAmount()+" dd "+cardList.getCountAmount());
            }
            return cardLists;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cardLists;
    }
            List<ChargingCard> cardLists = new ArrayList<>();

    public List<ChargingCard> getCardLists() {
        return cardLists;
    }

    public void setCardLists(List<ChargingCard> cardLists) {
        this.cardLists = cardLists;
    }

    public void fillNumberList(int x, int y)
    {
        
        try {
            ChargingCard_Dao card_Dao = new ChargingCard_Dao();
            
            cardLists = card_Dao.getAllCardNumber(x, y);
                
            for (ChargingCard cardList : cardLists) {
                System.out.println(cardList.getCardNumber());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
}
