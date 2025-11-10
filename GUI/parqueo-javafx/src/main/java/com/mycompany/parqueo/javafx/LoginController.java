/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.parqueo.javafx;

import com.mycompany.parqueo.javafx.dominio.Usuario;
import com.mycompany.parqueo.javafx.logica.GestionUsuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Jairo F
 */
public class LoginController implements Initializable {

    
    @FXML private TextField txtUsername;
    @FXML private TextField txtPassword;
    @FXML private Button btnLogin;
    @FXML private Button btnCancelar;
    @FXML private Label lbError;
    
    private GestionUsuario logicaUsuario = new GestionUsuario();
    
    @FXML
    private void eventoClickLogin() throws IOException{
    
        String username = this.txtUsername.getText();
        String password = this.txtPassword.getText();
        
        Usuario userLogged = this.logicaUsuario.login(username, password);
        if(userLogged!=null){
            App.setRoot("MainView");
        }else{
            this.lbError.setText(" !!  Usuario o Password incorrecto ¡¡");
        }
        
    }
    
    @FXML
    private void eventoClickCancelar(){
    
        this.txtUsername.setText(null);
        this.txtPassword.setText(null);
    
    }
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
