/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import java.io.Serializable;


/**
 *
 * @author Abdalla
 */

public class ChargingCard implements Serializable {
    private String cardNumber;
    private Integer cardAmount;
    private Character cardStatus;
    private Character cardPrinted;
    
    public static final char CHARGED = 'T';
    public static final char NOTCHARGED = 'F';
    
    public static final char PRINTED = 'T';
    public static final char NOTPRINTED = 'F';
    

    public ChargingCard() {
    }

    public ChargingCard(String cardNumber, Integer cardAmount, Character cardStatus) {
        this.cardNumber = cardNumber;
        this.cardAmount = cardAmount;
        this.cardStatus = cardStatus;
    }

    public ChargingCard(String cardNumber, Integer cardAmount, Character cardStatus, Character cardPrinted) {
        this.cardNumber = cardNumber;
        this.cardAmount = cardAmount;
        this.cardStatus = cardStatus;
        this.cardPrinted = cardPrinted;
    }
    
    
    public ChargingCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getCardAmount() {
        return cardAmount;
    }

    public void setCardAmount(Integer cardAmount) {
        this.cardAmount = cardAmount;
    }

    public Character getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(Character cardStatus) {
        this.cardStatus = cardStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cardNumber != null ? cardNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChargingCard)) {
            return false;
        }
        ChargingCard other = (ChargingCard) object;
        if ((this.cardNumber == null && other.cardNumber != null) || (this.cardNumber != null && !this.cardNumber.equals(other.cardNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.ChargingCard[ cardNumber=" + cardNumber + " ]";
    }
    
}
