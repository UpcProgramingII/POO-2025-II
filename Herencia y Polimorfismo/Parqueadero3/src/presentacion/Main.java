/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presentacion;

import datos.ListVehiculo;
import datos.IBDVehiculo;
import dominio.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import logica.GestionVehiculo;
import logica.ParkingManager;

/**
 *
 * @author Jairo F
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        GestionVehiculo logicaVehiculo = new GestionVehiculo();
        ParkingManager parqueadero = new ParkingManager();
        
        Vehiculo auto = new Auto("ABC", "Toyota", 2020, 4);
        logicaVehiculo.adicionarVehiculo(auto);
        
        Vehiculo moto= new Moto("rge", "Suzuki", 501);        
        Vehiculo moto2= new Moto("rge", "Suzuki", 501);        
        logicaVehiculo.adicionarVehiculo(moto);
        
        Vehiculo cicla = new Bicicleta("123", "Cross", true);
        logicaVehiculo.adicionarVehiculo(cicla);
        
        Ticket ticket1 = parqueadero.generarTicket(LocalDateTime.now(), LocalDateTime.now().plusHours(5), logicaVehiculo.buscar("ABC"));
        parqueadero.imprimirTicket(ticket1);
        
        Ticket ticket2 = parqueadero.generarTicket(LocalDateTime.now(), LocalDateTime.now().plusHours(3), logicaVehiculo.buscar("rge"));
        parqueadero.imprimirTicket(ticket2);
        
        Ticket ticket3 = parqueadero.generarTicket(LocalDateTime.now(), LocalDateTime.now().plusHours(2), logicaVehiculo.buscar("123"));
        parqueadero.imprimirTicket(ticket3);
        
        imprimir(logicaVehiculo.listarTodos());
        
       
    }
    
    public static void imprimir(List<Vehiculo> lista){
        
        for(Vehiculo v: lista){
            System.out.println(v);
        }
        
    }
    
}
