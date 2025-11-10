/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parqueo.javafx.dominio;

import java.time.LocalDateTime;

/**
 *
 * @author Jairo F
 */
public class RegistroParking {
    
    private int id;
    private LocalDateTime hInicio;
    private LocalDateTime hFinal;
    private double duracion;
    private IFacturable vehiuclo;
    private double costoTotal;
    private boolean activo;

    public RegistroParking(IFacturable vehiuclo) {
        this.hInicio = LocalDateTime.now();
        this.vehiuclo = vehiuclo;
        this.activo=true;
    }

    public RegistroParking() {
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the hInicio
     */
    public LocalDateTime gethInicio() {
        return hInicio;
    }

    /**
     * @param hInicio the hInicio to set
     */
    public void sethInicio(LocalDateTime hInicio) {
        this.hInicio = hInicio;
    }

    /**
     * @return the hFinal
     */
    public LocalDateTime gethFinal() {
        return hFinal;
    }

    /**
     * @param hFinal the hFinal to set
     */
    public void sethFinal(LocalDateTime hFinal) {
        this.hFinal = hFinal;
    }

    /**
     * @return the duracion
     */
    public double getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    /**
     * @return the vehiuclo
     */
    public IFacturable getVehiuclo() {
        return vehiuclo;
    }

    /**
     * @param vehiuclo the vehiuclo to set
     */
    public void setVehiuclo(IFacturable vehiuclo) {
        this.vehiuclo = vehiuclo;
    }

    /**
     * @return the costoTotal
     */
    public double getCostoTotal() {
        return costoTotal;
    }

    /**
     * @param costoTotal the costoTotal to set
     */
    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    /**
     * @return the activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    
}
