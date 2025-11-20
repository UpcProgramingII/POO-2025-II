/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parqueo.javafx.datos;


import com.mycompany.parqueo.javafx.dominio.Vehiculo;
import com.mycompany.parqueo.javafx.excepciones.ArchivoException;
import java.util.List;

/**
 *
 * @author Jairo F
 */
public interface IBDVehiculo {
    
    public void adicionarVehiculo(Vehiculo v) throws ArchivoException;
    public List<Vehiculo> listarTodos() throws ArchivoException;
    public Vehiculo buscar(String placa) throws ArchivoException;
    public void eliminar(String placa) throws ArchivoException;
    public boolean exist(String placa) throws ArchivoException;
    
    
}
