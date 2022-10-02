/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.hotel.test;

import com.alura.hotel.controller.bookingController;
import com.alura.hotel.model.bookingModel;
import java.util.List;
import java.awt.Container;

/**
 *
 * @author Daniel Quintero Henr
 */
public class testBusqueda {
    public static void main(String[] args) {
        bookingController booking = new bookingController();
        
        List<bookingModel> bookings = booking.getBooking();
        
        bookings.forEach(book -> {
           System.out.println("ID = "+book.getId()+" PRIMER DIA= "+book.getFirstDay()+" ULTIMO DIA="+book.getLastDay());
        });
        
    }
}
