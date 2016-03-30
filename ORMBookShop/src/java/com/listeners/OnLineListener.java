/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author Hosam
 */
public class OnLineListener implements ServletContextListener,HttpSessionListener {
   
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void sessionCreated(HttpSessionEvent se) {
       System.out.println("new session created");
       int num=(Integer) se.getSession().getServletContext().getAttribute("y");
       num++;
       
       se.getSession().getServletContext().setAttribute("y",num); 
       
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
      
       System.out.println(" session ended");
       int num=(Integer) se.getSession().getServletContext().getAttribute("y");
       num--;
       
       se.getSession().getServletContext().setAttribute("y",num); 
      
    }

    
}
