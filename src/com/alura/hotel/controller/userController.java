/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.hotel.controller;

import com.alura.hotel.dao.userDao;
import com.alura.hotel.factory.ConnectionFactory;
import com.alura.hotel.model.userModel;

/**
 *
 * @author Daniel Quintero Henr
 */
public class userController {
    
    private userDao UserDao;
    
    public userController(){
        ConnectionFactory db = new ConnectionFactory();
        this.UserDao = new userDao(db.reConnection());
    }
    
    public int login(String name, String password){
        userModel usuario = new userModel(name,password);
        return this.UserDao.userExist(usuario);
    }
    
    
}
