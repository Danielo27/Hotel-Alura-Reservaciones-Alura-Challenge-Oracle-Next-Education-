/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.hotel.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Daniel Quintero Henr
 */
public class bookingModel {
    private Integer id;
    private String firstDay;
    private String lastDay;
    private Integer value;
    private String wayPay;
    
    public bookingModel(String firstDay, String lastDay, Integer value, String wayPay){
        this.firstDay = firstDay;
        this.lastDay = lastDay;
        this.value = value;
        this.wayPay = wayPay;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstDay() {
        return firstDay;
    }

    public void setFirstDay(String firstDay) {
        this.firstDay = firstDay;
    }

    public String getLastDay() {
        return lastDay;
    }

    public void setLastDay(String lastDay) {
        this.lastDay = lastDay;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getWayPay() {
        return wayPay;
    }

    public void setWayPay(String wayPay) {
        this.wayPay = wayPay;
    }
    
    
    @Override
    public String toString(){
       return String.format(
           "ID de la Reserva: %d, Reservado desde: %s, hasta el dia: %s, con un costo de: %d",
              this.id ,this.firstDay, this.lastDay, this.value);
    }
}
