/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parqueo.javafx.datos;

import com.mycompany.parqueo.javafx.dominio.Vehiculo;
import com.mycompany.parqueo.javafx.excepciones.ArchivoException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jairo F
 */
public class MapVehiculo implements IBDVehiculo {
    
    private Map<String, Vehiculo> bd;

    public MapVehiculo() {
        this.bd = new HashMap();
    }
    
    @Override
    public void adicionarVehiculo(Vehiculo v) throws ArchivoException {
        
        this.bd.put(v.getPlaca(), v);
        
    }

    @Override
    public List<Vehiculo> listarTodos() throws ArchivoException {
    
         return new ArrayList(this.bd.values());
         
    }

    @Override
    public Vehiculo buscar(String placa) throws ArchivoException {
        
        return this.bd.get(placa);
        
    }

    @Override
    public void eliminar(String placa) throws ArchivoException {
        
        this.bd.remove(placa);
        
    }

    @Override
    public boolean exist(String placa) throws ArchivoException {
        return this.bd.containsKey(placa);
    }
    
}
