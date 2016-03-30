/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.bean.*;
import com.daos.ChargingCard_Dao;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ElGazzar
 */
public class ChargingCardList {
    private Integer cardAmount;
    private Integer countAmount;

    public ChargingCardList() {
    }

    
    public ChargingCardList(Integer cardAmount, Integer countAmount) {
        this.cardAmount = cardAmount;
        this.countAmount = countAmount;
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
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cardLists;
    }
    
    
}
