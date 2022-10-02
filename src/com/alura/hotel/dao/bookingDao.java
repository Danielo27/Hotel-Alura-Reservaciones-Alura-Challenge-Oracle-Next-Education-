/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.hotel.dao;

import com.alura.hotel.controller.bookingController;
import com.alura.hotel.model.bookingModel;
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
public class bookingDao {

    final private Connection con;

    public bookingDao(Connection con) {
        this.con = con;
    }

    public void setBooking(bookingModel booking) {
        try {
            String sql = "INSERT INTO reservas(fechaEntrada,fechaSalida,valor,formaDePago) VALUES (?,?,?,?)";
            try ( PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, booking.getFirstDay());
                statement.setString(2, booking.getLastDay());
                statement.setInt(3, booking.getValue());
                statement.setString(4, booking.getWayPay());
                statement.execute();
                try ( ResultSet resultSet = statement.getGeneratedKeys()) {
                    while (resultSet.next()) {
                        booking.setId(resultSet.getInt(1));
                        JOptionPane.showMessageDialog(null, String.format("Su Reserva se ha Completado con Exito %s", booking));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateBooking(bookingModel booking) {
        try {
            String sql = "UPDATE reservas SET fechaEntrada = ?, fechaSalida = ?, formaDePago = ? WHERE reservas.id = ?";
            try ( PreparedStatement statement = con.prepareStatement(sql)) {
                statement.setString(1, booking.getFirstDay());
                statement.setString(2, booking.getLastDay());
                statement.setString(3, booking.getWayPay());
                statement.setInt(4, booking.getId());
                statement.execute();

                Integer updateCount = statement.getUpdateCount();
                if (updateCount > 0) {
                    JOptionPane.showMessageDialog(null, String.format("Reserva actualizada exitosamente", booking));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, String.format("Error al Actualizar la reserva", booking));
            throw new RuntimeException(e);
        }
    }

    public List<bookingModel> getBooking() {
        List<bookingModel> response = new ArrayList<>();

        String sql = "SELECT R.ID,R.FECHAENTRADA,R.FECHASALIDA,R.VALOR,R.FORMADEPAGO FROM RESERVAS R";
        try ( PreparedStatement statement = con.prepareStatement(sql)) {
            try ( ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt("R.ID");
                    String firstDay = resultSet.getString("R.FECHAENTRADA");
                    String lastDay = resultSet.getString("R.FECHASALIDA");
                    Integer value = resultSet.getInt("R.VALOR");
                    String wayPay = resultSet.getString("R.FORMADEPAGO");

                    bookingModel book = new bookingModel(firstDay, lastDay, value, wayPay);
                    book.setId(id);
                    book.setWayPay(wayPay);
                    response.add(book);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    public Integer deleteBookingAndGuest(Integer Idbooking) {
        String sql = "CALL borrarHusResID(?)";
        try ( PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, Idbooking);
            statement.execute();

            int updateCount = statement.getUpdateCount();
            return updateCount;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
