/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets.admin;

import com.beans.Author;
import com.daos.Author_Dao;
import com.utilts.DbConnctor;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hend
 */
public class AuthorControllrer extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String name = request.getParameter("autherName");
            String data = request.getParameter("aboutAuther");
if(name.isEmpty()){

   response.sendRedirect("adminPanel/secured/authers.jsp");
}



else {
            Author auther = new Author();
            Author_Dao obj = new Author_Dao();

            //   System.out.println("name of authe : "+ name );
            auther.setAuthName(name);
            auther.setAuthAbout(data);

            boolean addauther = obj.add(auther);

            if (addauther) {

                System.out.println("Done");          

                response.sendRedirect("adminPanel/secured/authers.jsp");

            }
            
} 
//End else 

                //----------------------------------------------------------
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
