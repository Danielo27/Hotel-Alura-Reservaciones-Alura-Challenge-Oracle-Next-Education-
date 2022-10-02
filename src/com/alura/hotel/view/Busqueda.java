package com.alura.hotel.view;

import com.alura.hotel.controller.bookingController;
import com.alura.hotel.controller.guestController;
import com.alura.hotel.model.bookingModel;
import com.alura.hotel.model.guestModel;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

    private JPanel contentPane;
    private JTextField txtBuscar;
    private JTable tbHuespedes;
    private JTable tbReservas;
    private DefaultTableModel modelo;
    private DefaultTableModel modeloH;
    private JLabel labelAtras;
    private JLabel labelExit;
    int xMouse, yMouse;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Busqueda frame = new Busqueda();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Busqueda() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("../image/lupa2.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 910, 571);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
        setUndecorated(true);

        txtBuscar = new JTextField();
        txtBuscar.setBounds(536, 127, 193, 31);
        txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtBuscar);
        txtBuscar.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
        lblNewLabel_4.setForeground(new Color(12, 138, 199));
        lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
        lblNewLabel_4.setBounds(331, 62, 280, 42);
        contentPane.add(lblNewLabel_4);

        JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
        panel.setBackground(new Color(12, 138, 199));
        panel.setFont(new Font("Roboto", Font.PLAIN, 16));
        panel.setBounds(20, 169, 865, 328);
        contentPane.add(panel);

        tbReservas = new JTable();
        tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
        panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("../image/reservado.png")), tbReservas, null);
        modelo = (DefaultTableModel) tbReservas.getModel();
        modelo.addColumn("Numero de Reserva");
        modelo.addColumn("Fecha Check In");
        modelo.addColumn("Fecha Check Out");
        modelo.addColumn("Valor");
        modelo.addColumn("Forma de Pago");

        tbHuespedes = new JTable();
        tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
        panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("../image/pessoas.png")), tbHuespedes, null);
        modeloH = (DefaultTableModel) tbHuespedes.getModel();
        modeloH.addColumn("Numero de Huesped");
        modeloH.addColumn("Nombre");
        modeloH.addColumn("Apellido");
        modeloH.addColumn("Fecha de Nacimiento");
        modeloH.addColumn("Nacionalidad");
        modeloH.addColumn("Telefono");
        modeloH.addColumn("Numero de Reserva");

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("../image/Ha-100px.png")));
        lblNewLabel_2.setBounds(56, 51, 104, 107);
        contentPane.add(lblNewLabel_2);

        JPanel header = new JPanel();
        header.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                headerMouseDragged(e);

            }
        });
        header.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                headerMousePressed(e);
            }
        });
        header.setLayout(null);
        header.setBackground(Color.WHITE);
        header.setBounds(0, 0, 910, 36);
        contentPane.add(header);

        JPanel btnAtras = new JPanel();
        btnAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MenuUsuario usuario = new MenuUsuario();
                usuario.setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnAtras.setBackground(new Color(12, 138, 199));
                labelAtras.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAtras.setBackground(Color.white);
                labelAtras.setForeground(Color.black);
            }
        });
        btnAtras.setLayout(null);
        btnAtras.setBackground(Color.WHITE);
        btnAtras.setBounds(0, 0, 53, 36);
        header.add(btnAtras);

        labelAtras = new JLabel("<");
        labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
        labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
        labelAtras.setBounds(0, 0, 53, 36);
        btnAtras.add(labelAtras);

        JPanel btnexit = new JPanel();
        btnexit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MenuUsuario usuario = new MenuUsuario();
                usuario.setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) { //Al usuario pasar el mouse por el botón este cambiará de color
                btnexit.setBackground(Color.red);
                labelExit.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) { //Al usuario quitar el mouse por el botón este volverá al estado original
                btnexit.setBackground(Color.white);
                labelExit.setForeground(Color.black);
            }
        });
        btnexit.setLayout(null);
        btnexit.setBackground(Color.WHITE);
        btnexit.setBounds(857, 0, 53, 36);
        header.add(btnexit);

        labelExit = new JLabel("X");
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setForeground(Color.BLACK);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelExit.setBounds(0, 0, 53, 36);
        btnexit.add(labelExit);

        JSeparator separator_1_2 = new JSeparator();
        separator_1_2.setForeground(new Color(12, 138, 199));
        separator_1_2.setBackground(new Color(12, 138, 199));
        separator_1_2.setBounds(539, 159, 193, 2);
        contentPane.add(separator_1_2);

        JPanel btnbuscar = new JPanel();
        btnbuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (panel.getSelectedIndex() == 0) {
                    ListBooking(txtBuscar.getText());
                } else {
                    ListGuest(txtBuscar.getText());
                }
            }
        });
        btnbuscar.setLayout(null);
        btnbuscar.setBackground(new Color(12, 138, 199));
        btnbuscar.setBounds(748, 125, 122, 35);
        btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnbuscar);

        JLabel lblBuscar = new JLabel("BUSCAR");
        lblBuscar.setBounds(0, 0, 122, 35);
        btnbuscar.add(lblBuscar);
        lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        lblBuscar.setForeground(Color.WHITE);
        lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));

        JPanel btnEditar = new JPanel();
        btnEditar.setLayout(null);
        btnEditar.setBackground(new Color(12, 138, 199));
        btnEditar.setBounds(635, 508, 122, 35);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnEditar);

        JLabel lblEditar = new JLabel("EDITAR");
        lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
        lblEditar.setForeground(Color.WHITE);
        lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblEditar.setBounds(0, 0, 122, 35);
        btnEditar.add(lblEditar);
        btnEditar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (panel.getSelectedIndex() == 0) {
                    updateBooking();
                }else{
                    updateGuest();
                }
            }
        });

        JPanel btnEliminar = new JPanel();
        btnEliminar.setLayout(null);
        btnEliminar.setBackground(new Color(12, 138, 199));
        btnEliminar.setBounds(767, 508, 122, 35);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnEliminar);

        JLabel lblEliminar = new JLabel("ELIMINAR");
        lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
        lblEliminar.setForeground(Color.WHITE);
        lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblEliminar.setBounds(0, 0, 122, 35);
        btnEliminar.add(lblEliminar);
        setResizable(false);
        btnEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                bookingController book = new bookingController();

                if (rowSelected(panel.getSelectedIndex())) {
                    JOptionPane.showMessageDialog(null, "Ningun Elemento Seleccionado");
                    return;
                } else {
                    if (panel.getSelectedIndex() == 0) {
                        deleteBooking(book);
                    } else {
                        deleteGuest(book);
                    }
                }
            }
        });
    }

