/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.parqueo.javafx;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InformeViewController {

    @FXML private TextField txtFiltroPlaca;
    @FXML private Button btnFiltrar;
    @FXML private Button btnLimpiar;
    @FXML private TableView<RegistroParqueo> tblParqueos;
    @FXML private TableColumn<RegistroParqueo, Integer> colId;
    @FXML private TableColumn<RegistroParqueo, String> colHoraInicio;
    @FXML private TableColumn<RegistroParqueo, String> colHoraFin;
    @FXML private TableColumn<RegistroParqueo, String> colDuracion;
    @FXML private TableColumn<RegistroParqueo, String> colPlaca;
    @FXML private TableColumn<RegistroParqueo, Double> colCosto;
    @FXML private TableColumn<RegistroParqueo, String> colActivo;
    @FXML private Label lblTotalRegistros;

    private final ObservableList<RegistroParqueo> listaOriginal = FXCollections.observableArrayList();
    private final ObservableList<RegistroParqueo> listaFiltrada = FXCollections.observableArrayList();

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @FXML
    public void initialize() {
        // Configurar columnas
        colId.setCellValueFactory(c -> c.getValue().idProperty().asObject());
        colHoraInicio.setCellValueFactory(c -> c.getValue().horaInicioProperty());
        colHoraFin.setCellValueFactory(c -> c.getValue().horaFinProperty());
        colDuracion.setCellValueFactory(c -> c.getValue().duracionProperty());
        colPlaca.setCellValueFactory(c -> c.getValue().placaProperty());
        colCosto.setCellValueFactory(c -> c.getValue().costoProperty().asObject());
        colActivo.setCellValueFactory(c -> c.getValue().activoProperty());

        // Datos simulados
        generarDatosEjemplo();
        tblParqueos.setItems(listaOriginal);
        actualizarTotal();
    }

    @FXML
    private void handleFiltrar() {
        String filtro = txtFiltroPlaca.getText().trim().toUpperCase();
        if (filtro.isEmpty()) {
            tblParqueos.setItems(listaOriginal);
        } else {
            listaFiltrada.setAll(
                listaOriginal.filtered(p -> p.getPlaca().toUpperCase().contains(filtro))
            );
            tblParqueos.setItems(listaFiltrada);
        }
        actualizarTotal();
    }

    @FXML
    private void handleLimpiar() {
        txtFiltroPlaca.clear();
        tblParqueos.setItems(listaOriginal);
        actualizarTotal();
    }

    private void actualizarTotal() {
        lblTotalRegistros.setText("Total registros: " + tblParqueos.getItems().size());
    }

    private void generarDatosEjemplo() {
        LocalDateTime base = LocalDateTime.now().minusHours(5);
        listaOriginal.add(new RegistroParqueo(1, base.minusHours(2), base.minusHours(1), "ABC123", 3.50, false));
        listaOriginal.add(new RegistroParqueo(2, base.minusHours(4), null, "XYZ987", 0.0, true));
        listaOriginal.add(new RegistroParqueo(3, base.minusHours(6), base.minusHours(5), "JKL555", 2.00, false));
    }

    // ==== Clase interna de modelo ====
    public static class RegistroParqueo {
        private final javafx.beans.property.IntegerProperty id = new javafx.beans.property.SimpleIntegerProperty();
        private final javafx.beans.property.StringProperty horaInicio = new javafx.beans.property.SimpleStringProperty();
        private final javafx.beans.property.StringProperty horaFin = new javafx.beans.property.SimpleStringProperty();
        private final javafx.beans.property.StringProperty duracion = new javafx.beans.property.SimpleStringProperty();
        private final javafx.beans.property.StringProperty placa = new javafx.beans.property.SimpleStringProperty();
        private final javafx.beans.property.DoubleProperty costo = new javafx.beans.property.SimpleDoubleProperty();
        private final javafx.beans.property.StringProperty activo = new javafx.beans.property.SimpleStringProperty();

        public RegistroParqueo(int id, LocalDateTime inicio, LocalDateTime fin, String placa, double costo, boolean activo) {
            this.id.set(id);
            this.placa.set(placa);
            this.costo.set(costo);
            this.activo.set(activo ? "Sí" : "No");

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
            this.horaInicio.set(inicio.format(fmt));
            this.horaFin.set(fin != null ? fin.format(fmt) : "-");

            if (fin != null) {
                Duration dur = Duration.between(inicio, fin);
                this.duracion.set(String.format("%dh %02dm", dur.toHours(), dur.toMinutesPart()));
            } else {
                this.duracion.set("-");
            }
        }

        // Getters JavaFX Properties
        public javafx.beans.property.IntegerProperty idProperty() { return id; }
        public javafx.beans.property.StringProperty horaInicioProperty() { return horaInicio; }
        public javafx.beans.property.StringProperty horaFinProperty() { return horaFin; }
        public javafx.beans.property.StringProperty duracionProperty() { return duracion; }
        public javafx.beans.property.StringProperty placaProperty() { return placa; }
        public javafx.beans.property.DoubleProperty costoProperty() { return costo; }
        public javafx.beans.property.StringProperty activoProperty() { return activo; }

        // Getters simples
        public String getPlaca() { return placa.get(); }
    }
}

