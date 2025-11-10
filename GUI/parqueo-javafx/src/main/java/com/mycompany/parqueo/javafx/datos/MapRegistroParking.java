/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parqueo.javafx.datos;

import com.mycompany.parqueo.javafx.dominio.RegistroParking;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jairo F
 */
public class MapRegistroParking implements IBDRegistroParking {
    
    private Map<String, RegistroParking> bd;

    public MapRegistroParking() {
        this.bd = new HashMap();
    }

    @Override
    public void registrarIngreso(RegistroParking registro) {
        
        this.bd.put(registro.getVehiuclo().getPlaca(), registro);
        
        
    }

    @Override
    public RegistroParking registrarSalida(String placa) {
        return this.bd.get(placa);
    }

    @Override
    public int size() {
        return this.bd.size();
    }

    @Override
    public List<RegistroParking> listAll() {
        
        return new ArrayList(this.bd.values());
    }

   
    
    
    
}
