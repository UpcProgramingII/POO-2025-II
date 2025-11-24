/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parqueo.javafx.datos;

import com.mycompany.parqueo.javafx.dominio.RegistroParking;
import com.mycompany.parqueo.javafx.excepciones.ArchivoException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jairo F
 */
public class ListRegistroParking implements IBDRegistroParking {

    private List<RegistroParking> db;

    public ListRegistroParking() {
        this.db = new ArrayList();
               
    }
    
    @Override
    public void registrarIngreso(RegistroParking registro) throws ArchivoException {
           this.db.add(registro);
    }

    @Override
    public void updateRegistro(RegistroParking registro) throws ArchivoException{
        RegistroParking r=this.buscarRegistro(registro.getVehiuclo().getPlaca());
        r.setActivo(registro.isActivo());
        r.setCostoTotal(registro.getCostoTotal());
        r.setDuracion(registro.getDuracion());
        r.setId(registro.getId());
        r.setVehiuclo(registro.getVehiuclo());
        r.sethFinal(registro.gethFinal());
        r.sethInicio(registro.gethInicio());
    }
    
    @Override
    public RegistroParking buscarRegistro(String placa) throws ArchivoException {
        
        for(RegistroParking r: this.db){
            if(r.isActivo() && r.getVehiuclo().getPlaca().equals(placa)){
                return r;
            }
        }
        return null ;
    }

    @Override
    public int size() throws ArchivoException{
        return this.db.size();
    }

    @Override
    public List<RegistroParking> listAll() throws ArchivoException{
        return new ArrayList(this.db);
    }

    @Override
    public boolean contieneVehiculo(String placa) throws ArchivoException{
        for(RegistroParking r: this.db){
            if(r.isActivo() && r.getVehiuclo().getPlaca().equals(placa)){
                return true;
            }
        }
        return false ;
    }
    
}
