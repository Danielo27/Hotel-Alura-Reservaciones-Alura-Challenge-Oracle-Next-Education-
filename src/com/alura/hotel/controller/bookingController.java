/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.hotel.controller;

import com.alura.hotel.dao.bookingDao;
import com.alura.hotel.factory.ConnectionFactory;
import com.alura.hotel.model.bookingModel;
import java.util.List;

/**
 *
 * @author Daniel Quintero Henr
 */
public class bookingController {
    private bookingDao BookingDao;
    
    public bookingController(){
      ConnectionFactory db = new ConnectionFactory();
      this.BookingDao = new bookingDao(db.reConnection());
    }
    
    public Integer setBooking(String firstDay, String lastDay, Integer value, String wayPay){
        bookingModel data = new bookingModel(firstDay, lastDay , value, wayPay);
        this.BookingDao.setBooking(data);
        return data.getId();
    }
    
    public void updateBooking(Integer id,String firstDay, String lastDay, Integer value, String wayPay){
       bookingModel data = new bookingModel(firstDay, lastDay, value, wayPay);
       data.setId(id);
       this.BookingDao.updateBooking(data);
    }
    
    public List<bookingModel> getBooking(){
        return this.BookingDao.getBooking();
    }
    
    public Integer getDeleteBooking(Integer id){
            return BookingDao.deleteBookingAndGuest(id);
    }
    
}