//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
    private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }

    private void ListBooking(String search) {
        bookingController booking = new bookingController();
        List<bookingModel> book = booking.getBooking();
        modelo.getDataVector().clear();
        if (!search.isEmpty()) {
            for (Integer i = 0; i < book.size(); i++) {
                if (book.get(i).getId() == Integer.parseInt(search)) {
                    addRowBooking(book.get(i));
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron resultados para este numero de reserva " + search);
                }
            }
        } else {
            book.forEach(bookings -> addRowBooking(bookings));
        }

    }

    private void ListGuest(String search) {
        guestController guest = new guestController();
        List<guestModel> gues = guest.getGuest();
        modeloH.getDataVector().clear();
        if (!search.isEmpty()) {
            for (Integer i = 0; i < gues.size(); i++) {
                if (gues.get(i).getSurname().equals(search)) {
                    addRowGuest(gues.get(i));
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron reservas a este apellido " + search);
                }
            }
        } else {
            gues.forEach(guests -> addRowGuest(guests));
        }
    }

    private void addRowBooking(bookingModel book) {
        modelo.addRow(new Object[]{
            book.getId(),
            book.getFirstDay(),
            book.getLastDay(),
            book.getValue(),
            book.getWayPay()
        });
    }

    private void addRowGuest(guestModel guest) {
        modeloH.addRow(
                new Object[]{
                    guest.getId(),
                    guest.getName(),
                    guest.getSurname(),
                    guest.getBornDate(),
                    guest.getNationality(),
                    guest.getPhoneNumber(),
                    guest.getIdReserva()
                });
    }

    private boolean rowSelected(Integer option) {
        boolean response = false;

        if (option == 0) {
            response = tbReservas.getSelectedRowCount() == 0 || tbReservas.getSelectedColumnCount() == 0;
        } else {
            response = tbHuespedes.getSelectedRowCount() == 0 || tbHuespedes.getSelectedColumnCount() == 0;
        }
        return response;
    }

    private void deleteBooking(bookingController book) {
        Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
                .ifPresent(row -> {
                    Integer id = Integer.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());
                    resultDelete(id, book.getDeleteBooking(id));
                });

    }

    private void deleteGuest(bookingController book) {
        Optional.ofNullable(modeloH.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
                .ifPresent(row -> {
                    Integer id = Integer.valueOf(modeloH.getValueAt(tbHuespedes.getSelectedRow(), 6).toString());
                    resultDelete(id, book.getDeleteBooking(id));
                });
    }

    private void resultDelete(Integer id, Integer deleteRow) {
        if (deleteRow > 0) {
            JOptionPane.showMessageDialog(null, "El Item " + id + " Se ha eliminado Exitosamente");
        }
    }

    private void updateBooking() {
        Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
                .ifPresent(row -> {
                    Integer id = Integer.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());
                    String firstDate = String.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 1).toString());
                    String lastDate = String.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 2).toString());
                    Integer value = Integer.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 3).toString());
                    String wayPay = String.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 4).toString());

                    bookingController book = new bookingController();
                    book.updateBooking(id, firstDate, lastDate, value , wayPay);
                });
    }

    private void updateGuest() {
        Optional.ofNullable(modeloH.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
                .ifPresent(row -> {
                    Integer id = Integer.valueOf(modeloH.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());
                    String name = String.valueOf(modeloH.getValueAt(tbHuespedes.getSelectedRow(), 1).toString());
                    String surname = String.valueOf(modeloH.getValueAt(tbHuespedes.getSelectedRow(), 2).toString());
                    String bornDate = String.valueOf(modeloH.getValueAt(tbHuespedes.getSelectedRow(), 3).toString());
                    String nacionalty = String.valueOf(modeloH.getValueAt(tbHuespedes.getSelectedRow(), 4).toString());
                    String phoneNumber = String.valueOf(modeloH.getValueAt(tbHuespedes.getSelectedRow(), 5).toString());
                    Integer idBooking = Integer.valueOf(modeloH.getValueAt(tbHuespedes.getSelectedRow(), 6).toString());
                    
                    guestController guest = new guestController();
                    guest.updateGuest(id, name, surname, bornDate, nacionalty, phoneNumber, idBooking);
                });
    }

}


//SET GLOBAL time_zone = '-3:00';
