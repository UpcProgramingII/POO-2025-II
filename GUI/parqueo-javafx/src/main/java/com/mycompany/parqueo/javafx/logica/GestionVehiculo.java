/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parqueo.javafx.logica;

import com.mycompany.parqueo.javafx.datos.*;
import com.mycompany.parqueo.javafx.dominio.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jairo F
 */
public class GestionVehiculo {
    
    private IBDVehiculo bd;

    public GestionVehiculo() {
        this.bd = new MapVehiculo();
        //this.bd = new ListVehiculo();
    }
    
    public void adicionarVehiculo(Vehiculo v){
        this.bd.adicionarVehiculo(v);
    }
    public List<Vehiculo> listarTodos(){
        return this.bd.listarTodos();
    }
    public Vehiculo buscar(String placa){
        return this.bd.buscar(placa);
    }
    
    public void eliminar(String placa){
        this.bd.eliminar(placa);
    }
    
    
}
