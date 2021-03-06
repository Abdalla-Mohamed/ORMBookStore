/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utilts;

;
import java.sql.DriverManager;
import java.sql.SQLException;
import oracle.jdbc.OracleDriver;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Abdalla
 */


public class DbConnctor {

    static private AnnotationConfiguration configure;
    static private SessionFactory sessionFactory;
    static private Session session;
    
    private DbConnctor() {

    }

    static synchronized public Session opensession() throws SQLException {
        
        if(configure==null){
             configure = new AnnotationConfiguration().configure("hibernate.cfg.xml")
                    //                .setInterceptor(new InterceptorInsert())
                    .addPackage(" hyperwithannotations.entyties").configure();

          
        }
       if(sessionFactory==null ||sessionFactory.isClosed()){
          sessionFactory = configure.buildSessionFactory();
            System.out.println("configer done");
 
       }
          
        if (session == null || !session.isOpen()) {
                       System.out.println("open session");


            session = sessionFactory.getCurrentSession();

        }
        return session;

    }

    static synchronized public void closesession() throws SQLException {
        session.close();
    }
}
