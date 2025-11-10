/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.parqueo.javafx.datos;

import com.mycompany.parqueo.javafx.dominio.RegistroParking;
import java.util.List;

/**
 *
 * @author Jairo F
 */
public interface IBDRegistroParking {
    
    public void registrarIngreso(RegistroParking registro);
    
    public RegistroParking registrarSalida(String placa);
    
    public int size();
    
    public List<RegistroParking> listAll();
    
}
