/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.parqueo.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class RegistroVehiculoViewController {

    @FXML
    private ComboBox<String> cmbTipoVehiculo;
    @FXML
    private TextField txtPlaca;

    // Auto
    @FXML private VBox paneAuto;
    @FXML private TextField txtMarcaAuto;
    @FXML private TextField txtModeloAuto;
    @FXML private TextField txtPuertasAuto;

    // Moto
    @FXML private VBox paneMoto;
    @FXML private TextField txtMarcaMoto;
    @FXML private TextField txtCilindrajeMoto;

    // Bicicleta
    @FXML private VBox paneBicicleta;
    @FXML private TextField txtTipoBicicleta;
    @FXML private CheckBox chkCambiosBicicleta;

    @FXML
    private Button btnRegistrar;
    @FXML
    private Label lblMensaje;

    @FXML
    public void initialize() {
        cmbTipoVehiculo.getItems().addAll("Auto", "Moto", "Bicicleta");
//
        cmbTipoVehiculo.valueProperty().addListener((obs, oldVal, newVal) -> {
            actualizarSecciones(newVal);
        });
    }

    private void actualizarSecciones(String tipo) {
        // Ocultar todos
        paneAuto.setVisible(false);
        paneAuto.setManaged(false);
        paneMoto.setVisible(false);
        paneMoto.setManaged(false);
        paneBicicleta.setVisible(false);
        paneBicicleta.setManaged(false);

        if (tipo == null) return;

        switch (tipo) {
            case "Auto":
                paneAuto.setVisible(true);
                paneAuto.setManaged(true);
                break;
            case "Moto":
                paneMoto.setVisible(true);
                paneMoto.setManaged(true);
                break;
            case "Bicicleta":
                paneBicicleta.setVisible(true);
                paneBicicleta.setManaged(true);
                break;
        }
    }

    @FXML
    private void handleRegistrarVehiculo() {
        String tipo = cmbTipoVehiculo.getValue();
        String placa = txtPlaca.getText();

        if (tipo == null || placa.isEmpty()) {
            lblMensaje.setText("⚠️ Debe seleccionar un tipo de vehículo y una placa válida.");
            return;
        }

        switch (tipo) {
            case "Auto":
                lblMensaje.setText(String.format("Auto registrado: %s, Marca %s, Modelo %s, Puertas %s",
                        placa, txtMarcaAuto.getText(), txtModeloAuto.getText(), txtPuertasAuto.getText()));
                break;
            case "Moto":
                lblMensaje.setText(String.format("Moto registrada: %s, Marca %s, Cilindraje %s",
                        placa, txtMarcaMoto.getText(), txtCilindrajeMoto.getText()));
                break;
            case "Bicicleta":
                lblMensaje.setText(String.format("Bicicleta registrada: %s, Tipo %s, Cambios: %s",
                        placa, txtTipoBicicleta.getText(), chkCambiosBicicleta.isSelected() ? "Sí" : "No"));
                break;
        }

        limpiarCampos();
    }

    private void limpiarCampos() {
        txtPlaca.clear();
        txtMarcaAuto.clear();
        txtModeloAuto.clear();
        txtPuertasAuto.clear();
        txtMarcaMoto.clear();
        txtCilindrajeMoto.clear();
        txtTipoBicicleta.clear();
        chkCambiosBicicleta.setSelected(false);
    }
}
