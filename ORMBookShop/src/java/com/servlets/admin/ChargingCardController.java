/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets.admin;

import com.beans.ChargingCard;
import com.daos.ChargingCard_Dao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.RandomStringUtils;

/**
 *
 * @author ElGazzar
 */
public class ChargingCardController extends HttpServlet {

    private ChargingCard chargingCard;
    private ChargingCard_Dao chargingCard_Dao;
    
    public ChargingCardController() {
        super();
        // chargingCard_Dao = new ChargingCard_Dao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

List<ChargingCard> allCardNumber=new ArrayList();
        
        if(request.getParameter("cardValue")!=null || request.getParameter("cardCount")!=null){
        int amount = Integer.parseInt(request.getParameter("cardValue"));
        int cardCount = Integer.parseInt(request.getParameter("cardCount"));
        int counter = 0;
        
        while(counter < cardCount ){
            
            try {
                String result = RandomStringUtils.randomNumeric(15);
                
                chargingCard_Dao = new ChargingCard_Dao();
                chargingCard = new ChargingCard(result, amount, ChargingCard.NOTCHARGED, ChargingCard.NOTPRINTED);
                boolean addChargingCard = chargingCard_Dao.addChargingCard(chargingCard);
                
                if(addChargingCard == true){
                    counter++;
                }
                System.out.println(result + "  " + amount + "  " + ChargingCard.NOTCHARGED);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
        }
        }else{
            
             
        int values = Integer.parseInt(request.getParameter("selectCardValue"));
        int counts = Integer.parseInt(request.getParameter("selectCardCount"));
        
        int counters = counts;
        for(int i=0; i<counters; i++){
            try {
                chargingCard_Dao = new ChargingCard_Dao();
              allCardNumber  = chargingCard_Dao.getAllCardNumber(values);
                System.out.println("ehh"+allCardNumber);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        }
        
        HttpSession session=request.getSession(true);
                   
        session.setAttribute("charger",allCardNumber);
        response.sendRedirect("adminPanel/secured/chargeCard.jsp");
        
        

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
