/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parqueo.javafx.logica;

import com.mycompany.parqueo.javafx.datos.*;
import com.mycompany.parqueo.javafx.dominio.*;
import com.mycompany.parqueo.javafx.excepciones.ArchivoException;
import com.mycompany.parqueo.javafx.excepciones.VehiculoException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jairo F
 */
public class GestionVehiculo {
    
    private IBDVehiculo bd;

    public GestionVehiculo() {
        //this.bd = new MapVehiculo();
        //this.bd = new ListVehiculo();
        this.bd = new ArchivoVehiculo();
    }
    
    public Moto crearMoto(String placa, String marca, String cilindraje){
        
        int cilindrajeValue=0;
        if(placa.isEmpty())
            throw new IllegalArgumentException("Se requiere placa");
        if(marca.isEmpty())
            throw new IllegalArgumentException("Se requiere marca");
        if(cilindraje.isEmpty())
            throw new IllegalArgumentException("Se requiere cilindraje");
        
        try{
             cilindrajeValue= Integer.parseInt(cilindraje);
         }
        catch(Exception e){
            throw new IllegalArgumentException("Cilindraje requiere valor numerico");
        }
        return new Moto(placa, marca, cilindrajeValue);
    }   
    
    public Auto crearAuto(String placa, String marca, String modelo, String nPuertas){
        
        int modeloValue=0;
        int nPuertasValue=0;
        
        if(placa.isEmpty())
            throw new IllegalArgumentException("Se requiere placa");
        if(marca.isEmpty())
            throw new IllegalArgumentException("Se requiere marca");
        if(modelo.isEmpty())
            throw new IllegalArgumentException("Se requiere modelo");
        if(nPuertas.isEmpty())
            throw new IllegalArgumentException("Se requiere no puertas");
        
        try{
             modeloValue= Integer.parseInt(modelo);
             nPuertasValue=Integer.parseInt(nPuertas);
         }
        catch(Exception e){
            throw new IllegalArgumentException("Se requiere valor numerico parsa modelo | No Puertas");
        }
        return new Auto(placa, marca, modeloValue, nPuertasValue);
    }
    
    public Bicicleta crearBicicleta(String placa, String tipo, boolean tieneCambios){
        if(placa.isEmpty())
            throw new IllegalArgumentException("Se requiere placa");
        if(tipo.isEmpty())
            throw new IllegalArgumentException("Se requiere tipo");
        
        return new Bicicleta(placa, tipo, tieneCambios);
    }
    
    
    public void adicionarVehiculo(Vehiculo v) throws VehiculoException, ArchivoException{
        
        if(this.bd.exist(v.getPlaca()))
            throw new VehiculoException("La placa del vehiculo ya se encuentra registrada");
        
        this.bd.adicionarVehiculo(v);
    }
    
    public List<Vehiculo> listarTodos() throws ArchivoException{
        return this.bd.listarTodos();
    }
    public Vehiculo buscar(String placa) throws ArchivoException{
        return this.bd.buscar(placa);
    }
    
    public void eliminar(String placa) throws ArchivoException{
        this.bd.eliminar(placa);
    }
    
    
}
