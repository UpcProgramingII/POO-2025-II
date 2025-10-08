/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import dominio.IFacturable;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author Jairo F
 */
public class ParkingManager {
    
    private static int ticket=0;
    
    
    public double calcularCostoParqueo(LocalDateTime hEntrada, LocalDateTime hSalida, IFacturable vehiculo){
        double horas = this.duracionHoras(hEntrada, hSalida);
        double costo = vehiculo.facturar(horas);
        return costo;
    }
    
    public long duracionHoras(LocalDateTime hEntrada, LocalDateTime hSalida){
        Duration duracion = Duration.between(hEntrada, hSalida);
        long horas = duracion.toHours();
        return horas;
    }
    
    public String imprimirTicket(LocalDateTime hEntrada, LocalDateTime hSalida, IFacturable vehiculo){
        ParkingManager.ticket ++;
        
        String datos = "Hora Inicio: " + hEntrada + "\n" +
                       "Hora salida: " + hSalida  + "\n" +
                       "Horas Facturadas: " + this.duracionHoras(hEntrada, hSalida) + "\n" +
                       "Vehiculo: " + vehiculo.toString() + "\n" +
                       "Costo total: " + this.calcularCostoParqueo(hEntrada, hSalida, vehiculo) +"\n" +
                       "No Ticket: " + ParkingManager.ticket + "\n"+
                       "---------------------------\n";
        
        return datos;
    
    }
    
    
}
