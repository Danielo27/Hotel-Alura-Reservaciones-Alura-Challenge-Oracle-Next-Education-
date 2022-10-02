/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.hotel.dao;

import com.alura.hotel.model.bookingModel;
import com.alura.hotel.model.guestModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Quintero Henr
 */
public class guestDao {
    final private Connection con;
    
    public guestDao(Connection con){
       this.con = con;
    }
    
    public Integer setGuest(guestModel guest){
       
        String sql =  "INSERT INTO huspedes(nombre,apellido,fechaDeNacimiento,nacionalidad,telefono,idReserva) VALUES (?,?,?,?,?,?)";
        try(PreparedStatement statement = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1,guest.getName());
            statement.setString(2,guest.getSurname());
            statement.setString(3,guest.getBornDate());
            statement.setString(4,guest.getNationality());
            statement.setString(5,guest.getPhoneNumber());
            statement.setInt(6,guest.getIdReserva());
            
            statement.execute();
            
            try(ResultSet resultSet = statement.getGeneratedKeys()){
                while(resultSet.next()){
                    guest.setId(resultSet.getInt(1));
                    JOptionPane.showMessageDialog(null, String.format("Reserva Agendada Con Exito %s",guest));
                }
            }
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null,String.format("Ha ocurrido un error %s", e));
           throw new RuntimeException(e);
        }
        return guest.getId();
    }
    
    public Integer upadteGuest(guestModel guest){
      Integer updateCount;
      String sql = "UPDATE huspedes SET nombre = ?, apellido = ?, fechaDeNacimiento = ?, nacionalidad = ?, telefono = ? WHERE huspedes.id = ?";
      try(PreparedStatement statement = con.prepareStatement(sql)){
         statement.setString(1, guest.getName());
         statement.setString(2, guest.getSurname());
         statement.setString(3, guest.getBornDate());
         statement.setString(4,guest.getNationality());
         statement.setString(5, guest.getPhoneNumber());
         statement.setInt(6,guest.getId());
         
         statement.execute();
         
         updateCount = statement.getUpdateCount();
         if(updateCount > 0){
          JOptionPane.showMessageDialog(null, String.format("Reserva actualizada exitosamente", guest));
         }
         
      }catch(SQLException e){
          JOptionPane.showMessageDialog(null, String.format("Error al Actualizar la reserva", guest));
          throw new RuntimeException(e);
      }
        return updateCount;
    }
    
    public List<guestModel> getGuest(){
        List<guestModel> response = new ArrayList<>();
        
        String sql = "SELECT H.ID,H.NOMBRE,H.APELLIDO,H.FECHADENACIMIENTO,H.NACIONALIDAD,H.TELEFONO,R.ID FROM huspedes H INNER JOIN reservas R ON H.IDRESERVA = R.ID";
        try(PreparedStatement statement = con.prepareStatement(sql)){
             try(ResultSet resultSet = statement.executeQuery()){
                 while(resultSet.next()){
                     Integer id = resultSet.getInt("H.ID");
                     String name = resultSet.getString("H.NOMBRE");
                     String surname = resultSet.getString("H.APELLIDO");
                     String bornDate = resultSet.getString("H.FECHADENACIMIENTO");
                     String nacionality = resultSet.getString("H.NACIONALIDAD");
                     String phone = resultSet.getString("H.TELEFONO");
                     Integer idBooking = resultSet.getInt("R.ID");
                     
                     guestModel gues = new guestModel(name, surname, bornDate, nacionality, phone, idBooking);
                     gues.setId(id);
                     response.add(gues);
                 }
             }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        
       return response;
    }
    

    
}
