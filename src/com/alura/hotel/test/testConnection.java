/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.hotel.test;

import com.alura.hotel.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Daniel Quintero Henr
 */
public class testConnection {
    
    public static void main(String[] args) throws SQLException {
          ConnectionFactory factory = new ConnectionFactory();
        try (Connection con = factory.reConnection()) {
            System.out.println("Cerrando La conexion");
            con.close();
        } 
    }
    
}
