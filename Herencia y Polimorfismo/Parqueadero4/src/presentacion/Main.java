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
        logicaVehiculo.adicionarVehiculo(moto);
        
        Vehiculo cicla = new Bicicleta("123", "Cross", true);
        logicaVehiculo.adicionarVehiculo(cicla);
        
        parqueadero.registroIngreso(logicaVehiculo.buscar("ABC"));
        parqueadero.registroIngreso(logicaVehiculo.buscar("rge"));
        parqueadero.registroIngreso(logicaVehiculo.buscar("123"));
        
        tiempo();
        
        Ticket ticket1 = parqueadero.registrarSalida("ABC");
        parqueadero.imprimirTicket(ticket1);
        
        tiempo();
        
        Ticket ticket2 = parqueadero.registrarSalida("rge");
        parqueadero.imprimirTicket(ticket2);
        
        tiempo();
        Ticket ticket3 = parqueadero.registrarSalida("123");
        parqueadero.imprimirTicket(ticket3);
        
        parqueadero.printRegistro();
        
        
        
       
    }
    
    public static void  tiempo(){
        for(double i=0; i<=1000000000;i++){
        }
    }
    
    public static void imprimir(List<Vehiculo> lista){
        
        for(Vehiculo v: lista){
            System.out.println(v);
        }
        
    }
    
}
