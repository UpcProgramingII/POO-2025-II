/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parqueo.javafx.logica;


import com.mycompany.parqueo.javafx.datos.*;
import com.mycompany.parqueo.javafx.dominio.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 *
 * @author Jairo F
 */
public class ParkingManager {
    
    private static int ticket=0;
    private IBDRegistroParking bdParking;

    public ParkingManager() {
        this.bdParking =new ListRegistroParking();
    }
    
    
    public void registroIngreso(IFacturable vehiculo){
        
        RegistroParking registro = new RegistroParking(vehiculo);
        registro.setId(this.bdParking.size()+1); 
        this.bdParking.registrarIngreso(registro);
        
        
    }
    
    public Ticket registrarSalida(String placa){
        
        RegistroParking registro = this.bdParking.registrarSalida(placa);
        registro.sethFinal(LocalDateTime.now());// se suma manualmente 4 horas
        this.duracionHoras(registro);
        this.facturarCostoParqueo(registro);
        registro.setActivo(false);
        //this.bdParking.registrarIngreso(registro);
        return this.generarTicket(registro);
        
    }
    
    public void printRegistro(){
        DateTimeFormatter format = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        for(RegistroParking r:this.bdParking.listAll()){
            System.out.printf("%S %10s %10s %10s %10s %10s %10s%n",
                    r.getId(),
                    format.format(r.gethInicio()),
                    format.format(r.gethFinal()),
                    r.getDuracion(),
                    r.getVehiuclo().getPlaca(),
                    r.getCostoTotal(),
                    r.isActivo());
        }
    
    }
    
    
    public Ticket generarTicket(RegistroParking registro){
        return this.generarTicket(registro.gethInicio(), registro.gethFinal(), registro.getVehiuclo());
    }
    
    
    public Ticket generarTicket(LocalDateTime hEntrada, LocalDateTime hSalida, IFacturable vehiculo){
        
        double costo = this.facturarCostoParqueo(hEntrada, hSalida, vehiculo);
        
        Ticket ticket = new Ticket();
        ticket.sethInicio(hEntrada.toString());
        ticket.sethFinal(hSalida.toString());
        ticket.setDuracion(String.valueOf(this.duracionHoras(hEntrada, hSalida)));
        ticket.setPlaca(((Vehiculo)vehiculo).getPlaca());
        ticket.setTipo(vehiculo.getType());
        ticket.setTarifa(String.valueOf(vehiculo.getTarifa()));
        ticket.setRecrago(String.valueOf(vehiculo.getRecargo()));
        ticket.setCostoTotal(String.valueOf(costo));
        
        return ticket;
    }
    
    public void facturarCostoParqueo(RegistroParking registro){
        double costo = this.facturarCostoParqueo(registro.gethInicio(), registro.gethFinal(), registro.getVehiuclo());
        registro.setCostoTotal(costo);
    }
    
    public double facturarCostoParqueo(LocalDateTime hEntrada, LocalDateTime hSalida, IFacturable vehiculo) {
        return this.duracionHoras(hEntrada, hSalida) * vehiculo.getTarifa() + vehiculo.getRecargo();
    }
    
    public void duracionHoras(RegistroParking registro){
        double duracion = this.duracionHoras(registro.gethInicio(), registro.gethFinal());
        registro.setDuracion(duracion);
    }
    public double duracionHoras(LocalDateTime hEntrada, LocalDateTime hSalida){
        Duration duracion = Duration.between(hEntrada, hSalida);
        //long horas = duracion.toHours();
        long horas = duracion.toSeconds();
        return horas;
    }
    
    public void imprimirTicket(Ticket ticket){
        ParkingManager.ticket ++;
        
        System.out.println("No Ticket: " + ParkingManager.ticket + "\n"+
                       "Hora Inicio: " + ticket.gethInicio() + "\n" +
                       "Hora salida: " + ticket.gethFinal()  + "\n" +
                       "Horas Facturadas: " + ticket.getDuracion() + "\n" +
                       "Vehiculo: " + ticket.getTipo() + "\n" +
                       "Placa: " + ticket.getPlaca() + "\n" +
                       "Recargo: " + ticket.getRecargo() + "\n" +
                       "Costo total: " + ticket.getCostoTotal() +"\n" +
                       "---------------------------\n"
        );
        
    
    }
    
    
}
