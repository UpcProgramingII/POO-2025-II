package com.mycompany.parqueo.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import java.io.IOException;

public class MainViewController {

    @FXML
    private ImageView logoImage;

    @FXML
    private Button btnRegistroVehiculo;

    @FXML
    private Button btnIngresoSalida;

    @FXML
    private Button btnInforme;

    @FXML
    private AnchorPane mainContentPane;

    // Método para cargar las vistas en el panel central
    private void loadView(String fxmlFile) {
        try {
            Node node = FXMLLoader.load(getClass().getResource( fxmlFile));
            mainContentPane.getChildren().setAll(node);

            // Ajustar el contenido al tamaño del panel
            AnchorPane.setTopAnchor(node, 0.0);
            AnchorPane.setBottomAnchor(node, 0.0);
            AnchorPane.setLeftAnchor(node, 0.0);
            AnchorPane.setRightAnchor(node, 0.0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setActiveButton(Button activeButton) {
        btnRegistroVehiculo.getStyleClass().remove("active");
        btnIngresoSalida.getStyleClass().remove("active");
        btnInforme.getStyleClass().remove("active");

        if (!activeButton.getStyleClass().contains("active")) {
            activeButton.getStyleClass().add("active");
        }
    }

    // Acciones de los botones
    @FXML
    private void handleRegistroVehiculo() {
       setActiveButton(btnRegistroVehiculo);
       loadView("RegistroVehiculoView.fxml");
    }

    @FXML
    private void handleIngresoSalida() {
       setActiveButton(btnIngresoSalida);
       loadView("IngresoSalidaView.fxml");
    }

    @FXML
    private void handleInforme() {
      setActiveButton(btnInforme);
      loadView("InformeView.fxml");
    }
}
