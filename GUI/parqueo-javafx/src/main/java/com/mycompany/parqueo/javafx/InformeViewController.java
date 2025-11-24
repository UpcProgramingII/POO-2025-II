/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.parqueo.javafx;

import com.mycompany.parqueo.javafx.dominio.RegistroParking;
import com.mycompany.parqueo.javafx.excepciones.ArchivoException;
import com.mycompany.parqueo.javafx.logica.ParkingManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert.AlertType;

public class InformeViewController {

    @FXML
    private TextField txtFiltroPlaca;
    @FXML
    private Button btnFiltrar;
    @FXML
    private Button btnLimpiar;
    @FXML
    private TableView<RegistroParqueoDto> tblParqueos;
    @FXML
    private TableColumn<RegistroParqueoDto, Integer> colId;
    @FXML
    private TableColumn<RegistroParqueoDto, String> colHoraInicio;
    @FXML
    private TableColumn<RegistroParqueoDto, String> colHoraFin;
    @FXML
    private TableColumn<RegistroParqueoDto, String> colDuracion;
    @FXML
    private TableColumn<RegistroParqueoDto, String> colPlaca;
    @FXML
    private TableColumn<RegistroParqueoDto, Double> colCosto;
    @FXML
    private TableColumn<RegistroParqueoDto, String> colActivo;
    @FXML
    private Label lblTotalRegistros;
    @FXML
    private BarChart<String, Number> grafico = new BarChart<String, Number>(new CategoryAxis(), new NumberAxis());
    @FXML
    private PieChart grafico2 = new  PieChart(FXCollections.observableArrayList());

    private final ObservableList<RegistroParqueoDto> listaOriginal = FXCollections.observableArrayList();
    private final ObservableList<RegistroParqueoDto> listaFiltrada = FXCollections.observableArrayList();

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private ParkingManager logicaParking;
    private boolean habilitarAcciones = false;

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

        this.grafico.setTitle("Ingresos por tipo de Vehiculo");
        this.grafico.getXAxis().setLabel("Tipo vehiculo");
        this.grafico.getYAxis().setLabel("Value");
        
        this.grafico2.setTitle("Registros Activos vs No Activos");

        try {

            this.logicaParking = new ParkingManager();
            this.habilitarAcciones = true;
            // Datos simulados
            cargarDatos();
            tblParqueos.setItems(listaOriginal);
            actualizarTotal();
            this.crearGrarficaBarra();
            this.crearGraficoTorta();

        } catch (ArchivoException e) {
            crearAlerta(Alert.AlertType.ERROR, "Error al abrir la base de datos de parking");
            this.habilitarAcciones = false;
        }

        this.btnFiltrar.setDisable(!this.habilitarAcciones);
        this.btnLimpiar.setDisable(!this.habilitarAcciones);

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
        try {
            this.cargarDatos();
        } catch (ArchivoException e) {

            crearAlerta(Alert.AlertType.ERROR, e.getMessage());

        }
    }

    private void crearAlerta(AlertType type, String msg) {

        Alert alerta = new Alert(type);
        alerta.setTitle("Error de BD");
        alerta.setContentText(msg);
        alerta.setHeaderText("Descripcion del error");
        alerta.show();
    }

    private void actualizarTotal() {
        lblTotalRegistros.setText("Total registros: " + tblParqueos.getItems().size());
    }

    private void cargarDatos() throws ArchivoException {
        this.listaOriginal.clear();
        List<RegistroParking> datos = this.logicaParking.getAll();
        datos.forEach((r) -> {
            this.listaOriginal.add(new RegistroParqueoDto(r));
        });
        this.tblParqueos.setItems(this.listaOriginal);
        this.actualizarTotal();

    }

    private void crearGrarficaBarra() throws ArchivoException {
        
        
        Map<String, Integer> datos = this.logicaParking.dataGraficaBarra();
        XYChart.Series serie = new XYChart.Series<>();
        serie.getData().add(new XYChart.Data("Auto", datos.get("Auto")));
        serie.getData().add(new XYChart.Data("Moto", datos.get("Moto")));
        serie.getData().add(new XYChart.Data("Bicicleta", datos.get("Bicicleta")));

        this.grafico.getData().add(serie);
    }
    
    private void crearGraficoTorta() throws ArchivoException{
        
        Map<String, Integer> values = this.logicaParking.dataGraficaTorta();
        PieChart.Data datos[] = new PieChart.Data[2];
        datos[0] = new PieChart.Data("Activos("+values.get("Activo")+")", values.get("Activo"));
        datos[1] = new PieChart.Data("No Activos("+values.get("No Activo")+")", values.get("No Activo"));
        
        this.grafico2.getData().setAll(datos);
        this.grafico2.setLabelsVisible(true);
        
    }

    // ==== Clase interna de modelo ====
    public static class RegistroParqueoDto {

        private final javafx.beans.property.IntegerProperty id = new javafx.beans.property.SimpleIntegerProperty();
        private final javafx.beans.property.StringProperty horaInicio = new javafx.beans.property.SimpleStringProperty();
        private final javafx.beans.property.StringProperty horaFin = new javafx.beans.property.SimpleStringProperty();
        private final javafx.beans.property.StringProperty duracion = new javafx.beans.property.SimpleStringProperty();
        private final javafx.beans.property.StringProperty placa = new javafx.beans.property.SimpleStringProperty();
        private final javafx.beans.property.DoubleProperty costo = new javafx.beans.property.SimpleDoubleProperty();
        private final javafx.beans.property.StringProperty activo = new javafx.beans.property.SimpleStringProperty();

        public RegistroParqueoDto(RegistroParking p) {

            this.activo.set(p.isActivo() ? "si" : "no");
            this.costo.set(p.getCostoTotal());
            this.duracion.set(String.valueOf(p.getDuracion()));
            this.horaFin.set(p.gethFinal() != null ? p.gethFinal().toString() : null);
            this.horaInicio.set(p.gethInicio().toString());
            this.id.set(p.getId());
            this.placa.set(p.getVehiuclo().getPlaca());

        }

        public RegistroParqueoDto(int id, LocalDateTime inicio, LocalDateTime fin, String placa, double costo, boolean activo) {
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
        public javafx.beans.property.IntegerProperty idProperty() {
            return id;
        }

        public javafx.beans.property.StringProperty horaInicioProperty() {
            return horaInicio;
        }

        public javafx.beans.property.StringProperty horaFinProperty() {
            return horaFin;
        }

        public javafx.beans.property.StringProperty duracionProperty() {
            return duracion;
        }

        public javafx.beans.property.StringProperty placaProperty() {
            return placa;
        }

        public javafx.beans.property.DoubleProperty costoProperty() {
            return costo;
        }

        public javafx.beans.property.StringProperty activoProperty() {
            return activo;
        }

        // Getters simples
        public String getPlaca() {
            return placa.get();
        }
    }
}
