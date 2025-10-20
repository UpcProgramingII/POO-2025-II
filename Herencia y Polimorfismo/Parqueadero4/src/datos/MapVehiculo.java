/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.Vehiculo;
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
    public void adicionarVehiculo(Vehiculo v) {
        
        this.bd.put(v.getPlaca(), v);
        
    }

    @Override
    public List<Vehiculo> listarTodos() {
    
         return new ArrayList(this.bd.values());
         
    }

    @Override
    public Vehiculo buscar(String placa) {
        
        return this.bd.get(placa);
        
    }

    @Override
    public void eliminar(String placa) {
        
        this.bd.remove(placa);
        
    }
    
}
