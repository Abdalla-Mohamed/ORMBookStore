/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author Hosam
 */
public class CounterListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
      int x=0;
        sce.getServletContext().setAttribute("x",0);
        sce.getServletContext().setAttribute("y",0);
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
       int x=0;
        sce.getServletContext().setAttribute("x",0);
        
       
    }
}
