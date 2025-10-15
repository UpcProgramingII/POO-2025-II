/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.Vehiculo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jairo F
 */
public interface IBDVehiculo {
    
    public void adicionarVehiculo(Vehiculo v);
    public List<Vehiculo> listarTodos();
    public Vehiculo buscar(String placa);
    public void eliminar(String placa);
    
    
}
