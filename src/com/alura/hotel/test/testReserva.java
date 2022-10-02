/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.hotel.test;

import com.alura.hotel.controller.bookingController;
import com.alura.hotel.model.bookingModel;

/**
 *
 * @author Daniel Quintero Henr
 */
public class testReserva {
    
    public static void main(String[] args) {
        bookingController booking = new bookingController();
        booking.setBooking("23/03/2022","30/03/2022", 12000, "Targeta Debito");    
    }
}
