/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.parqueo.javafx;


import com.mycompany.parqueo.javafx.dominio.Ticket;
import com.mycompany.parqueo.javafx.dominio.Vehiculo;
import com.mycompany.parqueo.javafx.logica.GestionVehiculo;
import com.mycompany.parqueo.javafx.logica.ParkingManager;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class IngresoSalidaViewController {

    @FXML private TextField txtPlaca;
    @FXML private Button btnIngresar;
    @FXML private Button btnSalir;
    @FXML private Label lblMensaje;

    // Ticket labels
    @FXML private Label lblIdTicket;
    @FXML private Label lblHoraIngreso;
    @FXML private Label lblHoraSalida;
    @FXML private Label lblDuracion;
    @FXML private Label lblTipoVehiculo;
    @FXML private Label lblTarifa;
    @FXML private Label lblRecargo;
    @FXML private Label lblCostoTotal;

    private ParkingManager logicaParking = new ParkingManager();
    //private GestionVehiculo logicaVehiculo=new GestionVehiculo();

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @FXML
    public void handleIngreso() {
        String placa = txtPlaca.getText().trim();
        Vehiculo vehiculo=null;
        if (placa.isEmpty()) {
            lblMensaje.setText("⚠️ Ingrese una placa válida.");
            limpiarTicketScreen();
            return;
        }
        else {
            vehiculo = App.logicaVehiculo.buscar(placa);
            if(vehiculo==null){
                lblMensaje.setText("⚠️ El vehiculo no se encuentra en DB");
                limpiarTicketScreen();
                return;
            }
        }
        
        
        if (this.logicaParking.contieneVehiculo(placa)) {
            lblMensaje.setText("⚠️ Este vehículo ya tiene un ingreso activo.");
            limpiarTicketScreen();
            return;
        }
        
        // Crear nuevo ticket
        Ticket ticket = this.logicaParking.crearIngreso(vehiculo);

        mostrarTicket(ticket);
        lblMensaje.setText("✅ Ingreso registrado correctamente.");
    }

    @FXML
    public void handleSalida() {
        String placa = txtPlaca.getText().trim();
        if (placa.isEmpty()) {
            lblMensaje.setText("⚠️ Ingrese una placa válida.");
            limpiarTicketScreen();
            return;
        }


        if (!this.logicaParking.contieneVehiculo(placa)) {
            lblMensaje.setText("⚠️ No se encontró un ingreso activo para esa placa.");
            limpiarTicketScreen();
            return;
        }

        Ticket ticket = this.logicaParking.registrarSalida(placa);
        mostrarTicket(ticket);
        lblMensaje.setText("✅ Salida registrada correctamente.");
    }

    private void mostrarTicket(Ticket t) {
        lblIdTicket.setText(String.valueOf(t.getIdTicket()));
        //lblHoraIngreso.setText(format(t.getHoraIngreso));
        lblHoraIngreso.setText(t.gethInicio());
        //lblHoraSalida.setText(t.getHoraSalida() != null ? format(t.getHoraSalida()) : "-");
        lblHoraSalida.setText(t.gethFinal());
        lblDuracion.setText(t.getDuracion());
        lblTipoVehiculo.setText(t.getTipo());
        lblTarifa.setText(String.format("$ %.2f", Double.valueOf(t.getTarifa())));
        lblRecargo.setText(String.format("$ %.2f", Double.valueOf(t.getRecargo())));
        lblCostoTotal.setText(String.format("$ %.2f", Double.valueOf(t.getCostoTotal())));
    }
    
    private void limpiarTicketScreen() {
        lblIdTicket.setText(null);
        lblHoraIngreso.setText(null);
        lblHoraSalida.setText(null);
        lblDuracion.setText(null);
        lblTipoVehiculo.setText(null);
        lblTarifa.setText(null);
        lblRecargo.setText(null);
        lblCostoTotal.setText(null);
    }
    

    private String format(LocalDateTime dt) {
        return dt != null ? dt.format(formatter) : "-";
    }
}