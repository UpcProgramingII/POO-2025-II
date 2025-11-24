/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.parqueo.javafx.datos;

import com.mycompany.parqueo.javafx.dominio.RegistroParking;
import com.mycompany.parqueo.javafx.excepciones.ArchivoException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Jairo F
 */
public interface IBDRegistroParking extends Serializable {
    
    public void registrarIngreso(RegistroParking registro) throws ArchivoException;
    
    public RegistroParking registrarSalida(String placa)throws ArchivoException;
    
    public int size() throws ArchivoException;
    
    public List<RegistroParking> listAll()throws ArchivoException;
    public boolean contieneVehiculo(String placa)throws ArchivoException;
    
}
