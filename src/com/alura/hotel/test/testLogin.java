/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.hotel.test;

/**
 *
 * @author Daniel Quintero Henr
 */
import com.alura.hotel.model.userModel;
import com.alura.hotel.dao.userDao;
import com.alura.hotel.factory.ConnectionFactory;
import java.sql.Connection;

public class testLogin {
    
     public static void main(String[] args) {
       ConnectionFactory con = new ConnectionFactory();
         
       userModel usuario = new userModel("admin","admin");
       userDao db = new userDao(con.reConnection());
       
       System.out.println(db.userExist(usuario));
       
       
    }
}
