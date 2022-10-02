/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.hotel.dao;

import com.alura.hotel.factory.ConnectionFactory;
import com.alura.hotel.model.userModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alura.hotel.model.userModel;

/**
 *
 * @author Daniel Quintero Henr
 */
public class userDao {
    private Connection con;
    
    public userDao(Connection con){
        this.con = con;
    }
    
    
    public int userExist(userModel user){
       int result = 0;
       try{
         String sql = "SELECT count(id) FROM login WHERE name = ? AND password = ? ";
         
         try(PreparedStatement statement = con.prepareStatement(sql)){    
             statement.setString(1,user.getName());
             statement.setString(2,user.getPassword());
             statement.execute();
             
             try(ResultSet resultSet = statement.getResultSet()){
                while(resultSet.next()){
                   result = resultSet.getInt(1);
                }
             }
             statement.close();
             con.close();
         }
         
       }catch(SQLException e){
            throw new RuntimeException(e);
       }
        return result;
 }
    
}
