/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.hotel.factory;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Daniel Quintero Henr
 */
public class ConnectionFactory {
    
    private DataSource dataSource;
    
    public ConnectionFactory() {
        ComboPooledDataSource CPDS = new ComboPooledDataSource();
        CPDS.setJdbcUrl("jdbc:mysql://localhost/hotel_alura?useTimeZone=true&serverTimeZone=UTC");
        CPDS.setUser("alura");
        CPDS.setPassword("aluralatam");
        CPDS.setMaxPoolSize(10);
        
        this.dataSource = CPDS;
    }
    
    public Connection reConnection(){
        try{
           //System.out.println("Creando la Conexion");
           return this.dataSource.getConnection();
        }catch(SQLException e){
           throw new RuntimeException(e);
        }
    }
}
