package com.beans;
// Generated Mar 29, 2016 3:52:04 PM by Hibernate Tools 4.3.1



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ChargingCard generated by hbm2java
 */
@Entity
@Table(name="CHARGING_CARD"
    ,schema="BOOKSTORE"
)
public class ChargingCard  implements java.io.Serializable {


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

	
    public ChargingCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public ChargingCard(String cardNumber, Integer cardAmount, Character cardStatus, Character cardPrinted) {
       this.cardNumber = cardNumber;
       this.cardAmount = cardAmount;
       this.cardStatus = cardStatus;
       this.cardPrinted = cardPrinted;
    }
   
     @Id 

    
    @Column(name="CARD_NUMBER", unique=true, nullable=false, length=20)
    public String getCardNumber() {
        return this.cardNumber;
    }
    
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    
    @Column(name="CARD_AMOUNT", precision=22, scale=0)
    public Integer getCardAmount() {
        return this.cardAmount;
    }
    
    public void setCardAmount(Integer cardAmount) {
        this.cardAmount = cardAmount;
    }

    
    @Column(name="CARD_STATUS", length=1)
    public Character getCardStatus() {
        return this.cardStatus;
    }
    
    public void setCardStatus(Character cardStatus) {
        this.cardStatus = cardStatus;
    }

    
    @Column(name="CARD_PRINTED", length=1)
    public Character getCardPrinted() {
        return this.cardPrinted;
    }
    
    public void setCardPrinted(Character cardPrinted) {
        this.cardPrinted = cardPrinted;
    }




}


