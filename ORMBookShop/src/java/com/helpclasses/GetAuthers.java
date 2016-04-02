/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helpclasses;

import com.beans.Author;
import com.daos.Author_Dao;
import java.util.List;

/**
 *
 * @author Hend
 */
public class GetAuthers {

 //   List<Author> autherData;

    public GetAuthers() {
    }

    public List<Author> getAuthers(){
        List<Author> list =null;
        
           
        Author_Dao   obj=new Author_Dao();
        try {
            list =obj.readAll();
            for (Author  a :list ){
                System.out.println(" REs "+a.getAuthName());
            }
        } catch (Exception ex) {
        
        ex.printStackTrace();
        }
            
      return list;      
    }
      
}