/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.parqueo.javafx;


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

    // Simulación de base de datos en memoria
    private static final Map<String, Ticket> ticketsActivos = new HashMap<>();
    private static final AtomicInteger contadorId = new AtomicInteger(1);

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @FXML
    public void handleIngreso() {
        String placa = txtPlaca.getText().trim();
        if (placa.isEmpty()) {
            lblMensaje.setText("⚠️ Ingrese una placa válida.");
            return;
        }

        if (ticketsActivos.containsKey(placa)) {
            lblMensaje.setText("⚠️ Este vehículo ya tiene un ingreso activo.");
            return;
        }

        // Crear nuevo ticket
        Ticket ticket = new Ticket(contadorId.getAndIncrement(), placa, LocalDateTime.now());
        ticketsActivos.put(placa, ticket);

        mostrarTicket(ticket);
        lblMensaje.setText("✅ Ingreso registrado correctamente.");
    }

    @FXML
    public void handleSalida() {
        String placa = txtPlaca.getText().trim();
        if (placa.isEmpty()) {
            lblMensaje.setText("⚠️ Ingrese una placa válida.");
            return;
        }

        Ticket ticket = ticketsActivos.get(placa);
        if (ticket == null) {
            lblMensaje.setText("⚠️ No se encontró un ingreso activo para esa placa.");
            return;
        }

        ticket.setHoraSalida(LocalDateTime.now());
        ticket.calcularCosto();

        ticketsActivos.remove(placa);

        mostrarTicket(ticket);
        lblMensaje.setText("✅ Salida registrada correctamente.");
    }

    private void mostrarTicket(Ticket t) {
        lblIdTicket.setText(String.valueOf(t.getId()));
        lblHoraIngreso.setText(format(t.getHoraIngreso()));
        lblHoraSalida.setText(t.getHoraSalida() != null ? format(t.getHoraSalida()) : "-");
        lblDuracion.setText(t.getDuracionTexto());
        lblTipoVehiculo.setText(t.getTipoVehiculo());
        lblTarifa.setText(String.format("$ %.2f", t.getTarifa()));
        lblRecargo.setText(String.format("$ %.2f", t.getRecargo()));
        lblCostoTotal.setText(String.format("$ %.2f", t.getTotal()));
    }

    private String format(LocalDateTime dt) {
        return dt != null ? dt.format(formatter) : "-";
    }

    /* ==========================
       Clase interna Ticket
       ========================== */
    private static class Ticket {
        private final int id;
        private final String placa;
        private final LocalDateTime horaIngreso;
        private LocalDateTime horaSalida;
        private double tarifa;
        private double recargo;
        private double total;
        private String tipoVehiculo = "Desconocido";

        public Ticket(int id, String placa, LocalDateTime horaIngreso) {
            this.id = id;
            this.placa = placa;
            this.horaIngreso = horaIngreso;
            // Tarifa base simulada
            this.tarifa = 2.0; 
        }

        public void setHoraSalida(LocalDateTime horaSalida) {
            this.horaSalida = horaSalida;
        }

        public void calcularCosto() {
            if (horaSalida == null) return;

            Duration duracion = Duration.between(horaIngreso, horaSalida);
            long minutos = duracion.toMinutes();
            double horas = Math.max(1, Math.ceil(minutos / 60.0));

            // Tarifa base + recargo
            this.recargo = (horas > 3) ? 1.5 : 0;
            this.total = (tarifa * horas) + recargo;
        }

        public String getDuracionTexto() {
            if (horaSalida == null) return "-";
            Duration d = Duration.between(horaIngreso, horaSalida);
            long horas = d.toHours();
            long minutos = d.toMinutesPart();
            return String.format("%dh %02dm", horas, minutos);
        }

        // Getters
        public int getId() { return id; }
        public LocalDateTime getHoraIngreso() { return horaIngreso; }
        public LocalDateTime getHoraSalida() { return horaSalida; }
        public double getTarifa() { return tarifa; }
        public double getRecargo() { return recargo; }
        public double getTotal() { return total; }
        public String getTipoVehiculo() { return tipoVehiculo; }
    }
}

