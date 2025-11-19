/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examplecommand;

/**
 *
 * @author Jairo F
 */
public class TVReceiver implements Receivers {
    
    private boolean estado;
    private int volume;
    private int channel;
    

    @Override
    public void encender() {
        
        this.estado=true;
        System.out.println("La Tv esta encendida");
        
    }

    @Override
    public void configurar() {
        this.channel=10;
        this.volume=30;
    }

    @Override
    public void apagar() {
        this.estado=false;
    }
    
}
