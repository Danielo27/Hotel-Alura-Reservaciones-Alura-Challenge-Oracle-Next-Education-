/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.hotel.model;

/**
 *
 * @author Daniel Quintero Henr
 */
public class guestModel {
    private Integer id;
    private String name;
    private String surname;
    private String bornDate;
    private String nationality;
    private String phoneNumber;
    private Integer IdBooking;

    public guestModel(String name, String surname, String bornDate, String nacionality, String phoneNumber, Integer idBooking) {
         this.name = name;
         this.surname = surname;
         this.bornDate = bornDate;
         this.nationality = nacionality;
         this.phoneNumber = phoneNumber;
         this.IdBooking = idBooking;
    }

    public Integer getId(){
         return this.id;
    }
    
    public void setId(Integer id){
        this.id = id;
    }
    
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBornDate() {
        return bornDate;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getIdReserva() {
        return IdBooking;
    }

    public void setIdReserva(Integer Id) {
        this.IdBooking = Id;
    }

    @Override
    public String toString() {
       return String.format("ID: %d Para %s %s",
            this.IdBooking,this.name,this.surname);
    }
}
