/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parqueo.javafx.datos;

import com.mycompany.parqueo.javafx.dominio.Vehiculo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jairo F
 */
public class ListVehiculo implements IBDVehiculo {
    
    private List<Vehiculo> registro;

    public ListVehiculo() {
        
        this.registro = new ArrayList();
        
    }
    
       
    @Override
    public List<Vehiculo> listarTodos(){
        
        return new ArrayList(this.registro);
        
    }
    
    @Override
    public Vehiculo buscar(String placa){
        
        for(Vehiculo v: this.registro){
            if(v.getPlaca().equals(placa)){
                return v;
            }
        }
        
        return null;
    }

    @Override
    public void adicionarVehiculo(Vehiculo v) {
        this.registro.add(v);
    }

    @Override
    public void eliminar(String placa) {
        
        Vehiculo v = this.buscar(placa);
        if(v!=null){
            this.registro.remove(v);
        }
        
        
    }
    
    
    
}
