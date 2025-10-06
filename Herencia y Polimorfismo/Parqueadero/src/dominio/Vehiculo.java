/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author Jairo F
 */
public abstract class Vehiculo {
    
    private long idTicket;
    private static long id =0;
    
   private LocalDateTime hEntrada;
   private LocalDateTime hSalida;

    public Vehiculo() {
        id++;
        this.idTicket=id;
    }

    public Vehiculo(LocalDateTime hEntrada, LocalDateTime hSalida) {
        this();
        this.hEntrada = hEntrada;
        this.hSalida = hSalida;
    }

    /**
     * @return the idTicket
     */
    public long getIdTicket() {
        return idTicket;
    }

    /**
     * @param idTicket the idTicket to set
     */
    public void setIdTicket(long idTicket) {
        this.idTicket = idTicket;
    }

    /**
     * @return the id
     */
    public static long getId() {
        return id;
    }

    /**
     * @param aId the id to set
     */
    public static void setId(long aId) {
        id = aId;
    }

    /**
     * @return the hEntrada
     */
    public LocalDateTime gethEntrada() {
        return hEntrada;
    }

    /**
     * @param hEntrada the hEntrada to set
     */
    public void sethEntrada(LocalDateTime hEntrada) {
        this.hEntrada = hEntrada;
    }

    /**
     * @return the hSalida
     */
    public LocalDateTime gethSalida() {
        return hSalida;
    }

    /**
     * @param hSalida the hSalida to set
     */
    public void sethSalida(LocalDateTime hSalida) {
        this.hSalida = hSalida;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "idTicket=" + idTicket + ", hEntrada=" + hEntrada + ", hSalida=" + hSalida + 
                ", horas=" + this.duracionHoras()+ '}';
    }
    
    public long duracionHoras(){
        Duration duracion = Duration.between(this.gethEntrada(), this.gethSalida());
        long horas = duracion.toHours();
        return horas;
    }
   
   public abstract double calcularCostoParqueo();
    
}
