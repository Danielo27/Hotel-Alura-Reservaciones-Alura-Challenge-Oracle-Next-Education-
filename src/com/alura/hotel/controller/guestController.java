/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.hotel.controller;

import com.alura.hotel.dao.guestDao;
import com.alura.hotel.factory.ConnectionFactory;
import com.alura.hotel.model.guestModel;
import java.util.List;

/**
 *
 * @author Daniel Quintero Henr
 */
public class guestController {
    private guestDao GuestDao;
    
    public guestController(){
        ConnectionFactory db = new ConnectionFactory();
        this.GuestDao = new guestDao(db.reConnection());
    }
    
    public Integer setGuest(String name, String surname, String bornDate, String nacionality, String phoneNumber, Integer idBooking){
        guestModel data = new guestModel(name, surname, bornDate, nacionality, phoneNumber, idBooking);
        Integer response = this.GuestDao.setGuest(data);
        return response;
    }
    
    public void updateGuest(Integer id ,String name, String surname, String bornDate, String nacionality, String phoneNumber, Integer idBooking){
        guestModel data =  new guestModel(name, surname, bornDate, nacionality, phoneNumber, idBooking);
        data.setId(id);
        this.GuestDao.upadteGuest(data);
    }
    
    public List<guestModel> getGuest(){
        return this.GuestDao.getGuest();
    }
    
}
