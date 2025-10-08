/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presentacion;

import datos.BDVehiculo;
import datos.IBDVehiculo;
import dominio.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
        
        IBDVehiculo bd = new BDVehiculo();
        ParkingManager parqueadero = new ParkingManager();
        
        Vehiculo auto = new Auto("ABC", "Toyota", 2020, 4);
        bd.adicionarVehiculo(auto);
        
        Vehiculo moto= new Moto("rge", "Suzuki", 501);        
        bd.adicionarVehiculo(moto);
        
        Vehiculo cicla = new Bicicleta("123", "Cross", true);
        bd.adicionarVehiculo(cicla);
        
        System.out.println(parqueadero.imprimirTicket(LocalDateTime.now(), LocalDateTime.now().plusHours(5), bd.buscar("ABC")));
        System.out.println(parqueadero.imprimirTicket(LocalDateTime.now(), LocalDateTime.now().plusHours(3), bd.buscar("rge")));
        System.out.println(parqueadero.imprimirTicket(LocalDateTime.now(), LocalDateTime.now().plusHours(2), bd.buscar("123")));
        
        imprimir(bd.listarTodos());
    }
    
    public static void imprimir(ArrayList<Vehiculo> lista){
        
        for(Vehiculo v: lista){
            System.out.println(v);
        }
        
    }
    
}
